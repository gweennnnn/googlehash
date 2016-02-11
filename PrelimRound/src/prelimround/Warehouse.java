package prelimround;
import java.util.ArrayList;

public class Warehouse{
	
	public Coords location;
	ArrayList<Inventory> stock;
	
	public Warehouse(Coords location, ArrayList<Inventory> stock) {
		this.location = location;
		this.stock = stock;
	}
	
	public boolean contains(Product prod) {
		for(int i = 0; i < stock.size(); i++) {
			if(stock.get(i).item == prod)
				return true;
		}
		return false;
		
	}
}
