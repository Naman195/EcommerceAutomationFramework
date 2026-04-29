package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class LoginPage extends BrowserUtility {
	
	private static final By EMAIL_INPUT_LOCATOR = By.xpath("//input[@id='email']");
	private static final By PASSWORD_INPUT_LOCATOR = By.xpath("//input[@id='passwd']");
	private static final By SUBMIT_BTN_LOCATOR = By.xpath("//button[@id='SubmitLogin']");
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public MyAccountPage doLoginWith(String email, String password) {
		enterText(EMAIL_INPUT_LOCATOR, email);
		enterText(PASSWORD_INPUT_LOCATOR, password);
		clickOn(SUBMIT_BTN_LOCATOR);
		
		MyAccountPage myAccount = new MyAccountPage(getDriver());
		return myAccount;
	}
	
	

}
