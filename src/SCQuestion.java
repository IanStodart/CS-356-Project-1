import java.util.LinkedList;
import java.util.Random;

public class SCQuestion extends Question //Single choice question allows the student to select only 1 answer from a list of possible answers
{
	public SCQuestion() // call super constructor
	{
		super();
	}
	public LinkedList<Integer> answerQuestion()
	{
		Random r = new Random();

		LinkedList<Integer> answers = new LinkedList<Integer>();
		for(int i = 0; i < 1; i++) //create list of random answers with size 1
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
