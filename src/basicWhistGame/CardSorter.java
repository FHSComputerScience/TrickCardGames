package basicWhistGame;

import java.util.Comparator;

public class CardSorter implements Comparator<Card>
{
	public int compare(Card c1, Card c2)
	{
		if(c1.getSuit().compareTo(c2.getSuit()) == 0)
		{
			return c1.getRank() - c2.getRank();
		}
		else
		{
			return c1.getSuit().compareTo(c2.getSuit());
		}
	}
}
