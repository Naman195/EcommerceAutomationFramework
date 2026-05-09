package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.constants.Env;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

public final  class HomePage extends BrowserUtility {
	
	private static final By SIGN_IN_LINK_LOCATOR =  By.xpath("//div[@class='header_user_info']/a");
	
	public HomePage(Browser browsername, boolean isHeadless) {
		super(browsername, isHeadless);
//		goToWebsite(PropertiesUtil.readProperty(Env.QA, "URL"));
		goToWebsite(JSONUtility.readJson(Env.QA).getUrl()); // read
	}
	
	public HomePage(WebDriver driver) {
		super(driver); // To Call the Parent Class constructor from the child constructor
		goToWebsite(JSONUtility.readJson(Env.QA).getUrl()); // read
	}
	
	public LoginPage goToLoginPage() {
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
		
		
	}
	

}
