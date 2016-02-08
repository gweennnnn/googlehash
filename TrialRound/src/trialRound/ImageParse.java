package trialRound;

import java.util.ArrayList;

public class ImageParse {
	public static Coords findHash(Image image) {
		for(int i = 0; i < image.length(); i++) {
			String currRow = image.get(i);
			for(int x = 0; x < currRow.length(); x++) {
				char currChar = currRow.charAt(x);
				if(currChar == '#')
					return new Coords(i, x);
			}
		}
		return null;
	}
	
	/**
	 * Replace character at index
	 * @param line
	 * @param charIndex
	 * @param replacedChar
	 * @return string that has character replaced
	 */
	public static String replaceChar(String line, int charIndex, char replacedChar) {
		line = line.substring(0, charIndex) + replacedChar + line.substring(charIndex+1);
		return line;
	}
	
	/**
	 * Simply checks the immediate pixels
	 * @param image
	 * @param curr
	 * @return array of coords of available neighbours
	 */
	public static ArrayList<Coords> isConnected(Image image, Coords curr) {
		ArrayList<Coords> returnArr = new ArrayList<Coords>();
		int row = curr.row();
		int col = curr.col();
		System.out.println(row + ", " + col);
		//top
		if((col-1) >= 0 && image.get(row).charAt(col-1) == '#')
			returnArr.add(new Coords(row, col-1));
		//bottom
		if((col + 1) < image.get(row).length() && image.get(row).charAt(col+1) == '#')
			returnArr.add(new Coords(row, col+1));
		//left
		if((row - 1) >= 0 && image.get(row-1).charAt(col) == '#')
			returnArr.add(new Coords(row-1, col));
		//right
		if((row + 1) < image.length() && image.get(row+1).charAt(col) == '#')
			returnArr.add(new Coords(row+1, col));
		
		if(returnArr.size() > 0)
			return returnArr;
		else
			return null;
	}
	
	/**
	 * Recursive function to figure out connected characters
	 * @param image
	 * @param num
	 * @param queue
	 */
	public static void markShape(Image image, int num, ArrayList<Coords> queue, ArrayList<Coords> explored) {
		
		if(queue.size() > 0) {
			System.out.println("Current queue " + queue);
			System.out.println("Current explored " + explored);
			Coords currCoord = queue.remove(0);
			System.out.println("Current coord " + currCoord);
			
			if(!explored.contains(currCoord)) {
				char charNum =  Character.forDigit(num, 10);
				String newStr = replaceChar(image.get(currCoord.row()), currCoord.col(), charNum);
				image.set(currCoord.row(), newStr);
				ArrayList<Coords> neighbours = isConnected(image, currCoord);
				System.out.println("Neighbours " + neighbours);
				if(neighbours != null) queue.addAll(neighbours);
				explored.add(currCoord);
				System.out.println(image.toString());
			}
			markShape(image, num, queue, explored);
		}
	}
	
	/**
	 * Recursive function to figure out all connected characters
	 * @param image
	 * @param num
	 */
	public static void markAllShapes(Image image, int num) {
		Coords currHash = findHash(image);
		if(currHash != null) {
			ArrayList<Coords> newQueue = new ArrayList<Coords>();
			newQueue.add(currHash);
			markShape(image, num, newQueue, new ArrayList<Coords>());
			markAllShapes(image, num+1);
		}
	}
}