package basicWhistGame;

import java.util.Comparator;

public class CardSorter implements Comparator<Card>
{
	public int compare(Card c1, Card c2)
	{
		return (c1.getSuit().compareTo(c2.getSuit()) == 0 ? c1.getRank() - c2.getRank() : c1.getSuit().compareTo(c2.getSuit()));
	}
}
