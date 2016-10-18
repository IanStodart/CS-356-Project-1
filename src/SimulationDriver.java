import java.util.LinkedList;
import java.util.Random;

public class SimulationDriver 
{
	public static void main(String[] args)
	{
		Question question = createQuestionType();
		LinkedList<Student> students = genStudents();
		IVoteService iVote = new IVoteService(question);
		selectVotes(question, students);
		submitVotes(iVote,students);
		printResults(question,iVote, students);
	}
	private static Question createQuestionType() //created either multiple choice or single choice question at rando
	{
		Question q;
		
		Random rand = new Random();
		int r = rand.nextInt(2);
		
		if(r == 0)
		{
			System.out.println("Multiple choice question");
			q = new MCQuestion();
		}
		else
		{
			System.out.println("Single choice question");
			q = new SCQuestion();
		}
		return q;
	}
	private static LinkedList<Student> genStudents() //creates a group of students and gives them all ID numbers
	{
		LinkedList<Student> students = new LinkedList<Student>();
		
		Random rand = new Random();
		int r = rand.nextInt(20)+21; //create up to 40 students
		
		for(int i = 0; i < r; i++)
		{
			students.add(new Student(Integer.toString(rand.nextInt(100)+1))); //give them an ID number from 1 to 100
		}
		return students;
	}
	private static void selectVotes(Question q, LinkedList<Student> students) //have all students decide what they will answer
	{
		for(int i = 0; i < students.size(); i++)
		{
			students.get(i).selectAnswer(q);
		}
	}
	private static void submitVotes(IVoteService iVote, LinkedList<Student> students) //add all answers to the counter
	{
		for(int i = 0; i < students.size(); i++)
		{
			iVote.vote(students.get(i));
		}
	}
	private static void printResults(Question q, IVoteService iVote, LinkedList<Student> students) //print votes
	{
		System.out.println("Number of students answering question : " + students.size());
		for(int i = 0; i < q.getAnswers().size(); i++)
		{
			System.out.println(q.getAnswers().get(i) + " : " + iVote.getCount()[i]);
		}
	}
}
