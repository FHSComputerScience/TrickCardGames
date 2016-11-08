package basicWhistGame;

import java.util.Scanner;

public class HumanPlayer extends Player {

	public HumanPlayer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int pickCard() {
		System.out.println(hand);
		Scanner sc = new Scanner(System.in);
		int cardPicked = sc.nextInt();
		return cardPicked;
	}

}
