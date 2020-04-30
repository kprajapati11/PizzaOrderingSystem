package dmacc.util;

import java.util.Arrays;

public enum PizzaSize {

	SMALL("small"),
	MEDIUM("medium"),
	LARGE("large");
	
	private String code;
	
	PizzaSize(String code) {
		this.code = code;
	}

	public static PizzaSize getSizefromCode(String code) {
		return Arrays.stream(values()).filter(s->s.getCode().equals(code)).findFirst().get();
	}
	
	private String getCode() {
		return code;
	}

}
