package dmacc.model;

import java.math.BigDecimal;

public class ChickenPizzaMeal extends PizzaMeal{
	private BigDecimal pizzaPrice;
	private BigDecimal totalPrice;
	
	public ChickenPizzaMeal(String name, String size) {
		super(name, size);
		this.pizzaPrice = getPriceFromSize(size);
	}

	public BigDecimal getPizzaPrice() {
		return pizzaPrice;
	}

	public void setPizzaPrice(BigDecimal pizzaPrice) {
		this.pizzaPrice = pizzaPrice;
	}

	private BigDecimal getPriceFromSize(String size) {
		BigDecimal price = null;
		switch(size) {
			case "SMALL":
				price = BigDecimal.valueOf(8.99);
				break;
			case "MEDIUM":
				price = BigDecimal.valueOf(10.99);
				break;
			case "LARGE":
				price = BigDecimal.valueOf(12.99);
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
		return "ChickenPizza [price=" + pizzaPrice + "]" + super.toString();
	}	
}
