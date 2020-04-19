package dmacc.beans;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Embeddable
public class Address {
	private String Street;
	private String city;
	private String zipCode;
	
}
