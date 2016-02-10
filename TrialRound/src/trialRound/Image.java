package trialRound;

public class Image {
	private String[] imgArr;
	
	public Image(String[] imgArr) {
		this.imgArr = imgArr;
	}
	
	public String PAINT_SQUARE(int R, int C, int S) {
		int startR = R-S;
		int endR = R+S;
		int startC = C-S;
		int endC = C+S;
		
		for(int i = startR; i <= endR; i++) {
			for(int x = startC; x <= endC; x++) {
				StringBuilder currStr = new StringBuilder(imgArr[i]);
				currStr.setCharAt(x, '.');
				imgArr[i] = currStr.toString();
			}
		}
		return "PAINT_SQUARE " + R + " " + C + " " + S;
	}
	
	public String PAINT_LINE(int R1, int C1, int R2, int C2) {
		if(R1 == R2) {
			for(int i = C1; i <= C2; i++) {
				StringBuilder currStr = new StringBuilder(imgArr[R1]);
				currStr.setCharAt(i, '.');
				imgArr[i] = currStr.toString();
			}
		}
		else if(C1 == C2) {
			for(int i = R1; i <= R2; i++) {
				StringBuilder currStr = new StringBuilder(imgArr[i]);
				currStr.setCharAt(C1, '.');
				imgArr[i] = currStr.toString();
			}
		}
		else {
		}
		return "PAINT_LINE " + R1 + " " + C1 + " " + R2 + " " + C2;
	}
	
	public String ERASE_CELL(int R, int C) {
		StringBuilder currStr = new StringBuilder(imgArr[R]);
		currStr.setCharAt(C,'#');
		imgArr[R] = currStr.toString();
		return "ERASE CELL " + R + " " + C ;
	}
	
	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i < imgArr.length; i++) {
			s = s + imgArr[i] + "\n";
		}
		return s;
	}
	
	public int length() {
		return imgArr.length;
	}
	
	public String get(int index) {
		return imgArr[index];
	}
	
	public char get(Coords coord) {
		return imgArr[coord.row()].charAt(coord.col());
	}
	
	public void set(int index, String row) {
		imgArr[index] = row;
	}
}
