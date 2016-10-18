import java.util.LinkedList;
import java.util.Random;

public abstract class Question 
{
	protected LinkedList<String> answers;
	protected int size;
	
	public Question()
	{
		answers = new LinkedList<String>();
		Random r = new Random();
		int rand = r.nextInt(5)+3; //3-8 possible choices to choose from (2 would make it same as single choice)
		size = rand;
		for(int i = 0; i < rand; i++)
		{
			answers.add(("" + (char)(65+i)).toString()); // add A-H to the answers
		}
	}
	
	public LinkedList<String> getAnswers()
	{
		return answers;
	}
	public abstract LinkedList<Integer> answerQuestion();
	
	public int getSize()
	{
		return size;
	}
	
}
