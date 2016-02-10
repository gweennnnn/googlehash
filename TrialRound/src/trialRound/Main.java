package trialRound;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		ProcessFile fileManager = new ProcessFile("logo.in");
		String[] pictureInput = fileManager.getFile();
		Image drawingBoard = new Image(pictureInput);
		ArrayList<ArrayList<Coords>> listOfPatterns = new ArrayList<ArrayList<Coords>>();
		ArrayList<ArrayList<Coords>> listOfStartEnd = new ArrayList<ArrayList<Coords>>();
		ImageParse.markAllShapes(drawingBoard, 1, listOfPatterns, listOfStartEnd);
		System.out.println(drawingBoard.toString());
		System.out.println("/////LIST OF PATTERNS/////");
		System.out.println(listOfPatterns);
		System.out.println("/////LIST OF STARTEND/////");
		System.out.println(listOfStartEnd);
		ImageParse.determineStrategy(listOfPatterns, listOfStartEnd, drawingBoard);
	}
}
