package Project1;

import java.util.LinkedList;

public class SCQuestion extends Question
{
	public int size;
	
	public SCQuestion() // Single choice question only has 2 answers, yes and no
	{
		super.answers = new LinkedList<String>();
		size = 2;
		super.answers.add("Yes");
		super.answers.add("No");
	}
}
