package cmpt213.as2.gamedesign;

public class Cell {
	
	int map[][];
	
	
	public Cell(){
		map = new int[10][10];
	}
	
	
	// Game in progress mapp
	int[][] getMap(){
		return map;
	}
	
	// Game end map reveal
	int[][] getFullMap(){
		return map;
	}
	
	boolean doesTankExist(int x,int y){
		
		if(map[x][y] == 0){
			return true;
		}
		
		else{
			return false;
		}
	}
	
	
	void updateMap(){
	}
	
	

}
