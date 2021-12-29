package TestNG;

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

import com.crm.Autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.Autodesk.ObjectRepository.HomePage;
import com.crm.Autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.Autodesk.ObjectRepository.OrganizationsPage;
import com.crm.Autodesk.genericutility.BaseClass;

public class CreateOrgWithIndustries_Type extends BaseClass{
	
	public void createOrgWithIndustryandTypeScriptTest() throws Throwable {
		

	
			int ranDomNum = jLib.getRanDomNumber();
					
			
			String orgName = eLib.getDataFromExcel("Sheet1", 0, 1);
			String  orgIndustry = eLib.getDataFromExcel("Sheet1", 0, 3);
			String  orgType = eLib.getDataFromExcel("Sheet1", 0, 4);		
			
						
			HomePage hp = new HomePage(driver);
			hp.clickOnOrganizationsLink();
			
			OrganizationsPage op = new OrganizationsPage(driver);
			op.clickCreateOrganizationLookImg();
			
			CreateOrganizationPage cop = new CreateOrganizationPage(driver);
			cop.createOrgWithIndustry(orgName, orgIndustry, orgType);
			
			OrganizationInfoPage oip = new OrganizationInfoPage(driver) ;
			String Actmsg = oip.getOrgInfo();
			
			
			
			
			
			
			
			
				
 }
}
