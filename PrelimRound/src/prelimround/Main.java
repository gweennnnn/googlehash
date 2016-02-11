package prelimround;

public class Main {

	public static void main(String[] args) {

		
		Map map = new Map();
		Product[] products = new Product[1];
		Drone[] drones = new Drone[1];
		Warehouse[] warehouses = new Warehouse[1];
		Order[] orders = new Order[1];
		
		ProcessFile processfile = new ProcessFile("mother_of_all_warehouses.in");
		
		processfile.getFile(map, drones, products, warehouses, orders);
		map.toString();
	}

}
