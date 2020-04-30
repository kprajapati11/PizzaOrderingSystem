package dmacc;

import java.math.BigDecimal;

import dmacc.model.CheesePizzaMeal;
import dmacc.model.Item;
import dmacc.model.PizzaBuilder;
import dmacc.model.VegPizzaMeal;

public class PizzaTest {
	public static void main(String[] args) {
		PizzaBuilder pizzaBuilder = new PizzaBuilder();
		
		CheesePizzaMeal cheeseMeal = (CheesePizzaMeal) pizzaBuilder.buildPizza("cheese", "medium");
		cheeseMeal.addItem(new Item("onion", BigDecimal.valueOf(2.0)));
		cheeseMeal.addItem(new Item("olive", BigDecimal.valueOf(3.0)));
		cheeseMeal.addItem(new Item("Coke", BigDecimal.valueOf(2.99)));		 
		System.out.println(cheeseMeal.toString());
		//System.out.println(cheeseMeal.getTotalPriceAmount());		

		VegPizzaMeal vegMeal = (VegPizzaMeal) pizzaBuilder.buildPizza("vegpizza", "large");
		vegMeal.addItem(new Item("onion", BigDecimal.valueOf(2.0)));
		vegMeal.addItem(new Item("olive", BigDecimal.valueOf(3.0)));
		vegMeal.addItem(new Item("Coke", BigDecimal.valueOf(2.99)));
		System.out.println(vegMeal.toString());
		//System.out.println(vegMeal.getTotalPriceAmount());
	}
}