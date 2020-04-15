package dmacc.beans;

import javax.persistence.Entity;

@Entity
public class Pizza {
	private int orderId;
	private String singleTopping;
	private String size;
	private double price;
	
}
