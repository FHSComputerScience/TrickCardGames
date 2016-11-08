package basicWhistGame;

import java.util.ArrayList;
import java.util.Collections;

public class Player {
	ArrayList<Trick> takenTricks = new ArrayList<Trick>();
	ArrayList<Card> hand = new ArrayList<Card>();
	CardSorter sorter = new CardSorter();
	
	public Player()
	{
		// TODO Auto-generated constructor stub
	}
	
	public void sortHand()
	{
		Collections.sort(hand, sorter);
	}
	
	public Card playCard()
	{
		return hand.remove(0);
	}
	
	public void collectTrick(Trick t)
	{
		this.takenTricks.add(t);
	}
	
	public ArrayList<Trick> getTakenTricks() {
		return takenTricks;
	}
	public void setTakenTricks(ArrayList<Trick> takenTricks) {
		this.takenTricks = takenTricks;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
}
