package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility{

	static final By EMAIL_FIELD_LOCATOR = By.id("email");
	static final By PASSWORD_FIELD_LOCATOR = By.id("passwd");
	static final By SUBMIT_BUTTON_LOCATOR = By.id("SubmitLogin");
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	public MyAccountPage doLoginWith(String username,String password) {
		enterText(EMAIL_FIELD_LOCATOR,username);
		enterText(PASSWORD_FIELD_LOCATOR,password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;
	}

}
