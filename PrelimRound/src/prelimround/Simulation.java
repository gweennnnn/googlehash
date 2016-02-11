package prelimround;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Simulation {
	
	Map map = new Map();
	ArrayList<Product> products = new ArrayList<Product>();
	ArrayList<Drone> drones = new ArrayList<Drone>();
	ArrayList<Warehouse> warehouses = new ArrayList<Warehouse>();
	ArrayList<Order> orders = new ArrayList<Order>();
	PriorityQueue<Order> orderQueue;
	int deadline;
	int droneCapacity;
	
	ArrayList<Command> commandList = new ArrayList<Command>();
	public int ordersCompleted = 0;
	public int totalOrders;
	
	public int maxTurns;
	public int currentTurn;
	
	public boolean simulationFinished = false;
	
	public ArrayList<Drone> dronesFree = new ArrayList<Drone>();
	
	// This is the actual simulation of the Map, Drones, Orders
	// Everything gets put in here
	public Simulation() {
		this.currentTurn = 0;
	}
	
	//// Simulation
	
	// This will run the simulation when it is setup
	// It will return an arraylist of the commands that was used to complete the simulation
	public ArrayList<Command> startSimulation(){
		
		
		//if next turn returns null then we have finished the simulation
		
		return null;
	}
	
	
	
	public ArrayList<Command> nextTurn(){
		
		if(ordersCompleted == totalOrders){
			// Complete simulation
			return null;
		}
		
		
		
		return null;
	}
	
	//// Moves
	// We need to lock drones when they are performing a command
		// Does this mean that drones need an internal clock
	// Issue commands to drones in a queue
	
	// At the start we calculate a priority queue of the orders
	public void fillOrderQueue(){
		this.orderQueue = new PriorityQueue<Order>(Order.OrderComparator);
		
		for (Order order : orders) {
			// calculate order score
			
			// add order to queue
		}
	}
	
	public int scoreAnOrderForAWarehouse(Order order){
		
		int numProducts = order.itemList.size();
			
		int orderWeight = 0;
		
		for (Product product : order.itemList) {
			orderWeight += product.weight;
		}
		
		// How many drones will this take
		int numDrones = orderWeight / this.droneCapacity;
		
		int totalTime;
		
		for (int i = 0; i < numDrones; i++) {
			
			
			
		}
		
		return 0;
	}
	
	public Warehouse nextClosestWarehouse(Warehouse warehouse){
		// Here we will work out the next closest warehouse
		
		Warehouse closestWarehouse = null;
		
		Coords currentlocation = warehouse.location;
		
		warehouses.remove(warehouse);
		
		int smallestdistance = 999999999;
		
		for (Warehouse nextWarehouse : warehouses) {
			
			int thisDist = distanceInTurns(currentlocation, nextWarehouse.location);
			
			if(thisDist < smallestdistance){
				smallestdistance = thisDist;
				closestWarehouse = nextWarehouse;
			}
		}
		
		
		return closestWarehouse;
	}
	
	// Calculate distance in turns
	// Each unit of distance means 1 turn
	public int distanceInTurns(Coords start, Coords finish)
	{
		int ra = start.row;
		int ca = start.col;
		
		int rb = finish.row;
		int cb = finish.col;
		
		double distance = Math.sqrt(((ra - rb)^2) + ((ca - cb)^2));
		
		int distanceInt = (int) Math.ceil(distance);
		
		return distanceInt;
	}
	
	// Find nearest warehouse with product (result via numOfTurns)
	
	// For each turn 
	
	
}
