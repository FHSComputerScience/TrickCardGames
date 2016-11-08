package basicWhistGame;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public abstract class BasicTrickGame {
	private final int NUM_OF_PLAYERS;
	private boolean gameOver = false;
	private static final List<Card> FULL_DECK = Collections.unmodifiableList(basicDeck());
	private Player[] players;
	
	public BasicTrickGame() {
		// TODO Auto-generated constructor stub
		NUM_OF_PLAYERS = 4;
		players = new Player[NUM_OF_PLAYERS];
		for(int i = 0; i < NUM_OF_PLAYERS; i ++)
		{
			players[i] = new Player();
		}
	}
	
	public static void main(String[] args)
	{
		WhistGame game = new WhistGame();
		game.run();
	}
	
	public void run()
	{
		deal(shuffle(FULL_DECK));
		for(Player p : players)
		{
			p.sortHand();
		}
		
		for(Player p : players)
		{
			for(Card c : p.getHand())
			{
				System.out.print(c + " ");
			}
			System.out.println();
		}
		if(gameOver)
		{
			System.out.println("gg");
		}
	}
	
	public abstract void setValues(); 
	//Sets point values for individual cards; different for each game.
	//Important: In games such as whist, individual cards do not hold values.
	//In this case, each card can have a value of 0, because each trick will calculate its own value (which will just be "return 1").
	
	public ArrayList<Card> shuffle(List<Card> cardsToShuffle)
	{
		ArrayList<Card> basicDeck = new ArrayList<Card>();
		for(Card c : cardsToShuffle)
		{
			basicDeck.add(c);
		}
		ArrayList<Card> retDeck = new ArrayList<Card>();
		for(int i = 51; i >= 0; i --)
		{
			int r = (int)(Math.random() * i);
			retDeck.add(basicDeck.remove(r));
		}
		return retDeck;
	}
	
	public void deal(ArrayList<Card> deck)
	{
		for(int i = 0; i < FULL_DECK.size(); i ++)
		{
			players[i%4].getHand().add(deck.remove(0));
		}
	}
	
	public static ArrayList<Card> basicDeck()
	{
		ArrayList<Card> deck = new ArrayList<Card>();
		setUpSuit(deck, Suit.CLUBS);
		setUpSuit(deck, Suit.DIAMONDS);
		setUpSuit(deck, Suit.SPADES);
		setUpSuit(deck, Suit.HEARTS);
		return deck;
	}
	private static void setUpSuit(ArrayList<Card> deck, Suit suit)
	{
		for(int i = 1; i <= 13; i ++)
		{
			deck.add(new Card(i, suit));
		}
	}
}
