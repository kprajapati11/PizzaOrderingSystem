package dmacc.util;

import java.util.Arrays;
import java.util.Objects;

public enum PizzaName {
	CHICKEN("chicken"),
	CHEESE("cheese"),
	PEPPERONI("pepperoni"), 
	VEGPIZZA("vegpizza"), 
	SUPREME("supreme");
	
	private String code;
	
	PizzaName(String code) {
		this.code = code;
	}

	public static PizzaName getPizzaNameFromCode(String pizzaCode) {
		return Objects.isNull(pizzaCode) ? null : Arrays.stream(values()).filter(pizzaName->pizzaName.getCode().equals(pizzaCode)).findFirst().get();
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}
