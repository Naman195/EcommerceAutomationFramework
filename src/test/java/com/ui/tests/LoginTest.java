package com.ui.tests;

import static com.constants.Browser.*;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;

public class LoginTest {
	HomePage hompePage;
	
	@BeforeTest(description = "load the HomePage of the website")
	public void setup() {
		 hompePage = new  HomePage(CHROME);
	}
	
	
	
		
		@Test(description = "Verifies with the valid user is able to login into the application", groups = {"e3e", "sanity"})
		public void loginTest() {
			
		
		
		
		String userName = hompePage.goToLoginPage().doLoginWith("gogab23467@soppat.com", "password").getUserName();
		Assert.assertEquals(userName, "Naman Arora");
		
		}
		
	

}
