package cmpt213.as2.gamedesign;

import java.util.*;
import cmpt213.as2.userinterface.*;

/*Controls game logic.
 * It is responsible for interacting with every other class manage it as game goes on.*/

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
			
			mapTracker.assignLocation(tanks[i].getLocation());
			Display.displayMap(tanks[i].getLocation());
		}
		
		Display.displayMap(mapTracker.getFullMap());
		
		while(game_state){
			Display.displayMap(mapTracker.getMap());
			Display.displayHealth(mainCastle.getStrength());

			Scanner input = new Scanner(System.in);
			System.out.print("Enter your move: ");
			String userChoice = input.nextLine();
			System.out.println();
			breakInput(userChoice);
			while(is_error){
				System.out.print("Enter your move: ");
				userChoice = input.nextLine();
				System.out.println();
				breakInput(userChoice);
			}
			
			
			if(mapTracker.doesTankExist(userX, userY) == true){
				boolean exist = true;
				Display.displayHitOrMiss(exist);
				
				int whichTank=0;
				for(int i=0; i<5; i++){
					if(tanks[i].whichTankExist(userX, userY)){
						whichTank=i;
						break;
					}
				}
				tanks[whichTank].loseHealth();
				
				for(int i =0; i < 5; i ++){
					if(tanks[i].is_Empty()){
						
					}
					else{
						mainCastle.decStrength(tanks[i].fireWeapon());
						Display.displayTankDamageDone(tanks[i]);
					}
				}
				
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
			for(int i =0; i < 5; i++){
				
				if(tanks[i].is_Empty() == true){
					game_state = false;
				}
				else{
					game_state = true;
					break;
				}
			}
			
			// Lost
			if(mainCastle.getStrength()<0){
				game_state=false;
				
			}
			
		// Game Over
		}
		if(!game_state){
			
			if(mainCastle.getStrength()<0){
				Display.displayMap(mapTracker.getFullMap());
				Display.gameLost();
				
			}
			else{
				Display.displayHealth(mainCastle.getStrength());
				Display.displayMap(mapTracker.getFullMap());
				Display.gameWon();
				
			}
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
			is_error = false;
			
			if(userX<0 || userX>=10 ) is_error = true;
			else if(userY<0 || userY>=10) is_error = true;
			else is_error = false;
		}
		
		if(is_error){
			Display.displayError();
		}
	}

}
