package basicWhistGame;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class BasicTrickGame {
	private final int NUM_OF_PLAYERS;
	//private boolean gameOver = false;
	private static final List<Card> FULL_DECK = Collections.unmodifiableList(basicDeck());
	private Player[] players;
	
	public BasicTrickGame()
	{
		NUM_OF_PLAYERS = 4;
		players = new Player[NUM_OF_PLAYERS];
		players[0] = new HumanPlayer();
		for(int i = 1; i < NUM_OF_PLAYERS; i ++)
		{
			players[i] = new ComputerPlayer();
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
		sortHands();
		//display();
		int lead = 0;
		for(int i = 0; i < FULL_DECK.size()/NUM_OF_PLAYERS; i ++)
		{
			lead = runTrick(lead);
		}
	}
	
	public int runTrick(int leadNum) //returns number of winner
	{
		Trick currentTrick = new Trick();
		for(int i = leadNum; i != leadNum + NUM_OF_PLAYERS; i ++)
		{
			currentTrick.add(players[i%NUM_OF_PLAYERS].playCard());
			System.out.println(currentTrick);
		}
		int winner = (currentTrick.determineWinner() + leadNum)%NUM_OF_PLAYERS;
		System.out.println(winner);
		players[winner].collectTrick(currentTrick);
		return winner;
	}
	
	public void sortHands()
	{
		for(Player p : players)
		{
			p.sortHand();
		}
	}
	
	public void display()
	{
		for(Player p : players)
		{
			for(Card c : p.getHand())
			{
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}
	
	public void setValues()
	{
		for(Player p : players)
		{
			for(Card c : p.getHand())
			{
				c.setValue(0);
			}
		}
	}
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
