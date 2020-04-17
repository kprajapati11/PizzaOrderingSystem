package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Orders;
import dmacc.repositories.CustomerRepository;
import dmacc.repositories.OrderDetailsRepository;
import dmacc.repositories.OrdersRepository;
import dmacc.repositories.PizzaRepository;

@Controller
public class WebController {
	@Autowired
	CustomerRepository cRepo;
	@Autowired
	OrdersRepository oRepo;
	@Autowired
	OrderDetailsRepository odRepo;
	@Autowired
	PizzaRepository pRepo;
	
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

}
