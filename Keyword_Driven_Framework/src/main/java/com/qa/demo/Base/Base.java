package com.qa.demo.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {


	public WebDriver driver;
	public Properties prop;
	
	public WebDriver init_Driver(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		return driver;
	}
	
	public Properties init_Property()
	{
		prop=new Properties();
		FileInputStream fis=null;
		try {
			fis=new FileInputStream("C:\\Users\\ASUS\\Desktop\\my java\\java\\Keyword_Driven_Framework\\src\\main\\java\\com\\qa\\demo\\properties\\property.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
	}
}
