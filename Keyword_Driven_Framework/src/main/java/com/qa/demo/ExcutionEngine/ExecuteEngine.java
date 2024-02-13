package com.qa.demo.ExcutionEngine;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.demo.Base.Base;

public class ExecuteEngine {

	public WebDriver driver;
	public Properties prop;
	public Workbook w;
	public Sheet s;
	public Base b;
	public final String Excel_path="C:\\Users\\ASUS\\Desktop\\my java\\java\\Keyword_Driven_Framework\\src\\main\\java\\com\\qa\\demo\\Excel\\keyword_drivern.xlsx";
	
	public void coreEngine()
	{
		FileInputStream fis=null;	
		try {
			fis=new FileInputStream(Excel_path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			w=WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Sheet s = w.getSheet("sheet2");
		
		int j=0;
		for(int i=0;i<s.getPhysicalNumberOfRows()-1;i++)
		{
			String testStep = s.getRow(i+1).getCell(j).toString().trim();
			String AttributeLocator = s.getRow(i+1).getCell(j+1).toString().trim();
			String AttributeValue = s.getRow(i+1).getCell(j+2).toString().trim();
			String Action = s.getRow(i+1).getCell(j+3).toString().trim();
			String Value = s.getRow(i+1).getCell(j+4).toString().trim();
			
			switch (testStep) {
			case "open browser":
				b=new Base();
				prop=b.init_Property();
				if(Value.isEmpty()||Value.equalsIgnoreCase("NA"))
				{
					b.init_Driver(prop.getProperty("browser"));
				}
				else
				{
					b.init_Driver(Value);
				}
				
				break;
			
			case "lauch the browser":
				if(Value.isEmpty()||Value.equalsIgnoreCase("NA"))
				{
					b.driver.get(prop.getProperty("url"));
				}
				else
				{
					b.driver.get(Value);
				}
			default:
				break;
			}
			
			switch (Action) {
			case "click":
			      b.driver.findElement(By.xpath(AttributeValue)).click();;
				break;

			case "sendKeys":
				b.driver.findElement(By.xpath(AttributeValue)).sendKeys(Value);
				break;
			default:
				break;
			}
		}
	}
}
