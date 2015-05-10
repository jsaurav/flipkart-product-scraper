package com.techidiocy.flipkart.scraper.models;

import java.util.List;

public class Items {
	
	private long correlationCoefficient;
	private List<Item> items;
	private String itemName;
	private int noOfItems;
	
	public long getCorrelationCoefficient() {
		return correlationCoefficient;
	}
	public void setCorrelationCoefficient(long correlationCoefficient) {
		this.correlationCoefficient = correlationCoefficient;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getNoOfItems() {
		return noOfItems;
	}
	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}
}
