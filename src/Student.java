import java.util.LinkedList;

public class Student 
{
	private String ID;
	private LinkedList<Integer> myAnswer;
	
	public Student(String s) 
	{
		ID = s;
	}
	public String getID()
	{
		return ID;
	}
	public void selectAnswer(Question Q) //pick answer to question
	{
		myAnswer = Q.answerQuestion();
	}
	
	public LinkedList<Integer> submitAnswer() //send students answer to caller
	{
		return myAnswer;
	}
}
