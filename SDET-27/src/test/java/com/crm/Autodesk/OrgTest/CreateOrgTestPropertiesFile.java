package com.crm.Autodesk.OrgTest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrgTestPropertiesFile {

	public static void main(String[] args) throws Throwable {
		
		
		// Step 1 : get the java Represention Object of the Physical File
		FileInputStream fis = new FileInputStream("./data/commondata.properties");
		
		// Step 2 : create an Object to property 
		Properties pobj = new Properties();
		
		pobj.load(fis);
		
		
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		String BROWSER = pobj.getProperty("browser");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

	}
}
