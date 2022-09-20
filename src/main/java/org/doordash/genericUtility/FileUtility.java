package org.doordash.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * this class consists reusable method to handle property file
 * @author admin
 *
 */
public class FileUtility {
	/*Properties properties;
	/**
	 * this method is used to fetch the data from Property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	/*public  String getDataFromPropertyFile(String key) {
		String value=properties.getProperty(key).trim();
		return value;
	}*/
	/**this method is used to intialize the property file
	 * 
	 * @param propertyFilePath
	 * @throws IOException
	 */
	/*public void initializePropertyFile(String propertyFilePath) throws IOException {
		FileInputStream fis = new FileInputStream(propertyFilePath);
		properties=new Properties();
		properties.load(fis);
	}
}*/

	
	public  String getDataFromPropertyFile(String propertyFilePath,String key) {
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(propertyFilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties properties=new Properties();
		try {
			properties.load(fis);
		}catch(IOException e) {
			e.printStackTrace();
		}
		String value = properties.getProperty(key).trim();
		return value;
	}}
	
	//public void intializePropertyFile(String  {
		
	
	

