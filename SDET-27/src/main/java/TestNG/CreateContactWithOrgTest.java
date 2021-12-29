package TestNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Autodesk.ObjectRepository.ContactInfoPage;
import com.crm.Autodesk.ObjectRepository.CreateContactPage;
import com.crm.Autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.Autodesk.ObjectRepository.HomePage;
import com.crm.Autodesk.ObjectRepository.OrganizationsPage;
import com.crm.Autodesk.genericutility.BaseClass;

public class CreateContactWithOrgTest extends BaseClass{
	@Test
	public void createContactWithOrgTest() throws Throwable{
		
		// get random num
		int ranDomNum = jLib.getRanDomNumber();
		
		// read data from Excel File
		String orgName = eLib.getDataFromExcel("Sheet1", 0, 1) + ranDomNum;
		String lastName = eLib.getDataFromExcel("Sheet1", 1, 1) + ranDomNum;
		
		// navigate to Org
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();
		
		
		// Click on Org
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickCreateOrganizationLookImg();
		
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createOrg(orgName);
		
		// wait for element to be clickable
		wLib.waitForElementtoBeClickAble(driver, driver.findElement(By.className("dvHeaderText")));
		
		
		// navigate to contact
		hp.clickOnContactsLink();
		
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.createContactWithOrgName(driver, lastName, orgName);
		
		//Verification
		ContactInfoPage cip = new ContactInfoPage(driver);
		String res = cip.getContactInfo();
		if(res.contains(lastName)) {
			System.out.println(res + " added successfully ");
		} else {
			System.out.println(" Fail to Add ");
		}
	}
}
