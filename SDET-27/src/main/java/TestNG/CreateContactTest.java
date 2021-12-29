package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.Autodesk.ObjectRepository.ContactInfoPage;
import com.crm.Autodesk.ObjectRepository.CreateContactPage;
import com.crm.Autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.Autodesk.ObjectRepository.HomePage;
import com.crm.Autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.Autodesk.ObjectRepository.OrganizationsPage;
import com.crm.Autodesk.genericutility.BaseClass;

public class CreateContactTest  extends BaseClass{
	
	@Test
	public void createContactTest () throws Throwable {
		
		// get random number
		int ranDomNum = jLib.getRanDomNumber();
		
		// read test data from excel 
		String lastName = eLib.getDataFromExcel("Sheet1", 1 , 2) + ranDomNum;
		
		// navigate to contacts module
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();
		
		// click on create contacts button 
		CreateContactPage ccp = new CreateContactPage (driver);
		ccp.createContact(lastName);
				
		// Verify contact name in header of the msg
		ContactInfoPage  cip = new ContactInfoPage(driver);
		String ActMsg = cip.getContactInfo();
		
		Assert.assertTrue(ActMsg.contains(lastName));
		 System.out.println(" Contact Created Succesfully");

	}
}
