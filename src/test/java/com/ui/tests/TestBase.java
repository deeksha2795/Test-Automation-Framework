package com.ui.tests;

import static com.constants.Browser.EDGE;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {

	protected HomePage homepage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest; //= true;
	//private boolean isHeadLess = true;
	
	@Parameters({"browser","isLambdaTest","isHeadLess"})//creating testNG parameters and providing their values from the testng.xml
	@BeforeMethod(description="Load the Home Page of the Website")
	public void setUp(
			@Optional("chrome") String browser,
			@Optional("false") boolean isLambdaTest,
			@Optional("true")boolean isHeadLess,
			ITestResult result)
	//@Optional defines if we do not want to our test from testng.xml,so we need to provide some optional values to run a test directly
	{
		WebDriver lambdaDriver;
		if(isLambdaTest)
		{
			lambdaDriver = LambdaTestUtility.initializeLambdaTestSession(browser, result.getMethod().getMethodName());
			homepage = new HomePage(lambdaDriver);
		}
		else
		{
			//Run the test on Local Machine
			logger.info("Load the HomePage of the website");
			homepage = new HomePage(Browser.valueOf(browser.toUpperCase()),isHeadLess);
		}
		
	}
	
	public BrowserUtility getInstance()
	{
		return homepage;
	}
	

	@AfterMethod(description = "Tear Down the browser")
	public void tearDown() {
		
		if(isLambdaTest)
		{
			LambdaTestUtility.quitSession();
		}
		else
		{
			homepage.quitSession();
		}
	}
}
