package dmacc.beans;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;


import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
@Embeddable
public class Customer {
	@Id
	private int id;
	private String name;
	private String Phone;
	private String email;
	@Autowired
	private Address address;
	
	public Customer(String name) {
		super();
		this.name = name;
	}
	
	

}
