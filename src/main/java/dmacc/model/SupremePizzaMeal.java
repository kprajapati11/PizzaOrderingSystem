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
			case "small":
				price = BigDecimal.valueOf(9.99);
				break;
			case "medium":
				price = BigDecimal.valueOf(12.99);
				break;
			case "large":
				price = BigDecimal.valueOf(15.99);
				break;
			}
		return price;
	}

	public BigDecimal getTotalPriceAmount() {
		totalPrice = BigDecimal.ZERO;
		totalPrice = this.pizzaPrice.add(getTotalItemsAmount());		
		return totalPrice;
	}
	
	@Override
	public String toString() {
		return "SupremePizza [price=" + pizzaPrice + "]" + super.toString();
	}	
}
