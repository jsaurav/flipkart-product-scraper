package com.techidiocy.flipkart.scraper.file.api;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.techidiocy.flipkart.scraper.constants.ApplicationConstants;
import com.techidiocy.flipkart.scraper.models.Item;
import com.techidiocy.flipkart.scraper.models.Items;

public class CSVFileWriter {
	
	public static void write(Items items) throws IOException {
		String itemName = items.getItemName();
		if(itemName==null || itemName.length()==0)
			itemName = ApplicationConstants.DEFAULT_CSV_FILE_NAME;
		
		File file = new File(itemName + ApplicationConstants.CSV_EXTENSION);
		
		FileWriter writer = new FileWriter(file);
		writer.append(ApplicationConstants.FILE_HEADER);
		writer.append(ApplicationConstants.NEW_LINE_CHARACTER);
		for(Item item:items.getItems()) {
			writer.append(item.toString());
			writer.append(ApplicationConstants.NEW_LINE_CHARACTER);
		}
		writer.close();
		System.out.println("Output File Created at location -->"+file.getAbsolutePath());
	}
}
