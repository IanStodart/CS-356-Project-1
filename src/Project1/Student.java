package Project1;

import java.util.Random;

public class Student 
{
	private String ID;
	
	public Student(String s)
	{
		ID = s;
	}
	public String getID()
	{
		return ID;
	}
	public int submitAnswer(Question Q) //have student choose a random answer
	{
		Random r = new Random();
		int n = r.nextInt(Q.getAnswers().size());
		
		return n;
	}
}
