package prelimround;

public class Product {
	public int weight;
	public int prodId;
	
	public Product(int weight, int prodId) {
		this.weight = weight;
		this.prodId = prodId;
	}
	
	@Override
	public boolean equals(Object x) {
		Product comp = (Product) x;
		if(comp.prodId == prodId)
			return true;
		return false;
		
	}
	
	@Override
	public String toString() {
		return "Product " + prodId + " - " + weight + "kg";
	}
}
