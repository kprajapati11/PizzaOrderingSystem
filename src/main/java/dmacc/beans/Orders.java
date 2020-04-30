
package dmacc.beans;

import java.util.List;

import javax.persistence.Entity;



@Entity
public class Orders {

	private int orderId;
	private int customerId;
	private List<String> orderDesc;
	private float totalAmt;
	
	public Orders() {
		
	}
	
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public List<String> getOrderDesc() {
		return orderDesc;
	}
	public void setOrderDesc(List<String> orderDesc) {
		this.orderDesc = orderDesc;
	}
	public float getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(float totalAmt) {
		this.totalAmt = totalAmt;
	}
	
	
	
	
}
