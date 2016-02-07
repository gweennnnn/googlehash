package googlehash;


public class main {
	public static void main(String[] args) {
		processFile fileManager = new processFile("logo.in");
		String[] pictureInput = fileManager.getFile();
		board drawingBoard = new board(pictureInput);
		System.out.println(drawingBoard.toString());
		
		
	}
	
	public static void isolateShapes(board image) {
		
	}
	
}
