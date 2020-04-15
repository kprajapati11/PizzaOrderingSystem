package dmacc.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
public class OrderDetails {
	private int orderID;
	private int size;// holds the size of the pizza
	private double priceCrust;// holds the price of pizza crust plus cheese
	private double toppingPrice;//holds price of topping
	private LocalDate orderdate; //holds date of order
	private LocalTime orderTime;//holds time of order
	private LocalDateTime deliveryTime;//Time of dilivery
	private double totalPrice = 0;

}
