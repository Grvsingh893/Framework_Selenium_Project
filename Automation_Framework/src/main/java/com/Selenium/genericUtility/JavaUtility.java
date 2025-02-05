package com.Selenium.genericUtility;

import java.time.LocalDateTime;
/**
 * @author grvsi
 */

public class JavaUtility {
	/**
	 * This method will capture system date and time and will return.
	 * @return System date and time
	 */
	public String getSystemTime() {
		return LocalDateTime.now().toString().replace(":", "-");
	}

}
