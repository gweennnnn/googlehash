package prelimround;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProcessFile {
	String filename;
	
	public ProcessFile(String filename) {
		this.filename = filename;
	}
	
	public void getFile(Map map, Drone[] drones, Product[] products, Warehouse[] warehouses, Order[] orders) {
		File file = new File(filename);
		Scanner sc = null;
		
		try {
			sc = new Scanner(file);
			//make map
			int maprow = sc.nextInt();
			int mapcol = sc.nextInt();
			int deadline = sc.nextInt();
			int maxload = sc.nextInt();
			sc.nextLine();
			map = new Map(maprow, mapcol);
			
			//products
			int noOfProducts = sc.nextInt();
			sc.nextLine();
			for(int i = 0; i < noOfProducts; i++) {
				int productWeight = sc.nextInt();
				
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
