package prelimround;

import java.util.ArrayList;

public class Order {

	public Coords destination;
	public int id;
	public ArrayList<Product> itemList;
	public boolean finished;
	
	public Order(Coords location, int id){
		this.destination = location;
		this.id = id;
		
		itemList = new ArrayList<Product>();
		finished = false;
	}
	
	public String toString(){
		return (destination.toString() + "\n" + itemList.toString());
	}
	
	public void addItem(Product item){
		itemList.add(item);
	}
	
	public void removeItem(int i){
		itemList.remove(i);
		checkFinished();
	}
	
	public boolean isFinished(){
		return finished;
	}
	
	private void checkFinished(){
		if (itemList.isEmpty()) {
			finished = true;
		}
	}
	
	
}
