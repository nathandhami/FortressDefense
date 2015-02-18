package cmpt213.as2.gamedesign;

import java.util.Random;

public class Tank {
	
	private int tankHealth;
	private int firePower;
	private int startIndexRow;
	private int startIndexCol;
	private int[][] location;

	
	// Randomize location of the tank
	// NOT DONE
	public Tank(){
		 Random randomGenerator = new Random();
		 startIndexRow = randomGenerator.nextInt(9);
		 startIndexCol = randomGenerator.nextInt(9);
		location = new int[10][10];
		location[startIndexRow][startIndexCol] =1;
		tankHealth = 4;
		firePower = 20;
		
		
	}
	
	public int getStartingRow(){
		return startIndexRow;
	}
	
	public int getStartingCol(){
		return startIndexCol;
	}
	
	
	public int loseHealth(){
		tankHealth--;

		switch(tankHealth){
		case 3: 
			firePower =5;
		break;
		case 2:
			firePower = 3;
			break;
		case 1:
			firePower = 1;
			break;
			
		default:
			firePower =0;
		}
		
		return tankHealth;
	}
	
	public int[][] getLocation(){

		return location;
	}
	
	public int[][] setLocation(int x, int y){
		location[x][y]=1;
		return location;
		
	}
	
	public int fireWeapon(){
		return firePower;
	}
	
	
	// returns true if all tanks destroyed
	public boolean is_Empty(){
		
		if(tankHealth ==0){
			return true;
		}
		else{
		return false;
		}
	}

}
