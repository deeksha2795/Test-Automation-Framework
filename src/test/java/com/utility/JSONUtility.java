package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojos.Config;
import com.ui.pojos.Environment;

public class JSONUtility {

	public static Environment readJson(Env env)  {
	
		Gson gson = new Gson();//Help us read json data from a josn file as we have kept our configurations in a json file
		File jsonFile = new File(System.getProperty("user.dir")+"\\config\\config.json");//pointing to the config.json file
		FileReader filereader= null;
		try {
			filereader = new FileReader(jsonFile);//why try-catch : because what if the file is not present/deleted
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Config config = gson.fromJson(filereader, Config.class);
		Environment environment = config.getEnvironments().get("QA");//Get the QA environments from all the environments present in the env file
		//System.out.println(environment.getUrl());
		return environment;
	}

}
