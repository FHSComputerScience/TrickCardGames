package basicWhistGame;

import java.util.ArrayList;
import java.util.Comparator;

public class Trick extends ArrayList<Card>
{
	int numDown = 0;
	public Trick(int length)
	{
		for(int i = 0; i < length; i ++)
		{
			this.add(new Card());
		}
	}
	
	public int getWinner()
	{
		if(numDown != this.size())
		{
			return -1;
		}
		int winnerNum = 0;
		for(int i = 1; i < this.size(); i ++)
		{
			if(compare(this.get(i),this.get(winnerNum)) > 0)
			{
				winnerNum = i;
			}
		}
		return winnerNum;
	}
}
