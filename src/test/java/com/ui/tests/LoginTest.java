package com.ui.tests;

import static com.constants.Browser.*;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;

public class LoginTest {
	HomePage hompePage;
	
	@BeforeMethod(description = "load the HomePage of the website")
	public void setup() {
		 hompePage = new  HomePage(CHROME);
	}
	
	
	
		
		@Test(description = "Verifies with the valid user is able to login into the application", groups = {"e3e", "sanity"}, 
				dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
		public void loginTest(User user) {
			
		
		
		
		String userName = hompePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName();
		Assert.assertEquals(userName, "Naman Arora");
		
		}
		
		@Test(description = "Verifies with the valid user is able to login into the application", groups = {"e3e", "sanity"}, 
				dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider")
		public void loginCSVTest(User user) {
			
		
		
		
		String userName = hompePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName();
		Assert.assertEquals(userName, "Naman Arora");
		
		}
		
	

}
