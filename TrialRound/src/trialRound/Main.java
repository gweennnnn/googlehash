package trialRound;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		ProcessFile fileManager = new ProcessFile("logo.in");
		String[] pictureInput = fileManager.getFile();
		Image drawingBoard = new Image(pictureInput);
		ArrayList<ArrayList<Coords>> listOfPatterns = new ArrayList<ArrayList<Coords>>();
		ImageParse.markAllShapes(drawingBoard, 1, listOfPatterns);
		System.out.println(drawingBoard.toString());
		System.out.println(listOfPatterns);
		ImageParse.determineStrategy(listOfPatterns, drawingBoard);
	}
}
