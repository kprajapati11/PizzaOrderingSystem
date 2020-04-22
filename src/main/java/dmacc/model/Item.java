package dmacc.model;

import java.math.BigDecimal;

public class Item{
	private String itemName;
	private BigDecimal price;
	
	public Item(String itemName, BigDecimal price) {
		this.itemName = itemName;
		this.price = price;			
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", price=" + price + "]";
	}
	
	
}