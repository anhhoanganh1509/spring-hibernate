package stackjava.com.springmvchibernate.model;

import stackjava.com.springmvchibernate.entities.Product;

public class ProductInfo {
	private int productId;
	private int productPrice;
	private String name;
	private int sanid;
	public ProductInfo(int productId, int productPrice) {
		super();
		this.productId = productId;
		this.productPrice = productPrice;
	}
	public ProductInfo() {
		super();
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
	public int getSanid() {
		return sanid;
	}
	public void setSanid(int sanid) {
		this.sanid = sanid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProductInfo(Product p) {
		this.productId = p.getProductid();
		this.productPrice = p.getProductprice();
		this.name = p.getCategory().getCategoryname();
		this.sanid = p.getSanid();
	}
}
