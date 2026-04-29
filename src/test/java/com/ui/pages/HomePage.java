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
	
	public HomePage(Browser browsername ) {
		super(browsername);
//		goToWebsite(PropertiesUtil.readProperty(Env.QA, "URL"));
		goToWebsite(JSONUtility.readJson(Env.QA));
	}
	
	public LoginPage goToLoginPage() {
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
		
		
	}
	

}
