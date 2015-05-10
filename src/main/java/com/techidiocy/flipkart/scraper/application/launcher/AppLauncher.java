package com.techidiocy.flipkart.scraper.application.launcher;

import java.io.IOException;

import com.techidiocy.flipkart.scraper.file.api.CSVFileWriter;
import com.techidiocy.flipkart.scraper.models.Items;
import com.techidiocy.flipkart.scraper.service.FlipkartProductScraper;

public class AppLauncher {
	
	public static void main(String args[]) throws IOException {
		Items iPhones = FlipkartProductScraper.search("Iphone 6");
		CSVFileWriter.write(iPhones);
		Items samsungTVs = FlipkartProductScraper.search("Samsung Tv");
		CSVFileWriter.write(samsungTVs);
		Items dlinks = FlipkartProductScraper.search("Dlink router");
		CSVFileWriter.write(dlinks);
	    Items reebok = FlipkartProductScraper.search("reebok shoes");
		CSVFileWriter.write(reebok);
		Items ac = FlipkartProductScraper.search("window ac hitachi");
		CSVFileWriter.write(ac);
	}
}
