package com.crm.Autodesk.Industries_type;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateOrgWithIndustries_Type {
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
			
			Row row1 = sh.getRow(0);
			String orgName = row1.getCell(1).getStringCellValue();
			
			Row row2 = sh.getRow(1);
			String lastName = row2.getCell(1).getStringCellValue();
			
			Row row3 = sh.getRow(2);
			String orgIndustry = row3.getCell(1).getStringCellValue();
			
			Row row4 = sh.getRow(3);
			String orgType = row4.getCell(1).getStringCellValue();
			
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
			String mainId= driver.getWindowHandle();
		
			driver.get(URL);
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			driver.findElement(By.linkText("Organizations")).click();
					
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			
			driver.findElement(By.name("accountname")).sendKeys(orgName);
			
			WebElement OrgInd = driver.findElement(By.name("industry"));
			Select select1 = new Select(OrgInd);
			select1.selectByVisibleText(orgIndustry);
			
			WebElement OrgIndType = driver.findElement(By.name("accounttype"));
			Select select2 = new Select(OrgIndType);
			select2.selectByVisibleText(orgType);
						
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

			String industry = driver.findElement(By.id("dtlview_Industry")).getText();
			String industryType = driver.findElement(By.id("dtlview_Type")).getText();
			
			if(industry.equals(orgIndustry)&& industryType.equals(orgType))
			{
				System.out.println("PASS Data Verified as "+ industry+" & " + industryType );
			}else {
				System.out.println("FAIL Data Not Verified as "+ industry+" & " + industryType );
			}
			
			WebDriverWait wait = new WebDriverWait(driver , 20);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("dvHeaderText"))));
			//Thread.sleep(2000); 
			driver.findElement(By.linkText("Contacts")).click();
		
			driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
						
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
					
			driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
			
			Set <String> set1 = driver.getWindowHandles();
			Iterator<String> itr1 = set1.iterator();
			
		while(itr1.hasNext()) {
				String currentId = itr1.next();
				driver.switchTo().window(currentId);
				String pageTitle = driver.getTitle();
				if(pageTitle.contains("Accounts"))break;
			}
	    driver.findElement(By.name("search_text")).sendKeys(orgName, Keys.ENTER);
	    
	    String companyName = driver.findElement(By.partialLinkText(orgName)).getText(); 
	    driver.findElement(By.partialLinkText(orgName)).click();
	    //driver.switchTo().window(mainId);
	    System.out.println(companyName);
	    Set <String> set2 = driver.getWindowHandles();
		Iterator<String> itr2 = set2.iterator();
			
		while(itr2.hasNext()) {
			String currentId = itr2.next();
			driver.switchTo().window(currentId);
			String pageTitle = driver.getTitle();
			if(pageTitle.contains("Contacts"))break;
		}
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
				
 }
}
