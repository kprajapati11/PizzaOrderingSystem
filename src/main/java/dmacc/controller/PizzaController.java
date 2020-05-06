package dmacc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dmacc.Enums.PizzaCrustEnum;
import dmacc.Enums.PizzaSizeEnum;
import dmacc.model.Order;
import dmacc.model.Pizza;
import dmacc.model.Topping;
import dmacc.repository.OrderRepository;
import dmacc.repository.PizzaRepository;
import dmacc.repository.ToppingRepository;

@Controller
@RequestMapping(value = "/orders/{orderId}/pizzas")
public class PizzaController
{

  @Autowired
  private OrderRepository orderRepo;
  
  @Autowired
  private PizzaRepository pizzaRepo;

  @Autowired
  private ToppingRepository toppingRepo;

  @RequestMapping(value = "", method = RequestMethod.GET)
  public String pizzaGet(ModelMap model, @PathVariable Long orderId)
  {

    model.put("pizzaSizes", PizzaSizeEnum.values());
    model.put("pizzaCrustTypes", PizzaCrustEnum.values());
    model.put("toppings", toppingRepo.findAll());

    Pizza pizza = new Pizza();
    model.put("pizza", pizza);

    return "pizzas";
  }

  @RequestMapping(value = "", method = RequestMethod.POST)
  public String pizzaPost(ModelMap model, @PathVariable Long orderId, @ModelAttribute Pizza pizza)
  {
    Order order = orderRepo.findById(orderId).orElse(null);
    
    Double pizzaPrice = 0.0;
    
    for (Topping topping : pizza.getToppings())
    {
      topping.getPizzas().add(pizza);
      pizzaPrice += topping.getPrice();
    }
    
    pizzaPrice += pizza.getCrustType().getPrice();
    pizzaPrice += pizza.getSize().getPrice();
    pizza.setPrice(pizzaPrice);
    pizza.setOrder(order);
    order.getPizzas().add(pizza);

    orderRepo.save(order);

    return "redirect:/orders/" + orderId;
  }

  @RequestMapping(value = "/{pizzaId}/delete", method = RequestMethod.POST)
  public String pizzaPostDelete(@PathVariable Long orderId, @PathVariable Long pizzaId){
    Order order = orderRepo.findById(orderId).orElse(null);
    
    //you must remember to remove the children in order for the cascades to work
    Pizza pizzaToDelete = null;
    for (Pizza pizza : order.getPizzas()){
      if(pizza.getPizzaId().equals(pizzaId)){
        pizzaToDelete = pizza;
        
      }
    }
    if(pizzaToDelete != null){
      pizzaToDelete.getToppings().clear();
      order.getPizzas().remove(pizzaToDelete);
      pizzaToDelete.setOrder(null);
    }
    
    orderRepo.save(order);
    
    return "redirect:/orders/" + orderId;
  }
  
}