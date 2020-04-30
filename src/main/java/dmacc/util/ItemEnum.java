package dmacc.util;

import java.math.BigDecimal;
import java.util.Arrays;

public enum ItemEnum{
	//ONION	  ("onion", 	BigDecimal.valueOf(0.99)),
	//OLIVE	  ("olive", 	BigDecimal.valueOf(0.99)),
	//PINEAPPLE ("pineapple", BigDecimal.valueOf(0.99)),
	//BACON	  ("bacon", 	BigDecimal.valueOf(0.99)),
	PEPPER	  ("pepper", 	BigDecimal.valueOf(0.99)),
	//TOMATO	  ("tomato", 	BigDecimal.valueOf(0.99)),
	;

	private String name;
	private BigDecimal price;
	
	ItemEnum(String name, BigDecimal price){
		this.name = name;
		this.price = price;
	}
	
	public static BigDecimal getItemPriceFromItemName(String itemName) {
		BigDecimal itemPrice = null;
		for(ItemEnum i : values()) {
			if(i.getName().equals(itemName)) {
				itemPrice = i.getPrice();
			}			
		}
		return itemPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
}
