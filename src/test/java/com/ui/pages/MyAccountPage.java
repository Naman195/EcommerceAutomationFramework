package com.ui.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utility.BrowserUtility;

public class MyAccountPage extends BrowserUtility {
	
	private static final By USER_NAME_LOCATPR = By.xpath("//a[@title='View my customer account']/span");
	
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	public String getUserName() {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

		WebElement user = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(
		    		USER_NAME_LOCATPR
		    )
		);

		return user.getText();
//		return getVisibleText(USER_NAME_LOCATPR);
	}

}
