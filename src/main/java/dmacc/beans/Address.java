package dmacc.beans;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Embeddable
public class Address {
	private String Street;
	private String city;
	private String zipCode;
	

}
