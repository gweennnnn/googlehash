package prelimround;

import java.util.ArrayList;

public class Order {

	public Coords location;
	public int id;
	private ArrayList<Product> itemList;
	private boolean finished;
	
	public Order(Coords location, int id){
		this.location = location;
		this.id = id;
		
		itemList = new ArrayList<Product>();
		finished = false;
	}
	
	public String toString(){
		return (location.toString() + "\n" + itemList.toString());
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
