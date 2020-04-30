package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.model.Item;
import dmacc.model.PizzaMeal;

@Configuration
public class BeanConfiguration {


	@Bean 
	public PizzaMeal get() {
		return new PizzaMeal();
	}
	
	
	@Bean 
	public Item getItem() {
		return new Item();
	}
	
}
