package cmpt213.as2.gamedesign;

import java.util.Random;

public class Cell {
	
	private int map[][];
	private int foggyMap[][];
	
	private boolean occupiedCell[][];
	private final int UP = 3;
	private final int LEFT = 2;
	private final int RIGHT = 1;
	private final int DOWN = 0;
	
	
	public Cell(){
		map = new int[10][10];
		foggyMap = new int[10][10];
		occupiedCell = new boolean[10][10];
		for(int i=0; i<10; i++){
			for(int j=0; j<10; j++){
				map[i][j]=0;			//0 for '.'
				foggyMap[i][j]=-1;  	//1 for 'X'
										//-1 for '~'.
				
			}
		}
	}
	
	
	public void assignLocation(int tank_location[][]){
		
		 Random randomGenerator = new Random();
		 int startIndexRow = randomGenerator.nextInt(8) + 1;
		 int startIndexCol = randomGenerator.nextInt(8) + 1;
		 tank_location[startIndexRow][startIndexCol] = 1;
		 map[startIndexRow][startIndexCol] = 1;
		 int numDone=1;
		 int numLeft=3;
		 int index = 0;
		 int next= 0; 
		 boolean alreadyTaken = false;
		 
		 for(int i=0; i<numLeft; i++){
			 
			 for(int j=0; j<numDone;j++){
				 index = randomGenerator.nextInt(4);
				 alreadyTaken=false;
				 
				 if(index == DOWN && !alreadyTaken){
					 if(map[startIndexRow][startIndexCol+1]==1){
						 index = (index + 1) % 3;
						 alreadyTaken = true;
						 j--;
						 
					 }
					 
					 if(!alreadyTaken){
						 if(j<=0){
							 next=startIndexCol+1; 
						 }
						 else next=next+1;
						 
						 map[startIndexRow][next] = 1;
						 tank_location[startIndexRow][next] = 1; 
					 }
					 
				 }
				 else if(index == LEFT && !alreadyTaken){
					 if(map[startIndexRow-1][startIndexCol]==1){
						 index = (index + 1) % 3;
						 alreadyTaken = true;
						 j--;
						 
					 }
					 if(!alreadyTaken){
						 
						 if(j<=0){
							 next=startIndexRow-1; 
						 }
						 else next=next+1;
						 
						 map[next][startIndexCol] = 1;
						 tank_location[next][startIndexCol] = 1;
					 }
					 
				 }
				 else if(index == RIGHT && !alreadyTaken){
					 if(map[startIndexRow+1][startIndexCol]==1){
						 index = (index + 1) % 3;
						 alreadyTaken = true;
						 j--;
						 
					 }
					 
					 if(!alreadyTaken){
						 if(j<=0){
							 next=startIndexRow+1; 
						 }
						 else next=next+1;
						 
						 map[next][startIndexCol] = 1;
						 tank_location[next][startIndexCol] = 1;
					 }
					 
				 }
				 else if(index == UP && !alreadyTaken){
					 if(map[startIndexRow][startIndexCol-1]==1){
						 index = (index + 1) % 3;
						 alreadyTaken = true;
						 j--;

					 }
					 
					 if(!alreadyTaken){
						
						 if(j<=0){
							 next=startIndexCol-1; 
						 }
						 else next=next+1;
						 
						 map[startIndexRow][next] = 1;
						 tank_location[startIndexRow][next] = 1;
					 }
					 
				 }
			 }
		 }

		 

	}
	
	
	// Game in progress map
	public int[][] getMap(){
		return foggyMap;
	}
	
	// Game end map reveal
	public int[][] getFullMap(){
		return map;
	}
	
	public boolean doesTankExist(int x,int y){
		
		if(map[x][y] == 1){
			foggyMap[x][y] = 1;
			return true;
		}
		foggyMap[x][y] = 0;
		return false;
		
	}
	
	
	public void updateMap(int x , int y){
		
//		foggyMap[x][y] = 1;
		
	}

	

}
