package com.ui.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utility.BrowserUtility;

public class MyAccountPage extends BrowserUtility {
	
	private static final By USER_NAME_LOCATPR = By.xpath("//a[@title='View my customer account']/span");
	private static final By SEARCH_TEXT_BOX_LOCATOR = By.id("search_query_top");
	private static final By ADD_NEW_ADDRESS_LINK_LOCATOR = By.xpath("//a[@title=\"Add my first address\"]");
	
	
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
	
	public SearchResultPage searchForAProduct(String productName) {
//		enterText(SEARCH_TEXT_BOX_LOCATOR, productName);
//		enterSpecialKey(SEARCH_TEXT_BOX_LOCATOR, Keys.ENTER);
//		SearchResultPage searchResultPage = new SearchResultPage(getDriver());
//		return searchResultPage;
		
		 WebDriverWait wait =
		            new WebDriverWait(getDriver(),
		                    Duration.ofSeconds(10));

		    wait.until(ExpectedConditions
		            .visibilityOfElementLocated(
		                    SEARCH_TEXT_BOX_LOCATOR));

		    enterText(SEARCH_TEXT_BOX_LOCATOR, productName);

		    enterSpecialKey(
		            SEARCH_TEXT_BOX_LOCATOR,
		            Keys.ENTER);

		    return new SearchResultPage(getDriver());
	}
	
	public AddressPage goToAddAddressPage() {
		clickOn(ADD_NEW_ADDRESS_LINK_LOCATOR);

		AddressPage addressPage = new AddressPage(getDriver());
		return addressPage;
	}

}
