
package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Customer;
<<<<<<< HEAD
import dmacc.model.CheesePizzaMeal;
import dmacc.model.ChickenPizzaMeal;
import dmacc.model.Item;
import dmacc.model.PepperoniPizzaMeal;
import dmacc.model.PizzaMeal;
import dmacc.model.SupremePizzaMeal;
import dmacc.model.VegPizzaMeal;
import dmacc.repository.CustomerRepository;
import dmacc.util.PizzaName;
=======
import dmacc.beans.Orders;
import dmacc.repositories.CustomerRepository;
import dmacc.repositories.OrderDetailsRepository;
import dmacc.repositories.OrdersRepository;


>>>>>>> 4f8fcf83a9230b8cce368fa2830880b536466a7b

@Controller
public class WebController {

	@Autowired
<<<<<<< HEAD
	private CustomerRepository cRepo;

	@GetMapping("/newPizza")
	public String createNewPizza(Model model) {
		// this is a model only to display in UI
		PizzaMeal pizza = new PizzaMeal();
		pizza.addItem(new Item("onion", null));
		pizza.addItem(new Item("bacon", null));
		pizza.addItem(new Item("olive", null));
		pizza.addItem(new Item("pineapple", null));
		pizza.addItem(new Item("pepper", null));
		pizza.addItem(new Item("tomato", null));

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
		if (pizza.getName().replaceAll(",", "").equals(String.valueOf(PizzaName.CHICKEN))) {

			ChickenPizzaMeal customerMeal = new ChickenPizzaMeal(pizza.getName(), pizza.getSize());
			customerMeal.setItemsList(pizza.getItemsList());
			model.addAttribute("pizzaDetail", customerMeal);

		} else if (pizza.getName().replaceAll(",", "").equals(String.valueOf(PizzaName.CHEESE))) {

			CheesePizzaMeal customerMeal = new CheesePizzaMeal(pizza.getName(), pizza.getSize());
			customerMeal.setItemsList(pizza.getItemsList());
			model.addAttribute("pizzaDetail", customerMeal);

		} else if (pizza.getName().replaceAll(",", "").equals(String.valueOf(PizzaName.PEPPERONI))) {

			PepperoniPizzaMeal customerMeal = new PepperoniPizzaMeal(pizza.getName(), pizza.getSize());
			customerMeal.setItemsList(pizza.getItemsList());
			model.addAttribute("pizzaDetail", customerMeal);

		} else if (pizza.getName().replaceAll(",", "").equals(String.valueOf(PizzaName.VEGPIZZA))) {

			VegPizzaMeal customerMeal = new VegPizzaMeal(pizza.getName(), pizza.getSize());
			customerMeal.setItemsList(pizza.getItemsList());
			model.addAttribute("pizzaDetail", customerMeal);

		} else if (pizza.getName().replaceAll(",", "").equals(String.valueOf(PizzaName.SUPREME))) {

			SupremePizzaMeal customerMeal = new SupremePizzaMeal(pizza.getName(), pizza.getSize());
			customerMeal.setItemsList(pizza.getItemsList());
			model.addAttribute("pizzaDetail", customerMeal);

=======
	CustomerRepository cRepo;
	@Autowired
	OrdersRepository oRepo;


	@GetMapping({"/", "viewOrder"})
	public String viewOrder(Model model) {
		if(oRepo.findAll().isEmpty()) {
			return addNewItem(model);
>>>>>>> 4f8fcf83a9230b8cce368fa2830880b536466a7b
		}

		return "pizzaDetail";
	}

	/*********************************************************************/
	/* Customer controller methods */
	@GetMapping({ "/", "viewAll" })
	public String viewAllCustomers(Model model) {
		if (cRepo.findAll().isEmpty()) {
			return addNewCustomer(model);
		}
		model.addAttribute("contacts", cRepo.findAll());
		return "customer_result";
	}

	@GetMapping("/addCustomer")
	public String addNewCustomer(Model model) {
		Customer c = new Customer();
		model.addAttribute("newCustomer", c);
		return "customerRegistration";
	}

	@PostMapping("/addCustomer")
	public String addNewCustomer(@ModelAttribute Customer c, Model model) {
		cRepo.save(c);
		return viewAllCustomers(model);
	}

	@GetMapping("/edit/{id}")
	public String showUpdateCustomer(@PathVariable("id") int id, Model model) {
		Customer c = cRepo.findById(id).orElse(null);
		model.addAttribute("newCustomer", c);
		return "customerRegistration";
	}

	@PostMapping("/update/{id}")
	public String reviseCustomers(Customer c, Model model) {
		cRepo.save(c);
		return viewAllCustomers(model);
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id, Model model) {
		Customer c = cRepo.findById(id).orElse(null);
		cRepo.delete(c);
		return viewAllCustomers(model);
	}
	
	/*********************************************************************/
	/* Customer controller methods */
	@GetMapping({"/", "viewAll"})
	public String viewAllCustomers(Model model) {
		if(cRepo.findAll().isEmpty()) {
			return addNewCustomer(model);
		}
		model.addAttribute("contacts", cRepo.findAll());
		return "customer_result";
	}
	@GetMapping("/addCustomer")
	public String addNewCustomer(Model model) {
		Customer c = new Customer();
		model.addAttribute("newCustomer", c);
		return "customerForm";
	}
	@PostMapping("/addCustomer")
	public String addNewCustomer(@ModelAttribute Customer c, Model model) {
		cRepo.save(c);
		return viewAllCustomers(model);
	}
	@GetMapping("/edit/{id}")
	public String showUpdateCustomer(@PathVariable("id") int id, Model model) {
		Customer c = cRepo.findById(id).orElse(null);
		model.addAttribute("newCustomer", c);
		return "customerForm";
	}
	@PostMapping("/update/{id}")
	public String reviseCustomers(Customer c, Model model) {
		cRepo.save(c);
		return viewAllCustomers(model);
	}
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id, Model model) {
		Customer c = cRepo.findById(id).orElse(null);
		cRepo.delete(c);
		return viewAllCustomers(model);
	}

}
