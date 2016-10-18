import java.util.Hashtable;
import java.util.LinkedList;

public class IVoteService 
{
	private int[] counter; //holds # of people who chose that answer
	private Hashtable<String, LinkedList<Integer>> votes; //keeps track of who has votes and what they voted for
	
	public IVoteService(Question q)
	{		
		counter = new int[q.getAnswers().size()];
		for(int i = 0; i < counter.length; i++) //set all values to 0
		{
			counter[i] = 0; 
		}
	}
	public void vote(Student s) //takes a students answer and adds it to the counter (keeps track of votes for each answer)
	{
		votes = new Hashtable<String, LinkedList<Integer>>();
		
		LinkedList<Integer> studentAnswers = s.submitAnswer();
		
		if(votes.contains(s.getID())) //if they already voted, take out their past vote, include new vote, update their vote
		{
			LinkedList<Integer> oldAnswers = votes.get(s.getID()); //get the old list of answers
			for(int i = 0; i < oldAnswers.size(); i++) //remove them from vote tally
			{
				counter[oldAnswers.get(i)] --;
			}
			
			for(int i = 0; i < studentAnswers.size(); i++) //add new votes to the vote tally
			{
				counter[studentAnswers.get(i)] ++;
			}
			votes.put(s.getID(), studentAnswers); //update hashtable with new value for that ID
		}
		else
		{
			for(int i = 0; i < studentAnswers.size(); i++) //add new votes to the vote tally
			{
				counter[studentAnswers.get(i)] ++;
			}
			votes.put(s.getID(), studentAnswers); //add voter and their votes to hashtable
		}
	}
	public int[] getCount()
	{
		return counter;
	}
}
