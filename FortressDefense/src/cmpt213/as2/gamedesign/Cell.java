package cmpt213.as2.gamedesign;

public class Cell {
	
	private int map[][];
	private int foggyMap[][];
	private boolean tankLocation[][];
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
				occupiedCell = new boolean[10][10];
			}
		}
	}
	
	
	void assignLocation(int tank_location[][]){
		for(int i =0; i < 10;i++){
			for(int j =0; j < 10; j++){
				if(tank_location[i][j] == 1){
					map[i][j] = 1;
					occupiedCell[i][j] = true;
				}
			}
		}

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
			foggyMap[x][y] = 1;
			return true;
		}
		
		else{
			foggyMap[x][y] = 0;
			return false;
		}
	}
	
	
	void updateMap(int x , int y){
		
//		foggyMap[x][y] = 1;
		
	}

	

}
