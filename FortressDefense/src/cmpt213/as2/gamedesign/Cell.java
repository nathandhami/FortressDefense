package cmpt213.as2.gamedesign;

public class Cell {
	
	private int map[][];
	private int foggyMap[][];
	
	
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
	
	
	void assignLocation(int tank_location[][]){
		
	}
	
	// Game in progress map
	int[][] getMap(){
		return foggyMap;
	}
	
	// Game end map reveal
	int[][] getFullMap(){
		return map;
	}
	
	boolean doesTankExist(int x,int y){
		
		if(map[x][y] == 1){
			return true;
		}
		
		else{
			return false;
		}
	}
	
	
	void updateMap(){
	}
	
	

}
