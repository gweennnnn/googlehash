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
	public static void markShape(Image image, int num, ArrayList<Coords> queue, ArrayList<Coords> explored, Coords start, Coords end) {
		
		if(queue.size() > 0) {
			Coords currCoord = queue.remove(0);
			Coords newstart = start;
			Coords newend = end;
			if(!explored.contains(currCoord)) {
				
				char charNum =  Character.forDigit(num, 10);
				String newStr = replaceChar(image.get(currCoord.row()), currCoord.col(), charNum);
				image.set(currCoord.row(), newStr);
				ArrayList<Coords> neighbours = isConnected(image, currCoord, explored);
				if(neighbours != null) queue.addAll(neighbours);
				explored.add(currCoord);
				
				if(newstart.row() == -1 || newstart.row() > currCoord.row())
					newstart.setRow(currCoord.row());
				if(newstart.col() == -1 || newstart.col() > currCoord.col())
					newstart.setCol(currCoord.col());
				if(newend.row() == -1 || newend.row() < currCoord.row())
					newend.setRow(currCoord.row());
				if(newend.col() == -1 || newend.col() < currCoord.col())
					newend.setCol(currCoord.col());
			}
			
			markShape(image, num, queue, explored, newstart, newend);
		}
	}
	
	/**
	 * Recursive function to figure out all connected characters
	 * @param image
	 * @param num
	 */
	public static void markAllShapes(Image image, int num, ArrayList<ArrayList<Coords>> coordsOfPatterns, ArrayList<ArrayList<Coords>> startends) {
		Coords currHash = findHash(image);
		
		if(currHash != null) {
			ArrayList<Coords> newQueue = new ArrayList<Coords>();
			ArrayList<Coords> newExplored = new ArrayList<Coords>();
			newQueue.add(currHash);
			
			Coords start = new Coords();
			Coords end = new Coords();
			markShape(image, num, newQueue, newExplored, start, end);
			ArrayList<Coords> patternstartend = new ArrayList<Coords>();
			patternstartend.add(start);
			patternstartend.add(end);
			coordsOfPatterns.add(newExplored);
			startends.add(patternstartend);
			markAllShapes(image, num+1, coordsOfPatterns, startends);
		}
	}
	
	/**
	 * Get amount of squares filled in a boundary
	 * @param pattern
	 * @return percentage filled
	 */
	public static double getPercentageFilled(ArrayList<Coords> pattern, ArrayList<Coords> startend) {
		double totsq = getNoOfTotalSquares(startend);
		double patternsq = getNoOfTotalSquaresInPattern(pattern);
		System.out.println("Total  : "+ totsq);
		System.out.println("Pattern: " + patternsq);
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
	 * @param startend contains top left coord and bottom right coord
	 * @return
	 */
	public static int getNoOfTotalSquares(ArrayList<Coords> startend) {
		Coords startCoords = startend.get(0);
		Coords endCoords = startend.get(1);
		int totalSquares = (endCoords.row() - startCoords.row()+1) * (endCoords.col() - startCoords.col()+1);
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
	
	public static void determineStrategy(ArrayList<ArrayList<Coords>> listOfPatterns, ArrayList<ArrayList<Coords>> listOfStartEnds, Image board) throws Exception {
		for(int i = 0; i < listOfPatterns.size(); i++) {
			System.out.println("===============Next pattern");
			ArrayList<Coords> currPattern = listOfPatterns.get(i);
			ArrayList<Coords> currStartEnd = listOfStartEnds.get(i);
			System.out.println(currPattern);
			double filled = getPercentageFilled(currPattern, currStartEnd);
			System.out.println("Filled: " + filled);
			
			if(filled <= 100) {
				currPattern.sort(Coords.RowComparator);
				System.out.println("sorted pattern");
				System.out.println(currPattern);
				ArrayList<String> solution = solveByLines(currPattern, board);
				
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
	
	public static ArrayList<String> solveByLines(ArrayList<Coords> pattern, Image img) {
		int start = 0;
		int end = 0;
		ArrayList<String> instructions = new ArrayList<String>();
		for(int i = 1; i < pattern.size(); i++) {
			Coords currcoords = pattern.get(i);
			Coords startcoords = pattern.get(start);
			Coords endcoords = pattern.get(end);
			boolean samepattern = true;
			if(startcoords.row() == currcoords.row() && endcoords.col()+1 == currcoords.col())
				samepattern = true;
			else
				samepattern = false;
			
			if(samepattern) 
				end = i;
			else {
				System.out.println("Current: " + startcoords + ", " + endcoords);
				instructions.add(img.PAINT_LINE(startcoords.row(), startcoords.col(), endcoords.row(), endcoords.col()));
				System.out.println(img);
				start = end = i;
			}
		}
		return instructions;
	}
}