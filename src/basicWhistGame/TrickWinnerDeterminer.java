package basicWhistGame;

import java.util.Comparator;

public class TrickWinnerDeterminer implements Comparator<Card>
{
	public int compare(Card c1, Card c2)
	{
		if(c1.getSuit() != c2.getSuit())
		{
			return 1;
		}
		else
		{
			return c1.getRank() - c2.getRank();
		}
	}
}
