package dmacc.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PizzaMeal {
	private String name;
	private String size;
	private List<Item> itemsList;
	
	
	public PizzaMeal() {
		
	}
	
	public PizzaMeal(String name, String size, List<Item> itemList) {
		this.name = name;
		this.size = size;
		this.itemsList = itemList;
		
	}
	
	public PizzaMeal(String name, String size) {
		this.name = name;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	

	public List<Item> getItemsList() {
		return itemsList;
	}
	
	public void setItemsList(List<Item> itemsList) {
		this.itemsList = itemsList;
	}

	public void addItem(Item item) {
		if(this.itemsList == null ) {
			itemsList = new ArrayList<Item>();
		}
		this.itemsList.add(item);
	}

	public BigDecimal getTotalItemsAmount() {
		BigDecimal totalItemsAmount = BigDecimal.ZERO;
		if(itemsList != null && !itemsList.isEmpty()) {
			for(Item item : itemsList) {
				if(item!=null) {
					totalItemsAmount  = totalItemsAmount.add(item.getPrice());	
				}
			}
		}
		return totalItemsAmount;
	}
	
	
	
	@Override
	public String toString() {
		return "[name=" + name + ", size=" + size + ", itemsList=" + itemsList + "]";
	}
	
}
