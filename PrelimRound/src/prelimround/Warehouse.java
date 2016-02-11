package prelimround;
import java.util.ArrayList;

public class Warehouse{
	
	public Coords location;
	ArrayList<Inventory> stock;
	
	public Warehouse(Coords location, ArrayList<Inventory> stock) {
		this.location = location;
		this.stock = stock;
	}
}
