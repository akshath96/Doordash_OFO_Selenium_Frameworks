package org.doorDash.home;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertyFile {
public static void main(String[] args) throws IOException {
	FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.Properties");
	Properties property = new Properties();
	property.load(fis);
	String url = property.getProperty("url").trim();
	String browser = property.getProperty("browser").trim();
	
	System.out.println(url);
	System.out.println(browser);
}
}
