package cmpt213.as2.gamedesign;

/*Tank is a class for every tank itself. 
 * Its objects will call 'Cell' class to randomly assign location.
 * Keeps track of tank's cell locations and health.*/

public class Tank {

	private int tankHealth;
	private int firePower;
	private int[][] location;

	public Tank() {
		location = new int[10][10];
		tankHealth = 4;
		firePower = 20;
	}

	public void loseHealth() {
		this.tankHealth--;

		switch (this.tankHealth) {
		case 3:
			this.firePower = 5;
			break;
		case 2:
			this.firePower = 3;
			break;
		case 1:
			this.firePower = 1;
			break;

		default:
			this.firePower = 0;
		}

	}

	public int[][] getLocation() {
		return location;
	}

	public int fireWeapon() {
		return firePower;
	}

	public boolean whichTankExist(int x, int y) {

		if (this.location[x][y] == 1) {
			return true;
		}
		return false;

	}

	public boolean is_Empty() {

		if (tankHealth == 0) {
			return true;
		} else {
			return false;
		}
	}

}
