package dmacc.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@ToString
@Embeddable
public class OrderDetails {
	@Id
	private int orderID;
	private int size;// holds the size of the pizza
	private double toping;// holds price of toping
	private int amount;// Holds amount of order needed
	private LocalDate orderdate; // holds date of order
	private LocalTime orderTime;// holds time of order
	private LocalDateTime deliveryTime;// Time of delivery
	private double totalPrice = 0;

	public OrderDetails(int orderId) {
		super();
		this.orderID = orderId;
		this.setDefaultTime(); // method to set order time and order Date
		this.computeOrderPrice();// method to compute price per order
		this.computeOrderTotal();// method to calculate the total of all order
	}

	public void setDefaultTime() {
		// to be implemented
	}

	public void computeOrderPrice() {
		// to be implemented
	}

	public void computeOrderTotal() {
		// to be implemented
	}
}
