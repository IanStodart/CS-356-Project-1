package Project1;

import java.util.LinkedList;
import java.util.Random;

public class SimulationDriver 
{
	public static void main(String[] args)
	{
		Question question = createQuestionType();
		LinkedList<Student> students = genStudents();
		IVoteService iVote = new IVoteService(question);
		submitVotes(iVote,students);
		printResults(question,iVote);
	}
	private static Question createQuestionType()
	{
		Question q;
		
		Random rand = new Random();
		int r = rand.nextInt(2);
		
		if(r == 0)
		{
			q = new MCQuestion();
		}
		else
		{
			q = new SCQuestion();
		}
		return q;
	}
	private static LinkedList<Student> genStudents()
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
	private static void submitVotes(IVoteService iVote, LinkedList<Student> students)
	{
		for(int i = 0; i < students.size(); i++)
		{
			iVote.vote(students.get(i));
		}
	}
	private static void printResults(Question q, IVoteService iVote)
	{
		for(int i = 0; i < q.getAnswers().size(); i++)
		{
			System.out.println(q.getAnswers().get(i) + " : " + iVote.getCount()[i]);
		}
	}
}
