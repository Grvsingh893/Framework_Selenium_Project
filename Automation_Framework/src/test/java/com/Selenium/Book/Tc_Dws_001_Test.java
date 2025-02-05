package com.Selenium.Book;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Selenium.genericUtility.BaseClass;
import com.Selenium.objectRepository.HomePage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Tc_Dws_001_Test extends BaseClass {
	@Test
	public void clickOnBooks() {
		ExtentTest test = extReport.createTest("clickOnBooks");
		hP = new HomePage(driver);
		hP.getBooksLink().click();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Books", "Books page is not displayed");
		test.log(Status.PASS, "Books Page is Displayed");
	}
	
	
}
