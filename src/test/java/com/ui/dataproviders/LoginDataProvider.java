package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojos.*;
import com.utility.CSVReaderUtility;

public class LoginDataProvider {

	@DataProvider(name = "LoginTestDataProvider")
	public Iterator<Object []> loginDataProvider() throws FileNotFoundException
	{
		Gson gson=new Gson();
		File testDataFile  = new File(System.getProperty("user.dir")+"\\TestData\\logindata.json");
		FileReader fileReader = new FileReader(testDataFile);
		TestData data = gson.fromJson(fileReader,TestData.class);
		
		List<Object[]> datatoReturn = new ArrayList<Object[]>();
		for(User user : data.getData())
		{
			datatoReturn.add(new Object[] {user});
		}
		
		return datatoReturn.iterator();
	}
	
	@DataProvider(name = "LoginTestCSVDataProvider")
	public Iterator<User> loginCSVDataProvider() {
		return CSVReaderUtility.readCSVFile("loginData.csv");
	}
}
