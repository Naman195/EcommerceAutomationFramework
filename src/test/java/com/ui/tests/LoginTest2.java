package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.utility.BrowserUtility;

public class LoginTest2 {
	
	
	public static void main(String[] args) {
		
		WebDriver wd =  new ChromeDriver();
		
		HomePage hompePage = new  HomePage(wd);
		LoginPage loginPage = new LoginPage(wd);
		
		hompePage.goToLoginPage();
		loginPage.doLoginWith("gogab23467@soppat.com", "password");
		
	}

}
