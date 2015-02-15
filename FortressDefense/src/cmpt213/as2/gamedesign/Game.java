package cmpt213.as2.gamedesign;

import java.util.*;
import cmpt213.as2.userinterface.*;


public class Game {

	static boolean game_state;

	public static void main(String[] args) {

		game_state = true;

		// Game start
		while (!game_state) {
		}
		
		Castle mainCastle = new Castle();
		
		Display.displayHealth(mainCastle);

		Scanner input = new Scanner(System.in);
		System.out.print("Enter your move: ");
		String userChoice = input.nextLine();
		System.out.println();
		
		

		// TODO Auto-generated method stub

	}

}
