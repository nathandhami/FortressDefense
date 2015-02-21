package cmpt213.as2.userinterface;

import cmpt213.as2.gamedesign.Castle;

import cmpt213.as2.gamedesign.Tank;

public class Display {
	
	public static void gameWon(){
		System.out.println("Congratulations You Won!");
	}
	
	public static void gameLost(){
		System.out.println("You Lose! Your castle has been destroyed.");
	}
	
	public static void displayHealth(int strength){
		
		System.out.println("Fortress Health: " + strength);
	}
	
	public static void displayHitOrMiss(boolean tankFound){
		if(tankFound == true){
			System.out.println("HIT!");
		}
		else{
			System.out.println("MISS!");
		}
	}
	
	public static void displayTankDamageDone(Tank tank){
		System.out.println("You were shot for: " + tank.fireWeapon());
	}
	
	public static void displayError(){
		System.out.println("Invalid move! ");
	}
	
	public static void displayMap(int map[][]){
		
		char content;
		char letter;
		
		for(int i=0; i<10; i++){
			
			System.out.print("\t" + i);
		}
		System.out.println();
		
		for(int i=0; i<10; i++){
			
			System.out.print((char)('A'+i));
			
			for(int j=0; j<10; j++){
				
				if(map[i][j]==0) content ='.';
				else if(map[i][j]==1) content ='X';
				else content = '~';
				
				System.out.print("\t" + content);
			}
			System.out.println();
		}
	}

}
