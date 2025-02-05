package com.Selenium.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Gaurav
 */
public class FileUtility {
	/**
	 * This method is used to get data from property file.
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getDataFromProperty(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/Test_Data/commonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);

	}

}
