package stackjava.com.springmvchibernate.model;

public class Item {
	private ProductInfo product;
	private int quantity;
	public Item() {
		super();
	}
	public Item(ProductInfo product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	public ProductInfo getProduct() {
		return product;
	}
	public void setProduct(ProductInfo product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getAmount() {
        return this.product.getProductPrice() * this.quantity;
    }
}
