package com.utility;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.apache.commons.io.FileUtils;
import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	
	public WebDriver getDriver() {
		return driver.get();
	}


	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);;//Initialize the instance variable 'driver'
	}
	
	
	public BrowserUtility(Browser browsername,Boolean isHeadless)
	{
		if(browsername==Browser.CHROME)
		{
			if(isHeadless)
			{
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");//==old is mandatory else a white browserscreen appears
				options.addArguments("--window-size=1920,1080");//even in headless mode the size of the window is fullscreen
				driver.set(new ChromeDriver(options));
			}
			else
			{
				driver.set(new ChromeDriver());
			}
		}
		else if(browsername==Browser.EDGE)
		{
			if(isHeadless) {
				EdgeOptions options  = new EdgeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--disable-gpu");
				options.addArguments("--window-size=1920,1080");
				options.addArguments("--no-sandbox");
				driver.set(new EdgeDriver(options));
			}
			else
			{
				driver.set(new EdgeDriver());
			}
			
		}
		else
		{
			System.err.println("Invalid Browser Name!! Please Select Chrome or Edge Only");
		}
	}
	
	
	//wrapper method to go to a website or open a website on browser
	public void goToWebsite(String url)
	{
		driver.get().get(url);//url is the url of the website to be launched
	}
	
	public void maximizeWindow()
	{
		//In order to maximize the browser window
		driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator)
	{
		WebElement element = driver.get().findElement(locator);//now we need to find the element using that xpath
		element.click();//click on the element if found
	}
	
	public void enterText(By locator,String textToEnter)
	{
		WebElement element = driver.get().findElement(locator);
		element.sendKeys(textToEnter);
	}
	
	public String getVisibleText(By locator)
	{
		WebElement element = driver.get().findElement(locator);
		return element.getText();
	}
	
	
	
	//Method to take screenshot of the errors 
	public String takeScreenShot(String name)
	{
		TakesScreenshot screenshot = (TakesScreenshot)driver.get();
		
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-MM-SS");
		String timeStamp = format.format(date);
		String path = System.getProperty("user.dir")+"//screenshots//"+name+"-"+timeStamp+".png";
		
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData,screenshotFile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return path;
		
	}
	
	
	public static void quitSession() {
		if(driver.get()!= null)
		{
			driver.get().quit();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
