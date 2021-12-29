package com.crm.Autodesk.ContactTest;



import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class AutodeskTestContact {
	
	public static void main(String[] args) throws Throwable {
		
		// Step 1 : get the java Represention Object of the Physical File
		FileInputStream fis_1 = new FileInputStream("./data/commondata.properties");
				
		// Step 2 : create an Object to property 
		Properties pobj = new Properties();
				
		pobj.load(fis_1);
					
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		String BROWSER = pobj.getProperty("browser");
		
		FileInputStream fis_2 = new FileInputStream("./data/Exceldata.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis_2);
		Sheet sh = wb.getSheet("Sheet1");
		Row row = sh.getRow(1);
		String lastName = row.getCell(1).getStringCellValue();
		
		WebDriver driver ;
		
		if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}else if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		}else if (BROWSER.equals("ie")) {
			driver = new InternetExplorerDriver();
		}else {
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String Actual = driver.findElement(By.className("dvHeaderText")).getText();
		if (Actual.contains(lastName))
		{
			System.out.println("PASS");	
		}else {
			System.out.println("FAIL");
		}
	
		System.out.println(Actual);
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	}
}