package cmpt213.as2.gamedesign;

import java.util.*;

import cmpt213.as2.userinterface.*;


public class Game {

	static int userX;
	static int userY;
	static int asciiStart = 17;
	static boolean game_state;
	static boolean is_error;

	public static void main(String[] args) {

		game_state = true;
	
		
		// Game start
		while (!game_state) {
		}
		
		Castle mainCastle = new Castle();
		
		
		Cell mapTracker = new Cell();
		
		
		Tank[] tanks = new Tank[5];
		for(int i=0; i<5; i++){
			tanks[i] = new Tank();
		}
		
		// assign locations
		Display.displayStartPoints(tanks[0]);
		Display.displayStartPoints(tanks[1]);
		Display.displayStartPoints(tanks[2]);
		Display.displayStartPoints(tanks[3]);
		Display.displayStartPoints(tanks[4]);
		mapTracker.assignLocation(tanks[0].getLocation());
		
		while(game_state){
			Display.displayMap(mapTracker.getMap());
			Display.displayHealth(mainCastle.getStrength());

			Scanner input = new Scanner(System.in);
			System.out.print("Enter your move: ");
			String userChoice = input.nextLine();
			System.out.println();
			breakInput(userChoice);
			
			if(mapTracker.doesTankExist(userX, userY) == true){
				boolean exist = true;
				Display.displayHitOrMiss(exist);;
				tanks[0].loseHealth();
				for(int i =0; i < 5; i ++){
					if(tanks[i].is_Empty()){
						
					}
					else{
						mainCastle.decStrength(tanks[i].fireWeapon());
						Display.displayTankDamageDone(tanks[i]);
					}
				}
				mapTracker.updateMap(userX, userY);
			}
			else{
				Display.displayHitOrMiss(false);;
				for(int i =0; i < 5; i ++){
					if(tanks[i].is_Empty()){
						
					}
					else{
						mainCastle.decStrength(tanks[i].fireWeapon());
						Display.displayTankDamageDone(tanks[i]);
					}
				}
			}
			
			
			// Victory
//			for(int i =0; i < 1; i++){
//				
//				if(tanks[i].is_Empty() == true){
//					game_state = false;
//				}
//				else{
//					game_state = true;
//				}
//			}
//			
//			if(game_state == false){
//			
//				Display.displayMap(mapTracker.getMap());
//				Display.displayHealth(mainCastle.getStrength());
//				Display.gameWon();
//			}
			
			
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
