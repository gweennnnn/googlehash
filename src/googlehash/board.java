package googlehash;

public class board {
	private String[] wall;
	
	public board(String[] wall) {
		this.wall = wall;
	}
	
	public void PAINT_SQUARE(int R, int C, int S) {
		
		int startR = R-S;
		int endR = R+S;
		int startC = C-S;
		int endC = C+S;
		
		for(int i = startR; i <= endR; i++) {
			for(int x = startC; x <= endC; x++) {
				StringBuilder currStr = new StringBuilder(wall[i]);
				currStr.setCharAt(x, '.');
				wall[i] = currStr.toString();
			}
		}
	}
	
	public void PAINT_LINE(int R1, int C1, int R2, int C2) {
		if(R1 == R2) {
			for(int i = C1; i <= C2; i++) {
				StringBuilder currStr = new StringBuilder(wall[R1]);
				currStr.setCharAt(i, '.');
				wall[i] = currStr.toString();
			}
		}
		else if(C1 == C2) {
			for(int i = R1; i <= R2; i++) {
				StringBuilder currStr = new StringBuilder(wall[i]);
				currStr.setCharAt(C1, '.');
				wall[i] = currStr.toString();
			}
		}
	}
	
	public void ERASE_CELL(int R, int C) {
		StringBuilder currStr = new StringBuilder(wall[R]);
		currStr.setCharAt(C,'#');
		wall[R] = currStr.toString();
	}
	
	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i < wall.length; i++) {
			s = s + wall[i] + "\n";
		}
		return s;
	}
	
	public int length() {
		return wall.length;
	}
	
	public String get(int index) {
		return wall[index];
	}
}
