package com.crm.Autodesk.genericutility;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrgTestPropertiesFile {

	public static void main(String[] args) throws Throwable {
				
		// FileUility Method
		FileUtility flib= new FileUtility();
		String URL = flib.getPropertyKeyValue ("url");
		String USERNAME = flib.getPropertyKeyValue ("username");
		String PASSWORD = flib.getPropertyKeyValue ("password");
			
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

	}
}
