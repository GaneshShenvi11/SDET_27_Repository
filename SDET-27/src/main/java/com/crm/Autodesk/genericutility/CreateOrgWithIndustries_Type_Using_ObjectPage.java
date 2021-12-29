package com.crm.Autodesk.genericutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.Autodesk.ObjectRepository.CreateContactPage;
import com.crm.Autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.Autodesk.ObjectRepository.HomePage;
import com.crm.Autodesk.ObjectRepository.LoginPage;
import com.crm.Autodesk.ObjectRepository.OrganizationsPage;


public class CreateOrgWithIndustries_Type_Using_ObjectPage {
	
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
			WebDriverUtility wLib = new WebDriverUtility();
			
			
			// WebDriverUtility Method
			wLib.waitForPageToLoad(driver);
			
			driver.manage().window().maximize();
					
			driver.get(URL);
			
			LoginPage lp = new LoginPage(driver);
			lp.login(USERNAME, PASSWORD);
			
			HomePage hp = new HomePage(driver);
			
			
			
			hp.clickOnOrganizationsLink();
						
			OrganizationsPage op = new OrganizationsPage(driver);
			op.clickCreateOrganizationLookImg();
			
			CreateOrganizationPage cop = new CreateOrganizationPage(driver);
			cop.createOrgWithIndustry(orgName, orgIndustry, orgType);
			
			String industry = driver.findElement(By.id("dtlview_Industry")).getText();
			String industryType = driver.findElement(By.id("dtlview_Type")).getText();
						
			if(industry.equals(orgIndustry)&& industryType.equals(orgType))
			{
				System.out.println("PASS Data Verified as "+ industry+" & " + industryType );
			}else {
				System.out.println("FAIL Data Not Verified as "+ industry+" & " + industryType );
			}
			
			wLib.waitForElementtoBeClickAble(driver, driver.findElement(By.className("dvHeaderText")));
						
			hp.clickOnContactsLink();
			CreateContactPage ccp = new CreateContactPage (driver);
			ccp.createContactWithOrgName(driver, lastName, orgName);

			// WebDriverUtility Method
		    wLib.mouseOverOnElement(driver, driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
		    
		    driver.findElement(By.linkText("Sign Out")).click();
		   
		    Thread.sleep(2000);
			driver.quit();
			}
		}
