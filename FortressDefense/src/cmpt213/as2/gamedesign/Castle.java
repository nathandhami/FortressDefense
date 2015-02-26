package cmpt213.as2.gamedesign;

/*Castle only stores the strength and decreases when tanks fire at it. */

public class Castle {

	private int castle_strength;

	public Castle() {
		this.castle_strength = 1500;
	}

	public int getStrength() {
		return castle_strength;
	}

	public void decStrength(int damage) {

		castle_strength -= damage;
	}

}
