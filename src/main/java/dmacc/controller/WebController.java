package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Customer;
import dmacc.beans.Orders;
import dmacc.repositories.CustomerRepository;
import dmacc.repositories.OrderDetailsRepository;
import dmacc.repositories.OrdersRepository;



@Controller
public class WebController {
	@Autowired
	CustomerRepository cRepo;
	@Autowired
	OrdersRepository oRepo;


	@GetMapping({"/", "viewOrder"})
	public String viewOrder(Model model) {
		if(oRepo.findAll().isEmpty()) {
			return addNewItem(model);
		}
		model.addAttribute("order", oRepo.findAll());
		return "orderDetails";
	}
	@GetMapping("/newOrder")
	public String addNewItem(Model model) {
		Orders o = new Orders();
		model.addAttribute("newOrder", o);
		return "orderForm";
	}
	@PostMapping("/newOrder")
	public String addNewOrder(@ModelAttribute Orders o, Model model) {
		oRepo.save(o);
		return viewOrder(model);
	}
	@GetMapping("/edit/{id}")
	public String showUpdateOrder(@PathVariable("id") int id, Model model) {
		Orders o = oRepo.findById(id).orElse(null);
		model.addAttribute("newOrder", o);
		return "orderForm";
	}
	@PostMapping("/update/{id}")
	public String reviseOrder(Orders o, Model model) {
		oRepo.save(o);
		return viewOrder(model);
	}
	@GetMapping("/delete/{id}")
	public String deleteOrder(@PathVariable("id") int id, Model model) {
		Orders o = oRepo.findById(id).orElse(null);
		oRepo.delete(o);
		return viewOrder(model);
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
