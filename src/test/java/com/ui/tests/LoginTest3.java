package com.ui.tests;

import static com.constants.Browser.*;//if we perform a static import, we don't need to write the entity name

import static org.testng.Assert.*;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojos.User;
import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest3 extends TestBase{
	
		
		@Test(description = "Verifies that the valid user is able to login in to the application or not",groups= {"e2e","sanity"},dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestDataProvider",
				retryAnalyzer =com.ui.listeners.MyRetryAnalyzer.class)
		public void loginTest(User user) {
			//logger.info("Started My Login Test!!");
		assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailaddress(),user.getPassword()).getUserName(),"Deeksha Bajad1");//Assert is a class in TestNG
		//logger.info("My Login Test Ended!!");
		}
		
//		@Test(description = "Verifies that the valid user is able to login in to the application or not",groups= {"e2e","sanity"},dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestCSVDataProvider")
//		public void loginCSVTest(User user) {
//			
//		assertEquals(homepage.goToLoginPage().doLoginWith(user.getEmailaddress(),user.getPassword()).getUserName(),"Deeksha Bajad");//Assert is a class in TestNG
//		
//		}
}
