package trialRound;


public class Main {
	public static void main(String[] args) {
		ProcessFile fileManager = new ProcessFile("logo.in");
		String[] pictureInput = fileManager.getFile();
		Image drawingBoard = new Image(pictureInput);
		ImageParse.markAllShapes(drawingBoard, 1);
		System.out.println(drawingBoard.toString());
	}
	
	public static void isolateShapes(Image image) {
		
	}
	
}
