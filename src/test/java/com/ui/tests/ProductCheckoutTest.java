package com.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.constants.Size;
import com.ui.pages.ProductDetailPage;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase {

	private static final String SEARCH_TERM = "Printed Summer dress";

	private SearchResultPage searchResultPage;

	@BeforeMethod(description = "User Logs into the application and searches for a product")
	public void setup() {
		searchResultPage = homePage.goToLoginPage().doLoginWith("gogab23467@soppat.com", "password")
				.searchForAProduct(SEARCH_TERM);
		
	}
	
	@Test(description = "Verify if the logged in User is able to buy a dress", groups = { "e2e", "smoke", "sanity" })
	public void checkoutTest() throws InterruptedException {
		 String result = searchResultPage.clickOnTheProductAtIndex(0).changeSize(Size.M).addProductToCart().proceedToCheckout().goToConfirmAddressPage().goToShippmentPage().goToPaymentPage().makePayment();
		 System.out.println(result);
				 Thread.sleep(5000);
		 
	}

}
