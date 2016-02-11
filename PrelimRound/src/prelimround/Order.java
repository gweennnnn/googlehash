package prelimround;

import java.util.ArrayList;
import java.util.Comparator;

public class Order {

	public Coords destination;
	public int id;
	public ArrayList<Product> itemList;
	public boolean finished;
	
	public int score;
	
	public Order(Coords location, int id){
		this.destination = location;
		this.id = id;
		
		itemList = new ArrayList<Product>();
		finished = false;
	}
	
	public static Comparator<Order> OrderComparator = new Comparator<Order>() {
		@Override
		public int compare(Order c1, Order c2) {
			if(c1.score > c2.score){
				return 1;
			}
			
			if(c1.score < c2.score){
				return -1;
			}
			
			return 0;
		}
	};

	
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
