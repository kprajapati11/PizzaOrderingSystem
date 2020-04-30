package dmacc;

import java.math.BigDecimal;

import org.springframework.core.convert.converter.Converter;

import dmacc.model.Item;

public class StringToItemConverter implements Converter<String, Item> {
	@Override
	public Item convert(String name) {
	    if(name.equals("onion")) {
	    	Item onion = new Item("onion", BigDecimal.valueOf(0.99));
	      return onion;
	    }else if(name.equals("bacon")) {
	    	Item bacon = new Item("bacon", BigDecimal.valueOf(0.99));
	    	return bacon;
	    }else if(name.equals("olive")) {
	    	Item olive = new Item("olive", BigDecimal.valueOf(0.99));
	    	return olive;
	    }else if(name.equals("pineapple")) {
	    	Item pineapple = new Item("pineapple", BigDecimal.valueOf(0.99));
	    	return pineapple;
	    }else if(name.equals("tomato")) {
	    	Item tomato = new Item("tomato", BigDecimal.valueOf(0.99));
	    	return tomato;
	    }else if(name.equals("pepper")) {
	    	Item pepper = new Item("pepper", BigDecimal.valueOf(0.99));
	    	return pepper;
	    }
	    return null;
	}
}
