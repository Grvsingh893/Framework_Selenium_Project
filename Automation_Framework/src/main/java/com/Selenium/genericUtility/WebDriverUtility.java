package com.Selenium.genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void mouseHover(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}

	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();

	}

	public void clickAndHold(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.clickAndHold(element).perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.dragAndDrop(element, element).perform();
	}

	public void selectByIndex(WebElement dropDownEle, int index) {
		Select sel = new Select(dropDownEle);
		sel.selectByIndex(index);
	}

	public void selectByValue(WebElement dropDownEle, String value) {
		Select sel = new Select(dropDownEle);
		sel.selectByValue(value);
	}

	public void selectByVisibleText(WebElement dropDownEle, String visibleText) {
		Select sel = new Select(dropDownEle);
		sel.selectByVisibleText(visibleText);

	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);

	}

	public void switchToFrame(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);

	}

	public void switchToFrame(WebDriver driver, WebElement frameEle) {
		driver.switchTo().frame(frameEle);
	}

	public void switchToParentFrame(WebDriver driver, WebElement frameEle) {
		driver.switchTo().parentFrame();
	}

	public Alert switchToAlert(WebDriver driver) {
		return driver.switchTo().alert();
	}

	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void switchToWindow(WebDriver driver, String expUrl) {
		Set<String> allWindIds = driver.getWindowHandles();
		for (String id : allWindIds) {
			driver.switchTo().window(id);
			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(expUrl)) {
				break;

			}
		}

	}

	public Timeouts implicitWait(WebDriver driver) {
		return driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void explicitWait(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public void captureScreenShot(WebDriver driver) throws IOException {
		JavaUtility jUtil = new JavaUtility();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File tempFile = ts.getScreenshotAs(OutputType.FILE);
		File permFile = new File("./Screenshots/" + jUtil.getSystemTime() + ".png");
		FileUtils.copyFile(tempFile, permFile);

	}
}
