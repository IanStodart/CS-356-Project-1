package Project1;

import java.util.Hashtable;

public class IVoteService 
{
	private int[] counter; //holds # of people who chose that answer
	private Question question;
	private Hashtable<String, Integer> votes; //keeps track of who has votes and what they voted for
	
	public IVoteService(Question q)
	{		
		question = q;
		counter = new int[q.getAnswers().size()];
		for(int i = 0; i < counter.length; i++) //set all values to 0
		{
			counter[i] = 0; 
		}
	}
	public void vote(Student s)
	{
		Hashtable<String, Integer> votes = new Hashtable<String, Integer>();
		
		int n = s.submitAnswer(question);
		
		if(votes.contains(s.getID())) //if they already voted, take out their past vote, include new vote, update their vote
		{
			counter[votes.get(s.getID())] --;
			counter[n] ++;
			votes.put(s.getID(), n);
		}
		else
		{
			counter[n] ++;
			votes.put(s.getID(), n); //adds voter and their vote to HashTable
		}
	}
	public int[] getCount()
	{
		return counter;
	}
}
