package com.crm.Autodesk.genericutility;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class CreateOrgWithIndustries_Type_Using_GenericsMethods {
	
	public static void main(String[] args) throws Throwable {
		
		    // FileUility Method
			FileUtility flib= new FileUtility();
			String URL = flib.getPropertyKeyValue ("url");
			String USERNAME = flib.getPropertyKeyValue ("username");
			String PASSWORD = flib.getPropertyKeyValue ("password");
			String BROWSER = flib.getPropertyKeyValue ("browser");
			
			// ExcelUility Method
			ExcelUtility  elib = new ExcelUtility ();
			String orgName = elib.getDataFromExcel("Sheet1", 0, 1);
			String lastName = elib.getDataFromExcel("Sheet1", 1, 1);
			String orgIndustry = elib.getDataFromExcel("Sheet1", 2, 1);
			String orgType = elib.getDataFromExcel("Sheet1", 3, 1);
		
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
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
					
			driver.get(URL);
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys(orgName);
			
			
			WebDriverUtility wLib = new WebDriverUtility();
			// WebDriverUtility Method
			wLib.select(driver.findElement(By.name("industry")), orgIndustry);
			// WebDriverUtility Method
			wLib.select(driver.findElement(By.name("accounttype")), orgType);
									
						
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

			String industry = driver.findElement(By.id("dtlview_Industry")).getText();
			String industryType = driver.findElement(By.id("dtlview_Type")).getText();
			
			
			
			if(industry.equals(orgIndustry)&& industryType.equals(orgType))
			{
				System.out.println("PASS Data Verified as "+ industry+" & " + industryType );
			}else {
				System.out.println("FAIL Data Not Verified as "+ industry+" & " + industryType );
			}
			
			// WebDriverUtility Method
			wLib.waitForElementtoBeClickAble(driver, driver.findElement(By.className("dvHeaderText")));
						
			
			driver.findElement(By.linkText("Contacts")).click();
			driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		    driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
			
		    // WebDriverUtility Method
		    wLib.switchToWindow(driver, "Accounts");
		    
			driver.findElement(By.name("search_text")).sendKeys(orgName, Keys.ENTER);
	    
		    String companyName = driver.findElement(By.partialLinkText(orgName)).getText(); 
		    driver.findElement(By.partialLinkText(orgName)).click();
		    System.out.println(companyName);
		    
		    // WebDriverUtility Method
		    wLib.switchToWindow(driver, "Contacts");     
		    		    
		    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		    
		    // WebDriverUtility Method
		    wLib.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		    
		    driver.findElement(By.linkText("Sign Out")).click();
			}
		}
