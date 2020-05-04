
package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Orders;
import dmacc.model.CheesePizzaMeal;
import dmacc.model.ChickenPizzaMeal;
import dmacc.model.Item;
import dmacc.model.PepperoniPizzaMeal;
import dmacc.model.PizzaBuilder;
import dmacc.model.PizzaMeal;
import dmacc.model.SupremePizzaMeal;
import dmacc.model.VegPizzaMeal;
import dmacc.repository.CustomerRepository;
import dmacc.repository.OrdersRepository;
import dmacc.repository.PizzaRepository;
import dmacc.util.PizzaName;


@Controller
public class WebController {

	
	  @Autowired 
	  private CustomerRepository cRepo;
	  
	  @Autowired 
	  private PizzaRepository pRepo;	 
	  
	  @Autowired
	  private OrdersRepository oRepo;
	  
	  

	  @GetMapping("/newPizza")
	  public String createNewPizza(Model model) {	
		  //this is a model only to display in UI
		  PizzaMeal pizza =new PizzaMeal();		
		  pizza.addItem(new Item("onion", null));
		  pizza.addItem(new Item("bacon",null));
		  pizza.addItem(new Item("olive",null));
		  pizza.addItem(new Item("pineapple",null));
		  pizza.addItem(new Item("pepper",null));
		  pizza.addItem(new Item("tomato",null));
		
		  model.addAttribute("pizzaMeal", pizza);
		  model.addAttribute("itemsList", pizza.getItemsList());
		
		return "pizza";		
	  }
	
		/*
		 * @PostMapping("/buildPizzaMeal") public String buildPizzaMeal(PizzaMeal pizza,
		 * Model model) { PizzaMeal customerMeal =
		 * pizzaBuilder.buildPizza(pizza.getName(), pizza.getSize());
		 * customerMeal.setItemsList(pizza.getItemsList());
		 * 
		 * model.addAttribute("pizzaDetail", customerMeal); return "pizzaDetail"; }
		 */
	
	
		@PostMapping("/buildPizzaMeal")
		public String buildPizzaMeal(PizzaMeal pizza, Model model) {
			if(pizza.getName().replaceAll(",", "").equals(String.valueOf(PizzaName.CHICKEN))) {
				
				ChickenPizzaMeal customerMeal = new ChickenPizzaMeal(pizza.getName(), pizza.getSize());
				customerMeal.setItemsList(pizza.getItemsList());
				model.addAttribute("pizzaDetail", customerMeal);	
				
			}else if(pizza.getName().replaceAll(",", "").equals(String.valueOf(PizzaName.CHEESE))) {
				
				CheesePizzaMeal customerMeal = new CheesePizzaMeal(pizza.getName(), pizza.getSize());
				customerMeal.setItemsList(pizza.getItemsList());
				model.addAttribute("pizzaDetail", customerMeal);	
				
			}else if(pizza.getName().replaceAll(",", "").equals(String.valueOf(PizzaName.PEPPERONI))) {
				
				PepperoniPizzaMeal customerMeal = new PepperoniPizzaMeal(pizza.getName(), pizza.getSize());
				customerMeal.setItemsList(pizza.getItemsList());
				model.addAttribute("pizzaDetail", customerMeal);	
				
			}else if(pizza.getName().replaceAll(",", "").equals(String.valueOf(PizzaName.VEGPIZZA))) {
				
				VegPizzaMeal customerMeal = new VegPizzaMeal(pizza.getName(), pizza.getSize());
				customerMeal.setItemsList(pizza.getItemsList());
				model.addAttribute("pizzaDetail", customerMeal);	
				
			}else if(pizza.getName().replaceAll(",", "").equals(String.valueOf(PizzaName.SUPREME))) {
				
				SupremePizzaMeal customerMeal = new SupremePizzaMeal(pizza.getName(), pizza.getSize());
				customerMeal.setItemsList(pizza.getItemsList());
				model.addAttribute("pizzaDetail", customerMeal);					
			}
			
			return "pizzaDetail";
		}
	
	
		
	
	@GetMapping({ "/order" })
	public String viewOrder(Model model) {
		Orders order = new Orders();
		model.addAttribute("order", order);
		return "pizzaDetail";
	}

	/*
	 * @GetMapping("/newOrder") public String addNewItem(Model model) { Orders o =
	 * new Orders(); model.addAttribute("newOrder", o); return "orderForm"; }
	 */

	@PostMapping("/newOrder")
	public String addNewOrder(@ModelAttribute Orders order, Model model) {
		//oRepo.save(order);
		return "view_order";
	}

	/*
	 * @GetMapping("/edit/{id}") public String showUpdateOrder(@PathVariable("id")
	 * int id, Model model) { Orders o = oRepo.findById(id).orElse(null);
	 * model.addAttribute("newOrder", o); return "orderForm"; }
	 * 
	 * @PostMapping("/update/{id}") public String reviseOrder(Orders o, Model model)
	 * { oRepo.save(o); return viewOrder(model); }
	 * 
	 * @GetMapping("/delete/{id}") public String deleteOrder(@PathVariable("id") int
	 * id, Model model) { Orders o = oRepo.findById(id).orElse(null);
	 * oRepo.delete(o); return viewOrder(model); }
	 */

}
