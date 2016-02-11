package prelimround;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcessFile {
	String filename;
	
	public ProcessFile(String filename) {
		this.filename = filename;
	}
	
	public void getFile(Simulation sim) {
		File file = new File(filename);
		Scanner sc = null;
		
		try {
			sc = new Scanner(file);
			//make map
			System.out.println("CREATE MAP");
			int maprow = sc.nextInt();
			int mapcol = sc.nextInt();
			int deadline = sc.nextInt();
			int maxload = sc.nextInt();
			sim.deadline = deadline;
			sc.nextLine();
			sim.map = (new Map(maprow, mapcol));
			
			//products
			System.out.println("CREATE PRODUCTS");
			int noOfProducts = sc.nextInt();
			sc.nextLine();
			
			for(int i = 0; i < noOfProducts; i++) {
				int productWeight = sc.nextInt();
				Product newProd = new Product(productWeight, i);
				sim.products.add(newProd);
			}
			sc.nextLine();

			//warehouse
			int noOfWarehouses = sc.nextInt();
			sc.nextLine();
			for(int i = 0; i < noOfWarehouses; i++) {
				int wRow = sc.nextInt();
				int wCol = sc.nextInt();
				Coords wCoord = new Coords(wRow, wCol);
				sc.nextLine();
				
				ArrayList<Inventory> stock = new ArrayList<Inventory>();
				for(int x = 0; x < noOfProducts; x++) {
					int noOfStock = sc.nextInt();
					Inventory newInventory = new Inventory(sim.products.get(x), noOfStock);
					stock.add(newInventory);
				}
				Warehouse newWarehouse = new Warehouse(wCoord, stock);
			}
			sc.nextLine();
			
			//order
			System.out.println("Create Order");
			int noOfOrder = sc.nextInt();
			sc.nextLine();
			for(int i = 0; i < noOfOrder; i++) {
				int oRow = sc.nextInt();
				int oCol = sc.nextInt();
				sc.nextLine();
				int noOfItems = sc.nextInt();
				sc.nextLine();
				
				for(int x = 0; x < noOfItems; x++) {
					int productid = sc.nextInt();
					Product currProd = sim.products.get(productid);
					System.out.println(currProd);
					sim.products.add(currProd);
				}
				sc.nextLine();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
	}
}
