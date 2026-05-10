package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pages.MyAccountPage;

public class SearchProductTest extends TestBase  {
	private MyAccountPage myAccountPage;
	private static final String SEARCH_TERM = "Printed Summer dress";

	@BeforeMethod(description = "Valid user logs into the application")
	public void setup() {
		myAccountPage = homePage.goToLoginPage().doLoginWith("gogab23467@soppat.com", "password");
		
	}
	
	@Test(description = "Verify if the logged in user is able to search for a product and correct products search result are displayed", groups = {
			"e2e", "smoke", "sanity" }

	)
	public void verifyproductSearchTest() {
		boolean actualResult = myAccountPage.searchForAProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);
//		System.out.println(data);
//		boolean actualResult = myAccountPage.searchForAProduct(SEARCH_TERM)
//				.isSearchTermPresentInProductList(SEARCH_TERM);
		Assert.assertEquals(actualResult, true);
	}

}
