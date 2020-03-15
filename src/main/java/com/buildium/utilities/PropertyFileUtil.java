package com.buildium.utilities;

import java.io.FileInputStream;
import java.util.Properties;


public class PropertyFileUtil {

		public static String getValueForKey(String Key) throws Exception{
			
			Properties configProperties=new Properties();
			
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\PropertiesFile\\Enviroment.properties");
			
			configProperties.load(fis);
			
			return configProperties.getProperty(Key);
			
		}

}
