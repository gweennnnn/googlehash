package prelimround;

public class Simulation {
	Map map = new Map();
	Product[] products = new Product[1];
	Drone[] drones = new Drone[1];
	Warehouse[] warehouses = new Warehouse[1];
	Order[] orders = new Order[1];
	public Simulation(Map map, Product[] products, Drone[] drones, Warehouse[] warehouses, Order[] orders) {
		super();
		this.map = map;
		this.products = products;
		this.drones = drones;
		this.warehouses = warehouses;
		this.orders = orders;
	}

}
