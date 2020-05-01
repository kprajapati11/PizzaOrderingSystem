package dmacc.beans;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class Address {
	private String Street;
	private String city;
	private String state;
	private String zipCode;
	

}
