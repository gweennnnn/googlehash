package trialRound;

public class Coords {
	private int row;
	private int col;
	public Coords(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public Coords() {
		this.row = -1;
		this.col = -1;
	}
	
	public int row() {
		return this.row;
	}
	
	public int col() {
		return this.col;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public void setCol(int col) {
		this.col = col;
	}
	
	@Override
	public String toString() {
		return("(" + row + ", " + col + ")");
	}
	
	@Override
	public boolean equals(Object c1) {
		Coords c2 = (Coords)c1;
		if(row == c2.row && col == c2.col)
			return true;
		return false;
	}
	
}
