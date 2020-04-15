package dmacc.beans;

import java.time.LocalDate;

import javax.persistence.Entity;
@Entity
public class orders {
	private int id;
	private int orderID;
	private LocalDate orderDate;//Holds pizza size
	
	private double Amount;//holds total amount spent

}
