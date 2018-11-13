package stackjava.com.springmvchibernate.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private final List<Item> cartLines = new ArrayList<Item>();

    public List<Item> getCartLines() {
        return this.cartLines;
    }

    private Item findLineByCode(String code) {
        for (Item line : this.cartLines) {
            if (line.getProduct().getProductId() == Integer.parseInt(code)) {
                return line;
            }
        }
        return null;
    }
 
    public void addProduct(ProductInfo p, int quantity) {
    	Item line = this.findLineByCode(String.valueOf(p.getProductId()));
 
        if (line == null) {
            line = new Item();
            line.setQuantity(0);
            line.setProduct(p);
            this.cartLines.add(line);
        }
        int newQuantity = line.getQuantity() + quantity;
        if (newQuantity <= 0) {
            this.cartLines.remove(line);
        } else {
            line.setQuantity(newQuantity);
        }
    }
 
    public void validate() {
 
    }
 
    public void updateProduct(String code, int quantity) {
    	Item line = this.findLineByCode(code);
 
        if (line != null) {
            if (quantity <= 0) {
                this.cartLines.remove(line);
            } else {
                line.setQuantity(quantity);
            }
        }
    }
 
    public void removeProduct(ProductInfo p) {
    	Item line = this.findLineByCode(String.valueOf(p.getProductId()));
        if (line != null) {
            this.cartLines.remove(line);
        }
    }
 
    public int getQuantityTotal() {
        int quantity = 0;
        for (Item line : this.cartLines) {
            quantity += line.getQuantity();
        }
        return quantity;
    }
 
    public double getAmountTotal() {
        double total = 0;
        for (Item line : this.cartLines) {
            total += line.getAmount();
        }
        return total;
    }
 
    public void updateQuantity(Cart c) {
        if (c != null) {
            List<Item> lines = c.getCartLines();
            for (Item line : lines) {
                this.updateProduct(String.valueOf(line.getProduct().getProductId()), line.getQuantity());
            }
        }
 
    }
}
