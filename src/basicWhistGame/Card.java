package basicWhistGame;

public class Card
{
	
	public int rank = 0;
	public int value = 0;
	public Suit suit = Suit.CLUBS;
	
	public Card()
	{
		this.rank = 1;
		this.value = 0;
		this.suit = Suit.CLUBS;
	}
	
	public Card(int rank, Suit suit)
	{
		this.rank = rank;
		this.suit = suit;
		this.value = 0;
	}
	
	public Card(int rank, Suit suit, int value)
	{
		this.rank = rank;
		this.suit = suit;
		this.value = value;
	}
	
	public String toString()
	{
		return rank + "" + suit;
	}

	public int getRank() {
		return rank;
	}

	public int getValue() {
		return value;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	
	
}
