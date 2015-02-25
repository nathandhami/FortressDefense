package cmpt213.as2.gamedesign;

import java.util.Random;

/*Cell keeps track of the field map. 
 * It also assigns locations to tanks randomly
 * Methods are called to update and check if tank exists or not.*/


public class Cell {
	
	private int map[][];
	private int foggyMap[][];
	
	private final int LEFT = 3;
	private final int UP = 2;
	private final int DOWN = 1;
	private final int RIGHT = 0;
	
	
	public Cell(){
		map = new int[10][10];
		foggyMap = new int[10][10];
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
		 int startIndexRow = randomGenerator.nextInt(10);
		 int startIndexCol = randomGenerator.nextInt(10);
		 
		 //check if tank already exists
		 if(canTankBePlaced(startIndexRow, startIndexCol)){
			 startIndexRow = randomGenerator.nextInt(10);
			 startIndexCol = randomGenerator.nextInt(10);
		 }
		 tank_location[startIndexRow][startIndexCol] = 1;
		 map[startIndexRow][startIndexCol] = 1;
		 
		 int numDone=1;
		 int numLeft=3;
		 int index = 0;
		 
		 int nextRow = startIndexRow; 
		 int nextColumn = startIndexCol; 
		 int whichStartingCell = 0;
		 boolean alreadyTaken = false;
		 
		 
		 for(int i=0; i<numLeft; i++){
			 
			 whichStartingCell = randomGenerator.nextInt(numDone);
			 alreadyTaken = false;
			 
			 for(int j=0; j<numDone;j++){
				 
				 if(j != whichStartingCell);
				 
				 else{
					 
					 if(!alreadyTaken){
						 index = randomGenerator.nextInt(4); 
					 }
					 
					 alreadyTaken=false;
					 
					 if(index == RIGHT && !alreadyTaken){
					
						 //this has to execute at least once when 2nd tank cell is chosen.
						 if(j<=0){
							 nextRow = startIndexRow; 
							 nextColumn = startIndexCol + 1;
						 }
						 else nextColumn = nextColumn + 1;
						 
						 //checks if cell is already taken 
						 if(nextColumn>=10 || map[nextRow][nextColumn]==1){
							 index = (index + 1) % 4;
							 alreadyTaken = true;
							 nextColumn = nextColumn - 1;
							 j--;
							 
						 }
						 
						 if(!alreadyTaken){
							 
							 map[nextRow][nextColumn] = 1;
							 tank_location[nextRow][nextColumn] = 1; 
						 }
						 
					 }
					 else if(index == UP && !alreadyTaken){
						 
						 if(j<=0){
							 nextRow = startIndexRow - 1; 
							 nextColumn = startIndexCol; 
						 }
						 else nextRow = nextRow - 1;
						 
						 if(nextRow<0 || map[nextRow][nextColumn]==1){
							 index = (index + 1) % 4;
							 alreadyTaken = true;
							 nextRow = nextRow + 1;
							 j--;
							 
						 }
						 if(!alreadyTaken){

							 
							 map[nextRow][nextColumn] = 1;
							 tank_location[nextRow][nextColumn] = 1; 
						 }
						 
					 }
					 else if(index == DOWN && !alreadyTaken){
						
						 if(j<=0){
							 nextRow = startIndexRow + 1; 
							 nextColumn = startIndexCol;
						 }
						 else nextRow = nextRow + 1;
						 
						 if(nextRow>=10 || map[nextRow][nextColumn]==1){
							 index = (index + 1) % 4;
							 alreadyTaken = true;
							 nextRow = nextRow - 1;
							 j--;
							 
						 }
						 
						 if(!alreadyTaken){
							 
							 map[nextRow][nextColumn] = 1;
							 tank_location[nextRow][nextColumn] = 1; 
						 }
						 
					 }
					 else if(index == LEFT && !alreadyTaken){
						
						 if(j<=0){
							 nextRow = startIndexRow; 
							 nextColumn = startIndexCol - 1;
						 }
						 else nextColumn = nextColumn - 1;
						 
						 if(nextColumn<0 || map[nextRow][nextColumn]==1){
							 index = (index + 1) % 4;
							 alreadyTaken = true;
							 nextColumn = nextColumn + 1;
							 j--;

						 }
						 
						 if(!alreadyTaken){
	
							 map[nextRow][nextColumn] = 1;
							 tank_location[nextRow][nextColumn] = 1; 
						 }
						 
					 }
					 
				 }
				 

			 }
			 numDone++;
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
	
	private boolean canTankBePlaced(int x,int y){
		
		if(map[x][y] == 1){
			
			return true;
		}
		return false;	
	}
	
	public boolean doesTankExist(int x, int y){
		
		if(map[x][y] == 1){
			foggyMap[x][y]=1;
			return true;
		}
		foggyMap[x][y]=0;
		return false;
	}

	
}
