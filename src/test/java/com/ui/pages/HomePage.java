package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility
{
	
	private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),\"Sign in\")]");
	
	//calling constructor of parent class
	public HomePage(Browser browsername,Boolean isheadless) {
		super(browsername,isheadless);
		//goToWebsite(readProperty(QA, "URL"));//trying to remove hardcoded website link and use it from a properties file
		goToWebsite(JSONUtility.readJson(QA).getUrl());//trying to launch website from the json perspective
	}

	public HomePage(WebDriver lambdaDriver) {
		super(lambdaDriver);
		//goToWebsite(readProperty(QA, "URL"));//trying to remove hardcoded website link and use it from a properties file
		goToWebsite(JSONUtility.readJson(QA).getUrl());//trying to launch website from the json perspective
	}

	public LoginPage goToLoginPage()//Page Functions(Methods) cannot have a void return type
	{
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginpage = new LoginPage(getDriver());
		return loginpage;
	}
}
