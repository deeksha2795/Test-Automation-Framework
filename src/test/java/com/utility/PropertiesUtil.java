package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {//This class reads the content of Properties file

	public static String readProperty(Env env,String propertyName) {//FileNotException because it the file that we are pointing at van be deleted/not found , so to handle this situation
		
		System.out.println(System.getProperty("user.dir"));//gives the path of the project
		File propFile = new File(System.getProperty("user.dir")+"\\config\\"+env+".properties");//This is going to point to the property file that we want to read
		FileReader fileReader=null;
		Properties properties = new Properties();//Properties only reads the '.properties' file
		try {
			fileReader = new FileReader(propFile);
			properties.load(fileReader);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}//to read the file that propfile is pointing
	
		 catch (IOException e) {
			
			e.printStackTrace();
		}//so if file with any other exception is loaded , this can throw an IOException
		String value = properties.getProperty(propertyName.toUpperCase());//will give the value or data that we want to access from the properties file
		return value;
	}

}
