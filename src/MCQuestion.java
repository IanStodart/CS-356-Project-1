import java.util.LinkedList;
import java.util.Random;

public class MCQuestion extends Question //Multiple choice question allows the student to select more than 1 answer from a list of possible answers
{
	
	public MCQuestion() // Call super constructor
	{
		super();
	}
	public LinkedList<Integer> answerQuestion()
	{
		Random r = new Random();
		int n = r.nextInt(super.size);
		LinkedList<Integer> answers = new LinkedList<Integer>();
		for(int i = 0; i < n; i++) //create list of random answers with random size
		{
			int a = r.nextInt(super.size);
			while(answers.contains(a)) //if this answer has already been selected, choose another one
			{
				a = r.nextInt(super.size);
			}
			
			answers.add(a);
		}
		
		return answers;
	}
}
