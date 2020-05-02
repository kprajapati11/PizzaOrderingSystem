package dmacc.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
*/

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
	/*
	 * @Id private int cId; private String Name; private String Phone; private
	 * String email;
	 * 
	 * @Autowired private Address address;
	 * 
	 * @OneToMany(targetEntity = Orders.class,cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "cp_fk", referencedColumnName = "id") private List<Orders>
	 * pizza;
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String fName;
	private String lName;
	private String phone;
	private String email;

	@Autowired
	private Address address;
	
	

}
