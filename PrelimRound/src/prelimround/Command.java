package prelimround;

public class Command {
	
	public enum ECommandType{
		DELIVER, WAIT, LOAD, UNLOAD
	}
	
	public int droneID;
	public ECommandType commandType;
	public int orderID;
	public int productType;
	public int numOfItems;
	
	public Command(int droneID, ECommandType commandType, int orderID, int productType,
			int numOfItems) {
		super();
		this.droneID = droneID;
		this.commandType = commandType;
		this.orderID = orderID;
		this.productType = productType;
		this.numOfItems = numOfItems;
	}
	
	@Override
	public String toString(){
		
		String commandString = "";
		
		commandString += droneID;
		
		commandString += " ";
		
		commandString += enumToString(this.commandType);
		
		commandString += " ";
		
		commandString += orderID;
		
		commandString += " ";
		
		commandString += productType;
		
		commandString += " ";
		
		commandString += numOfItems;
		
		return commandString;
		
	}
	
	public String enumToString(ECommandType command){
		
		String commandString = "";
		
		switch(command){
		case DELIVER: commandString = "D";
		case WAIT: commandString = "W";
		case LOAD: commandString = "L";
		case UNLOAD: commandString = "U";
		}
		
		return commandString;
	}

}
