package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.testng.annotations.BeforeMethod;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;

public class TestBase {
	
	protected HomePage hompePage;

	@BeforeMethod(description = "load the HomePage of the website")
	public void setup() {
		 hompePage = new  HomePage(CHROME);
	}
	
	public BrowserUtility getInstance() {
		return hompePage;
	}
	
}
