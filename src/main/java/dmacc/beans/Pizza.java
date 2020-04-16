package dmacc.beans;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@ToString
@Entity
public class Pizza {
	private int orderId;
	private String singleTopping;
	private String size;
	private double price;
	
}
