package trialRound;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProcessFile {
	String filename;
	
	public ProcessFile(String filename) {
		this.filename = filename;
	}
	
	public String[] getFile() {
		File file = new File(filename);
		Scanner sc = null;
		
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		
		int row = sc.nextInt();
		int col = sc.nextInt();
		sc.nextLine();
		String[] input = new String[row];
		
		for(int i = 0; i < row; i++) {
			input[i] = sc.nextLine().trim();
		}
		
		return input;
	}
}
