package TestNG;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.Autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.Autodesk.ObjectRepository.HomePage;
import com.crm.Autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.Autodesk.ObjectRepository.OrganizationsPage;
import com.crm.Autodesk.genericutility.BaseClass;

public class CreateOrgTest extends BaseClass
{
	@Test
	public void createOrgTest () throws Throwable {
		
		SoftAssert sa = new SoftAssert();
		
		// get random number
		int ranDomNum = jLib.getRanDomNumber();
		
		// read test data from excel 
		String orgName = eLib.getDataFromExcel("Sheet1", 1 , 1) + ranDomNum;
				
		// navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationsLink();
		//sa.assertTrue(false);
		
		// click on create organization button 
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickCreateOrganizationLookImg();
		
		// enter all the details & create new organization
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createOrg(orgName);
				
		// Verify organization name in header of the msg
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String ActMsg = oip.getOrgInfo();
		
		if(ActMsg.contains(orgName)) {
			System.out.println(ActMsg);
			System.out.println(" Organization created Succesfully ");
		}else {
			System.out.println(" Failed ");
		}
	}
	@Test
	public void demo()
	{
		System.out.println("demo");
	}
}
