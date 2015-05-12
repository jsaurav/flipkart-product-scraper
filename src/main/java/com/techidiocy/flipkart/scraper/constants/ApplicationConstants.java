package com.techidiocy.flipkart.scraper.constants;

import com.techidiocy.flipkart.scraper.service.FlipkartProductScraper;


public class ApplicationConstants {
	
	public static final String SEARCH_URL = "http://www.flipkart.com/search?q=";
	public static final String BASE_URL = "http://www.flipkart.com";
	public static final String HREF = "href";
	public static final int TOTAL_NO_OF_ITEMS = 10;
	public static final String IMAGE_ELEMENT_IDENTIFIER = ".pu-image";
	public static final String NAME_ELEMENT_IDENTIFIER = ".pu-title .fk-display-block";
	public static final String RATING_ELEMENT_IDENTIFIER = ".pu-rating";
	public static final String PRICE_ELEMENT_IDENTIFIER = ".pu-final";
	public static final String DEFAULT_CSV_FILE_NAME = "data";
	public static final String CSV_EXTENSION = ".csv";
	public static final CharSequence FILE_HEADER = "Product Name,Product Price,Rating,Image URL";
	public static final CharSequence NEW_LINE_CHARACTER = "\n";
	public static final String COMMA = ",";
	//public static final String STATIC_FILE_LOCATION = "html/flipkart.html";
	public static final String STATIC_FILE_LOCATION = FlipkartProductScraper.class.getClassLoader()
            .getResource("html/flipkart.html").getFile();

}
