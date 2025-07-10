package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtility;

import static com.utility.PropertiesUtil.*;

public class MyRetryAnalyzer implements IRetryAnalyzer{//MyRetryAnalyzer is called only when a test fails

	//private static final int MAX_NUMBER_OF_ATTEMPTS = Integer.parseInt(readProperty(Env.QA, "MAX_NUMBER_OF_ATTEMPTS"));//from properties file
	private static final int MAX_NUMBER_OF_ATTEMPTS = JSONUtility.readJson(Env.QA).getMAX_NUMBER_OF_ATTEMPTS();//from the jsonutility file
	
	private static int currentAttempts = 1;
	
	@Override
	public boolean retry(ITestResult result) {//retry method gets executed automatically when a test fails, ITestResult stores the details of the failed test
		
		if(currentAttempts<=MAX_NUMBER_OF_ATTEMPTS)
		{
			currentAttempts++;
			return true;
		}
		
		return false;//if retry method returns true : go ahead and re-run the tests and if it returns false : Then the test will be marked as failed
	}

}
