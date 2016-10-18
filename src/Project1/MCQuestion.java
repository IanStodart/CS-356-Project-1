package Project1;

import java.util.LinkedList;
import java.util.Random;

public class MCQuestion extends Question
{
	
	public MCQuestion() // Single choice question only has 2 answers, yes and no
	{
		super.answers = new LinkedList<String>();
		Random r = new Random();
		int rand = r.nextInt(5)+3;
		for(int i = 0; i < rand; i++)
		{
			answers.add(("" + (char)(65+i)).toString()); // add A-H to the answers
		}
	}
}
