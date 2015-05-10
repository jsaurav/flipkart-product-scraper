package com.techidiocy.flipkart.scraper.models;

import com.techidiocy.flipkart.scraper.constants.ApplicationConstants;

public class Item {
	
	private String imageURL;
	private String productName;
	private String price;
	private String reviewScore;
	
	
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getReviewScore() {
		return reviewScore;
	}
	public void setReviewScore(String reviewScore) {
		this.reviewScore = reviewScore;
	}
	
	
	public String toString() {
		return this.productName + ApplicationConstants.COMMA +
			   this.price + ApplicationConstants.COMMA +
			   this.reviewScore + ApplicationConstants.COMMA +
			   this.imageURL + ApplicationConstants.COMMA;
	}
	

}
