package dmacc.beans;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Pizza {
	@Id
	private int pId;
	private String singleTopping;
	private String size;
	private double price;
	
}
