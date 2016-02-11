package prelimround;

public class ProductItem {
	
	public enum EState{
		DELIVERED, INDELIVERY, INWARHOUSE, GOINGTOWAREHOUSE
	}
	
	public Product prodType;
	public EState state;
	
	public ProductItem(Product prodType) {
		this.prodType = prodType;
	}
}
