package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.utility.BrowserUtility;

public class LoginTestOLD {
	
	
	public static void main(String[] args) {
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--disable-notifications");
//		options.addArguments("--start-maximized");
		WebDriver wd =  new ChromeDriver();
		BrowserUtility browserUtility = new BrowserUtility(wd);
		browserUtility.goToWebsite("https://automationpractice.techwithjatin.com/");
//		wd.get("https://automationpractice.techwithjatin.com/");
//		wd.manage().window().maximize();
		browserUtility.maximizeWindow();
		
		By signInLink =  By.xpath("//div[@class='header_user_info']/a");
		browserUtility.clickOn(signInLink);

		
		By emailInput = By.xpath("//input[@id='email']");
		By passInput = By.xpath("//input[@id='passwd']");
		By submitBtn = By.xpath("//button[@id='SubmitLogin']");
		
		
		browserUtility.enterText(emailInput, "gogab23467@soppat.com");
		browserUtility.enterText(passInput, "password");
		
		browserUtility.clickOn(submitBtn);
		
		
	}

}
