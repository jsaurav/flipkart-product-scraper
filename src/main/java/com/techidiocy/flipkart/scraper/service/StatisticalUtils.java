package com.techidiocy.flipkart.scraper.service;

import org.apache.commons.math3.stat.correlation.PearsonsCorrelation;

import com.techidiocy.flipkart.scraper.models.Item;
import com.techidiocy.flipkart.scraper.models.Items;

public class StatisticalUtils {

	public static double calculateCorrelationCoefficient(Items items) {
		
		double[] priceArray   =   new double[items.getNoOfItems()];	
		double[] ratingArray  =   new double[items.getNoOfItems()];	
		
		double parsedPrice = 0;
		double parsedRating = 0;
		
		for(int i=0;i<items.getNoOfItems();i++) {
			Item item = items.getItems().get(i);
			parsedPrice = parsePrice(item.getPrice());
			parsedRating = parseRating(item.getReviewScore());
			priceArray[i] = parsedPrice;
			ratingArray[i] = parsedRating;
		}
		PearsonsCorrelation pearsonCorrelation = new PearsonsCorrelation();
		return pearsonCorrelation.correlation(priceArray, ratingArray);
	}

	private static int parseRating(String reviewScore) {
		reviewScore = reviewScore.substring(reviewScore.indexOf("(")+1,reviewScore.indexOf(" ")).trim();
		try {
			return Integer.parseInt(reviewScore);
		} catch(NumberFormatException ne) {
			return 0;
		}
	}

	private static int parsePrice(String price) {
		price = price.substring(price.indexOf(" ")).replace(",", "").trim();
		try {
			return Integer.parseInt(price);
		} catch(NumberFormatException ne) {
			return 0;
		}
	}
}
