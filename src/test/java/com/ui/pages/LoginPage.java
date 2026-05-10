package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class LoginPage extends BrowserUtility {
	
	private static final By EMAIL_INPUT_LOCATOR = By.xpath("//input[@id='email']");
	private static final By PASSWORD_INPUT_LOCATOR = By.xpath("//input[@id='passwd']");
	private static final By SUBMIT_BTN_LOCATOR = By.xpath("//button[@id='SubmitLogin']");
	private static final By ERROR_MESSAGE_LOCATOR = By.xpath("//div[contains(@class,\"alert-danger\")]/ol/li");

	
	
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
	
	public LoginPage doLoginWithInvalidCredentials(String emailAddress, String password) {
		enterText(EMAIL_INPUT_LOCATOR, emailAddress);
		enterText(PASSWORD_INPUT_LOCATOR, password);
		clickOn(SUBMIT_BTN_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

	public String getErrorMessage() {
		return getVisibleText(ERROR_MESSAGE_LOCATOR);
	}
	
	

}
