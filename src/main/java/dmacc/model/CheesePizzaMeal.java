package dmacc.model;

import java.math.BigDecimal;

public class CheesePizzaMeal extends PizzaMeal{
	private BigDecimal pizzaPrice;
	private BigDecimal totalPrice;
	
	public CheesePizzaMeal(String name, String size) {
		super(name, size);
		this.pizzaPrice = getPizzaPriceFromSize(size);
	}

	public BigDecimal getPizzaPrice() {
		return pizzaPrice;
	}

	public void setPizzaPrice(BigDecimal pizzaPrice) {
		this.pizzaPrice = pizzaPrice;
	}

	private BigDecimal getPizzaPriceFromSize(String size) {
		BigDecimal price = null;
		switch(size) {
			case "SMALL":
				price = BigDecimal.valueOf(6.99);
				break;
			case "MEDIUM":
				price = BigDecimal.valueOf(7.99);
				break;
			case "LARGE":
				price = BigDecimal.valueOf(9.99);
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

	/*
	 * public BigDecimal getTotalPriceAmount() { totalPrice = BigDecimal.ZERO;
	 * totalPrice = this.pizzaPrice.add(getTotalItemsAmount()); return totalPrice; }
	 */
	
	
	
	@Override
	public String toString() {
		return "CheesePizza [price=" + pizzaPrice + "]"+super.toString();
	}

}
