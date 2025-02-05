package com.Selenium.genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.Selenium.objectRepository.HomePage;
import com.Selenium.objectRepository.LoginPage;
import com.Selenium.objectRepository.WelcomePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	public WebDriver driver;

	public static ExtentReports extReport;
	public JavaUtility jUtil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public FileUtility fUtil = new FileUtility();
	public WelcomePage wP;
	public HomePage hP;
	public LoginPage lP;


	@BeforeSuite
	public void configReport() {
		ExtentSparkReporter spark = new ExtentSparkReporter(
				"./Html_Reports/ExtentReport_" + jUtil.getSystemTime() + ".html");
		extReport = new ExtentReports();
		extReport.attachReporter(spark);

	}

	@Parameters("Browser")
	@BeforeClass
	public void launchBrowser(@Optional("chrome") String browserName) throws IOException {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		}
//		wUtil.maximizeWindow(driver);
		driver.manage().window().maximize();
		wUtil.implicitWait(driver);
		driver.get(fUtil.getDataFromProperty("url"));
	}
	@BeforeMethod
	public void login() throws IOException {
		wP = new WelcomePage(driver);
		wP.getLoginLink().click();
		lP = new LoginPage(driver);
		lP.getEmailTextField().sendKeys(fUtil.getDataFromProperty("Email"));
		lP.getPasswordTextField().sendKeys(fUtil.getDataFromProperty("Password"));
		lP.getLoginButton().click();

	}
	@AfterMethod
	public void logout() {
		hP = new HomePage(driver);
		hP.getLogoutLink().click();
	}


	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

	@AfterSuite
	public void reportBackUp() {
		extReport.flush();
	}

}
