package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LoginTest {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver();//wd is storing the browser instance where the website should be open
		
		BrowserUtility browserutility = new BrowserUtility(wd);
		browserutility.goToWebsite("http://www.automationpractice.pl/index.php?");//Instead of using any selenium methods we are using wrapper method
		
		browserutility.maximizeWindow();
		
		//To find a web element for the Sign in button
		//we have used the xpath locator and xpath method from the 'By'abstract class
		By signInLinkLocator = By.xpath("//a[contains(text(),\"Sign in\")]");//its return type is by
		browserutility.clickOn(signInLinkLocator);
		

		
		//to locate the email & password fieldsand click on submit button
		By emailFieldLocator = By.id("email");
		browserutility.enterText(emailFieldLocator,"fekerih850@asimarif.com");
		
		By passwordFieldLocator = By.id("passwd");
		browserutility.enterText(passwordFieldLocator, "password");
		
		//SubmitLogin
		By submitButtonLocator = By.id("SubmitLogin");
		browserutility.clickOn(submitButtonLocator);
		
		
		
		

	}

}
