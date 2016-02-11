package prelimround;

import java.util.Comparator;

public class Coords implements Comparable<Coords> {
	
	public int row;
	public int col;
	
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
	
	@Override
	public int compareTo(Coords compare) {
		return row - compare.row();
	}	
	
	public int compareCol(Coords compare) {
		return col - compare.col();
	}
	
	public static Comparator<Coords> RowComparator 
	    = new Comparator<Coords>() {
		@Override
		public int compare(Coords c1, Coords c2) {
		
			int sortRow = c1.compareTo(c2);
			
			if(sortRow != 0)
				return sortRow;
			else {
				return c1.compareCol(c2);
			}
		}
	
	};
	
	public static Comparator<Coords> ColComparator 
	    = new Comparator<Coords>() {
		@Override
		public int compare(Coords c1, Coords c2) {
		
			int sortRow = c1.compareCol(c2);
			if(sortRow != 0)
				return sortRow;
			else {
				return c1.compareTo(c2);
			}
		}
	};
}
