package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.constants.Browser;

public abstract  class BrowserUtility {
	
	private WebDriver driver;
	
	public BrowserUtility(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	public BrowserUtility(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else {
			System.err.print("Invalid Browser name, please select chrome or edge");
		}
	}
	
	public BrowserUtility(Browser browserName) {
		if(browserName == Browser.CHROME) {
			driver = new ChromeDriver();
		}else if (browserName == Browser.EDGE) {
			driver = new EdgeDriver();
		}else {
			System.err.print("Invalid Browser name, please select chrome or edge");
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}


	public void goToWebsite(String url) {
		driver.get(url);
	}
	
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	public void clickOn(By locator) {
		WebElement element = driver.findElement(locator);
		element.click();
		
	}
	
	public void enterText(By locator, String textToEnter) {
		WebElement element = driver.findElement(locator);
		element.sendKeys(textToEnter);
	}
	
	public String getVisibleText(By locator) {
		
		WebElement element = driver.findElement(locator);
		return element.getText();
	}
	

}
