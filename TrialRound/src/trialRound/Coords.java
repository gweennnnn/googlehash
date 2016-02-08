package trialRound;

public class Coords {
	private int x;
	private int y;
	public Coords(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int row() {
		return this.x;
	}
	
	public int col() {
		return this.y;
	}
	
	@Override
	public String toString() {
		return("(" + x + ", " + y + ")");
	}
	
	@Override
	public boolean equals(Object c1) {
		Coords c2 = (Coords)c1;
		if(x == c2.x && y == c2.y)
			return true;
		return false;
	}
}
