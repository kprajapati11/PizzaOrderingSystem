package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.orders;
import dmacc.repository.Repository;

public class WebController {

	
	Repository repo;

	@Autowired
	@GetMapping({ "/", "viewAll" })
	public String viewOrder(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewOrder(model);
		}
		
		model.addAttribute("orders", repo.findAll());
		return "view_order";
	}

	@GetMapping("/inputOrder")
	public String addNewOrder(Model model) {
		orders c = new orders();
		model.addAttribute("newOrder", c);
		return "order_input";
	}
	@PostMapping("/inputOrder") 
	public String addNewOrder(@ModelAttribute orders c, Model model) {   repo.save(c);   
	return viewOrder(model);  
}
@GetMapping("/edit/{id}") 
public String showUpdateOrder(@PathVariable("id") long id, Model model) {
	orders c = repo.findById(id).orElse(null);
	model.addAttribute("newOrder", c);
	return "order_input";
}
@PostMapping("/update/{id}")
public String reviseOrder(orders c, Model model) {
	repo.save(c);
	return viewOrder(model);
}
@GetMapping("/delete/{id}")
public String deleteUser(@PathVariable("id") long id, Model model) {
	orders c = repo.findById(id).orElse(null);
    repo.delete(c);
    return viewOrder(model);
}
}

