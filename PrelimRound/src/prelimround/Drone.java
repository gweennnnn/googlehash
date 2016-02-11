package prelimround;

import java.util.ArrayList;

public class Drone {
	
	public enum EDroneState{
		LOAD, DELIVER, UNLOAD 
	}
	
	public int droneID;
	
	public Coords location;
	
	public int maxWeight;
	public int currentWeight;
	
	public ArrayList<Product> cargo;
	
	// Drones have a commandlist which they perform
	
	public ArrayList<Command> commandQueue;
	
	public int turnsRemaining = 0;
	
	//public int lastDistanceFlown;
	
	//public ArrayList<Command> previousCommands;
	
	public Drone(int droneID, Coords location, int maxWeight)
	{
		this.droneID = droneID;
		this.location = location;
		this.maxWeight = maxWeight;
		
		this.currentWeight = 0;
		//this.lastDistanceFlown = 0;
		this.cargo = new ArrayList<Product>();
		//this.previousCommands = new ArrayList<Command>();
	}
	
	// Do we need a drone factory 
	
	
}
