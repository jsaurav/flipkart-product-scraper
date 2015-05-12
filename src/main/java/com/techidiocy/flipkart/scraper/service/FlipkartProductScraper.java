/**
 * 
 */
package com.techidiocy.flipkart.scraper.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.techidiocy.flipkart.scraper.constants.ApplicationConstants;
import com.techidiocy.flipkart.scraper.models.Item;
import com.techidiocy.flipkart.scraper.models.Items;

public class FlipkartProductScraper {

	public static Items search(String itemName) throws IOException {
		Items items = new Items();
		items.setItemName(itemName);
		List<Item> itemList = new LinkedList<Item>();
		items.setItems(itemList);
		String url = ApplicationConstants.SEARCH_URL + itemName;
		File input = new File(ApplicationConstants.STATIC_FILE_LOCATION);
		
		
		Document doc = null;
		try {
		    doc = Jsoup.parse(new URL(url),1000*60);
		    throw new IOException();
		} catch(IOException io) {
			//Test html page in case net connectivity is not there.
			//our application will parse this html page
			doc = Jsoup.parse(input, "UTF-8", url);
		}
		
		Elements imageElements = doc.select(ApplicationConstants.IMAGE_ELEMENT_IDENTIFIER);
		Elements nameElements = doc.select(ApplicationConstants.NAME_ELEMENT_IDENTIFIER);
		Elements ratingElements = doc.select(ApplicationConstants.RATING_ELEMENT_IDENTIFIER);
		Elements priceElements = doc.select(ApplicationConstants.PRICE_ELEMENT_IDENTIFIER);
		
		int itemsCounter=0;
		
		for(int i=0;i<ApplicationConstants.TOTAL_NO_OF_ITEMS && i<ratingElements.size();i++) {
			Item item = new Item();
			Element imageElement = imageElements.get(i);
			Element nameElement = nameElements.get(i);
			Element ratingElement = ratingElements.get(i);
			Element pricingElement = priceElements.get(i);
			pricingElement = pricingElement.child(0);
			
			String imageUrl = ApplicationConstants.BASE_URL + imageElement.attr(ApplicationConstants.HREF);
			String productName = nameElement.text();
			String rating = ratingElement.text();
			String price = pricingElement.text();
			
			item.setImageURL(imageUrl);
			item.setProductName(productName);
			item.setReviewScore(rating);
			item.setPrice(price);
			itemList.add(item);
			itemsCounter++;
			
		}
		items.setNoOfItems(itemsCounter);		
		return items;
	}
}
