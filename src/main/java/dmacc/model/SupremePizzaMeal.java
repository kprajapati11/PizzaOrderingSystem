package dmacc.model;

import java.math.BigDecimal;

public class SupremePizzaMeal extends PizzaMeal{
	private BigDecimal pizzaPrice;
	private BigDecimal totalPrice;

	public SupremePizzaMeal(String name, String size) {
		super(name, size);
		this.pizzaPrice = getPriceFromSize(size);
	}

	public BigDecimal getPrice() {
		return pizzaPrice;
	}

	public void setPrice(BigDecimal price) {
		this.pizzaPrice = price;
	}
	
	private BigDecimal getPriceFromSize(String size) {
		BigDecimal price = null;
		switch(size) {
			case "SMALL":
				price = BigDecimal.valueOf(10.99);
				break;
			case "MEDIUM":
				price = BigDecimal.valueOf(13.99);
				break;
			case "LARGE":
				price = BigDecimal.valueOf(15.99);
				break;
			}
		return price;
	}

	
	public BigDecimal getTotalPrice() {
		totalPrice = BigDecimal.ZERO;
		totalPrice = this.pizzaPrice.add(super.getTotalItemsAmount());		
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	
	@Override
	public String toString() {
		return "SupremePizza [price=" + pizzaPrice + "]" + super.toString();
	}	
}
