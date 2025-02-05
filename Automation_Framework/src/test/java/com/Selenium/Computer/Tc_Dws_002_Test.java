package com.Selenium.Computer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Selenium.genericUtility.BaseClass;
import com.Selenium.objectRepository.HomePage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Tc_Dws_002_Test extends BaseClass {
		@Test
		public void clickOnComputers() {
			ExtentTest test = extReport.createTest("clickOnComputers");
			hP = new HomePage(driver);
			hP.getComputersLink().click();
			Assert.assertEquals(driver.getTitle(),"Demo Web Shop. Computers", "Computers page is not displayed");
			test.log(Status.PASS, "Computers page is displayed");

		}

	}
