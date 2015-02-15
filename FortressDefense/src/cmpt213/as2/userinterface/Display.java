package cmpt213.as2.userinterface;

import cmpt213.as2.gamedesign.Castle;

public class Display {
	
	public static void displayHealth(Castle userInput){
		
		System.out.println("Fortress Health: " + userInput.getStrength());
	}

}
