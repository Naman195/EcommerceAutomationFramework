package com.ui.tests;

import static com.constants.Browser.CHROME;

import java.net.http.HttpRequest.BodyPublisher;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;

public class TestBase {
	
	protected HomePage hompePage;
	private boolean isLambdaTest = true;
	

	@BeforeMethod(description = "load the HomePage of the website")
	@Parameters({ "browser", "isLambdaTest", "isHeadless" })
	public void setup(@Optional("chrome") String browser, @Optional("false") boolean isLambdaTest,
			@Optional("false") boolean isHeadless, ITestResult result) {
		this.isLambdaTest = isLambdaTest;
		WebDriver lambdaDriver;
		if(isLambdaTest) {
			lambdaDriver = LambdaTestUtility.initializeTestLambdaSession("chrome", result.getMethod().getMethodName());
			hompePage = new  HomePage(lambdaDriver);
			
		}else {
//			hompePage = new  HomePage(Browser.CHROME, isHeadless);
			hompePage = new HomePage(Browser.valueOf("chrome".toUpperCase()), isHeadless);
		}
	}
	
	public BrowserUtility getInstance() {
		return hompePage;
	}
	
	@AfterMethod(description = "Tear Down the browser")
	public void tearDown() {

		if (isLambdaTest) {
			LambdaTestUtility.quitSession(); // quit or close the browsersession on LT
		} else {
			hompePage.quit(); // local
		}
	}
}
