package basicWhistGame;

import java.util.ArrayList;
import java.util.Collections;

public class Trick extends ArrayList<Card>
{
	TrickWinnerDeterminer decider = new TrickWinnerDeterminer();
	int numDown = 0;
	public Trick()
	{
		
	}
	
	public int determineWinner()
	{
		if(numDown != this.size())
		{
			return -1;
		}
		return indexOf(Collections.max(this, decider));
	}
	
	public String toString()
	{
		String retStr = "";
		for(Card c : this)
		{
			retStr += c + " ";
		}
		return retStr;
	}
	
	@Override
	public boolean add(Card c)
	{
		super.add(c);
		numDown ++;
		return true;
	}
}
