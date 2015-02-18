package cmpt213.as2.gamedesign;

import java.util.*;

import cmpt213.as2.userinterface.*;


public class Game {

	static int userX;
	static int userY;
	static int asciiStart = 16;
	static boolean game_state;
	static boolean is_error;

	public static void main(String[] args) {

		game_state = true;
	
		
		// Game start
		while (!game_state) {
		}
		
		Castle mainCastle = new Castle();
		Tank[] tanks = new Tank[5];
		for(int i=0; i<5; i++){
			tanks[i] = new Tank();
		}
		
		Cell mapTracker = new Cell();
		
		while(game_state){
			
			Display.displayMap(mapTracker.getMap());
			Display.displayHealth(mainCastle.getStrength());

			Scanner input = new Scanner(System.in);
			System.out.print("Enter your move: ");
			String userChoice = input.nextLine();
			System.out.println();
			breakInput(userChoice);
			
		}

	

	}

	public static void breakInput(String userChoice) {
		
		if(userChoice.length()!=2){
			is_error = true;
		}
		else{
			userX = Character.toUpperCase(userChoice.charAt(0)) - asciiStart;
			userX = Character.getNumericValue(userX);
			userY = Character.getNumericValue((userChoice.charAt(1)));	
		}
		
		if(userX<1 || userX>10 ) is_error = true;
		else if(userY<1 || userY>10) is_error = true;
		
		if(is_error){
			//handle error; method in Display.
		}
	}

}
