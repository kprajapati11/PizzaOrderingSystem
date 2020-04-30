package dmacc.model;

import java.math.BigDecimal;

public class PepperoniPizzaMeal extends PizzaMeal{
	private BigDecimal pizzaPrice;
	private BigDecimal totalPrice;

	public PepperoniPizzaMeal(String name, String size) {
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
				price = BigDecimal.valueOf(9.99);
				break;
			case "MEDIUM":
				price = BigDecimal.valueOf(12.99);
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
		return "PepperoniPizza [price=" + pizzaPrice + "]" + super.toString();
	}	
}
