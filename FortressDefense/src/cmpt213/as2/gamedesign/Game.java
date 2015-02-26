package cmpt213.as2.gamedesign;

import java.util.*;
import cmpt213.as2.userinterface.*;

/*Controls game logic.
 * It is responsible for interacting with every other class manage it as game goes on.*/

public class Game {

	private static int userX;
	private static int userY;
	private static int asciiStart = 17;
	private static boolean game_state;
	private static boolean is_error;

	public static void main(String[] args) {

		game_state = true;

		Castle mainCastle = new Castle();
		Cell mapTracker = new Cell();
		int numberOfTanks = 5;

		Tank[] tanks = new Tank[numberOfTanks];
		for (int i = 0; i < numberOfTanks; i++) {
			tanks[i] = new Tank();
			mapTracker.assignLocation(tanks[i].getLocation());
		}

		Display.displayMap(mapTracker.getFullMap());

		while (game_state) {
			Display.displayMap(mapTracker.getMap());
			Display.displayHealth(mainCastle.getStrength());

			Scanner input = new Scanner(System.in);
			System.out.print("Enter your move: ");
			String userChoice = input.nextLine();
			System.out.println();
			breakInput(userChoice);
			while (is_error) {
				System.out.print("Enter your move: ");
				userChoice = input.nextLine();
				System.out.println();
				breakInput(userChoice);
			}

			if (mapTracker.doesTankExist(userX, userY) == true) {
				userFindsTank(mainCastle, tanks, numberOfTanks);

			} else {
				userMissesTank(mainCastle, tanks, numberOfTanks);
			}

			checkForVictory(mainCastle, tanks);
		}

		if (!game_state) {
			gameWinOrLose(mainCastle, mapTracker);
		}
	}

	private static void userMissesTank(Castle mainCastle, Tank[] tanks,
			int numberOfTanks) {
		
		Display.displayHitOrMiss(false);

		for (int i = 0; i < numberOfTanks; i++) {
			if (tanks[i].is_Empty()) {

			} else {
				mainCastle.decStrength(tanks[i].fireWeapon());
				Display.displayTankDamageDone(tanks[i]);
			}
		}
	}

	private static void userFindsTank(Castle mainCastle, Tank[] tanks,
			int numberOfTanks) {
		
		boolean exist = true;
		Display.displayHitOrMiss(exist);

		int whichTank = 0;
		for (int i = 0; i < numberOfTanks; i++) {
			if (tanks[i].whichTankExist(userX, userY)) {
				whichTank = i;
				break;
			}
		}
		tanks[whichTank].loseHealth();

		for (int i = 0; i < numberOfTanks; i++) {
			if (tanks[i].is_Empty()) {

			} else {
				mainCastle.decStrength(tanks[i].fireWeapon());
				Display.displayTankDamageDone(tanks[i]);
			}
		}
	}

	private static void gameWinOrLose(Castle mainCastle, Cell mapTracker) {
		if (mainCastle.getStrength() <= 0) {
			Display.displayMap(mapTracker.getFullMap());
			Display.gameLost();

		} else {
			Display.displayMap(mapTracker.getMap());
			Display.displayHealth(mainCastle.getStrength());
			Display.gameWon();
		}
	}

	private static void checkForVictory(Castle mainCastle, Tank[] tanks) {
		for (int i = 0; i < 5; i++) {
			if (tanks[i].is_Empty() == true) {
				game_state = false;
			} else {
				game_state = true;
				break;
			}
		}

		if (mainCastle.getStrength() <= 0) {
			game_state = false;

		}
	}

	public static void breakInput(String userChoice) {

		if (userChoice.length() != 2 && userChoice.length() != 3) {
			is_error = true;
		} else {
			userX = Character.toUpperCase(userChoice.charAt(0)) - asciiStart;
			userX = Character.getNumericValue(userX);
			if (userChoice.length() == 3) {
				userY = Character
						.getNumericValue((userChoice.charAt(1) + userChoice
								.charAt(2))) - 1;
			} else {
				userY = Character.getNumericValue((userChoice.charAt(1))) - 1;
			}

			is_error = false;

			int minimumIndex = 0;
			int maximumIndex = 10;

			if (userX < minimumIndex || userX >= maximumIndex)
				is_error = true;
			else if (userY < minimumIndex || userY >= maximumIndex)
				is_error = true;
			else
				is_error = false;
		}

		if (is_error) {
			Display.displayError();
		}
	}

}
