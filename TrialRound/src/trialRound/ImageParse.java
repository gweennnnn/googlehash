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
	public static ArrayList<Coords> isConnected(Image image, Coords curr, ArrayList<Coords> explored) {
		ArrayList<Coords> returnArr = new ArrayList<Coords>();
		int row = curr.row();
		int col = curr.col();
		//top
		if((col-1) >= 0 && image.get(row).charAt(col-1) == '#' && !explored.contains(new Coords(row, col-1)))
			returnArr.add(new Coords(row, col-1));
		//bottom
		if((col + 1) < image.get(row).length() && image.get(row).charAt(col+1) == '#' && !explored.contains(new Coords(row, col+1)))
			returnArr.add(new Coords(row, col+1));
		//left
		if((row - 1) >= 0 && image.get(row-1).charAt(col) == '#' && !explored.contains(new Coords(row-1, col)))
			returnArr.add(new Coords(row-1, col));
		//right
		if((row + 1) < image.length() && image.get(row+1).charAt(col) == '#' && !explored.contains(new Coords(row+1, col)))
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
			Coords currCoord = queue.remove(0);
			
			if(!explored.contains(currCoord)) {
				
				char charNum =  Character.forDigit(num, 10);
				String newStr = replaceChar(image.get(currCoord.row()), currCoord.col(), charNum);
				image.set(currCoord.row(), newStr);
				ArrayList<Coords> neighbours = isConnected(image, currCoord, explored);
				if(neighbours != null) queue.addAll(neighbours);
				explored.add(currCoord);
			}
			markShape(image, num, queue, explored);
		}
	}
	
	/**
	 * Recursive function to figure out all connected characters
	 * @param image
	 * @param num
	 */
	public static void markAllShapes(Image image, int num, ArrayList<ArrayList<Coords>> coordsOfPatterns) {
		Coords currHash = findHash(image);
		
		if(currHash != null) {
			ArrayList<Coords> newQueue = new ArrayList<Coords>();
			ArrayList<Coords> newExplored = new ArrayList<Coords>();
			newQueue.add(currHash);
			markShape(image, num, newQueue, newExplored);
			
			ArrayList<Coords> patternstartend = new ArrayList<Coords>();
			coordsOfPatterns.add(newExplored);
			markAllShapes(image, num+1, coordsOfPatterns);
		}
	}
	
	/**
	 * Get amount of squares filled in a boundary
	 * @param pattern
	 * @return percentage filled
	 */
	public static double getPercentageFilled(ArrayList<Coords> pattern) {
		double totsq = getNoOfTotalSquares(pattern);
		double patternsq = getNoOfTotalSquaresInPattern(pattern);
		return (patternsq/totsq)*100;
	}
	
	/**
	 * Get amount of total squares in pattern
	 * @param pattern
	 * @return total squares in pattern
	 */
	public static int getNoOfTotalSquaresInPattern(ArrayList<Coords> pattern) {
		
		return pattern.size();
	}
	
	/**
	 * Get number of total squares within the rectangle bit surrounding pattern
	 * @param pattern
	 * @return
	 */
	public static int getNoOfTotalSquares(ArrayList<Coords> pattern) {
		ArrayList<Coords> startend = getStartEnd(pattern);
		
		Coords startCoords = startend.get(0);
		Coords endCoords = startend.get(1);
		
		int totalSquares = (endCoords.row() - startCoords.row()) * (endCoords.col() - startCoords.col());
		return totalSquares;
	}
	
	/**
	 * Gets the top left and bottom righ coord
	 * @param pattern
	 * @return arraylist of coords in the pattern
	 */
	public static ArrayList<Coords> getStartEnd(ArrayList<Coords> pattern) {
		int startrow, startcol, endrow, endcol;
		startrow = endrow = pattern.get(0).row();
		startcol = endcol = pattern.get(0).col();
		
		for(int i = 1; i < pattern.size(); i++) {
			if(startrow > pattern.get(i).row()) {
				startrow = pattern.get(i).row();}
			if(startcol > pattern.get(i).col()) {
				startcol = (pattern.get(i).col());}
			if(endrow < pattern.get(i).row()) {
				endrow = (pattern.get(i).row());}
			if(endcol < pattern.get(i).col()) {
				endcol = (pattern.get(i).col());}
		}
		ArrayList<Coords> returnArr = new ArrayList<Coords>();
		returnArr.add(new Coords(startrow, startcol));
		returnArr.add(new Coords(endrow, endcol));
		return returnArr;
	}
	
	public static void determineStrategy(ArrayList<ArrayList<Coords>> listOfPatterns, Image board) throws Exception {
		for(int i = 0; i < 1; i++) {
			ArrayList<Coords> currPattern = listOfPatterns.get(i);
			double filled = getPercentageFilled(currPattern);
			System.out.println(filled);
			//Case 1: simply use lines
			if(filled >= 0.0 && filled <= 46.0) {
				boolean rowLonger = isRowLongerThanCol(currPattern);
				//if row is long, than simply go through and solve using lines on rows
				//TODO: Optimise this to something clever
				if(rowLonger) {
					currPattern.sort(Coords.RowComparator);
					
					int start, end = i;
					start = end = currPattern.get(0).col();
					ArrayList<String> moves = new ArrayList<String>();
					for(int x = 1; x < currPattern.size(); x++) {
						if(currPattern.get(start).row() > currPattern.get(i).row()) {
							Coords s = currPattern.get(start);
							Coords e = currPattern.get(end);
							moves.add(board.PAINT_LINE(s.row(), s.col(), e.row(), e.col()));
						}
					}
				}
			}
			//Case 2: mid cases, determine squares or lines
			else if(filled > 46.0 && filled <= 60) {
				
			}
			//Case 3: prioritises square, fall back on case 2
			else if(filled <= 100.0) {
				
			}
			else {
				throw new Exception("Somehow percentage is more than 100 or less than 0");
			}
		}
	}
	
	//Line strategies
	public static boolean isRowLongerThanCol(ArrayList<Coords> pattern) {
		ArrayList<Coords> startend = getStartEnd(pattern);
		Coords startCoords = startend.get(0);
		Coords endCoords = startend.get(1);
		if((endCoords.row() - startCoords.row()) > (endCoords.col() - startCoords.col()))
			return true;
		return false;
	}
}