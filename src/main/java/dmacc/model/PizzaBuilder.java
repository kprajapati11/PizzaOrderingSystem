package dmacc.model;

public class PizzaBuilder {
	
	public static PizzaMeal buildPizza(String name, String size) {
		PizzaMeal pizza = null;
		
		if(name.equals("chicken")) {
			
			pizza = new ChickenPizzaMeal(name, size);
			
		}else if(name.contentEquals("cheese")) {
			
			pizza = new CheesePizzaMeal(name, size);
			
		}else if(name.contentEquals("pepperoni")) {
			
			pizza = new PepperoniPizzaMeal(name, size);
			
		}else if(name.contentEquals("vegpizza")) {
			
			pizza = new VegPizzaMeal(name, size);
			
		}else if(name.contentEquals("supremepizza")) {
			
			pizza = new SupremePizzaMeal(name, size);
			
		}
		return pizza;
	}
}
