package com.crm.Autodesk.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.Autodesk.genericutility.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility {
		
	// declaration
	@FindBy(xpath= "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createContactLookUpImg;
	
	@FindBy(name = "lastname")
	private WebElement contactLastNameEdt ;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement OrgNameLookUpImg ;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn ;
	
	@FindBy(name = "search_text")
	private WebElement orgSearchEdt;
	
	@FindBy(name = "search")
	private WebElement orgSearch;
	
		
	// initialization 
	
	public CreateContactPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	// utilization
	public WebElement getOrgNameLookUpImg() {
		return OrgNameLookUpImg;
	}
	
	public WebElement getContactLastNameEdt() {
		return contactLastNameEdt;
	}

	public WebElement getCreateContactLookUpImg() {
		return createContactLookUpImg;
	}

	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
	public WebElement getOrgSearchEdt() {
		return orgSearchEdt;
	}

	// Business Library
	public void createContact(String lastName)
	{
		createContactLookUpImg.click();
		contactLastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	
	public void createContactWithOrgName(WebDriver driver , String lastName , String orgName  ) {
		createContactLookUpImg.click();
		contactLastNameEdt.sendKeys(lastName);
		OrgNameLookUpImg.click();
		switchToWindow(driver, "Accounts");
		orgSearchEdt.sendKeys(orgName);
		orgSearch.click();
		driver.findElement(By.linkText(orgName)).click();;
		switchToWindow(driver, "Contacts");
		saveBtn.click();
		
	}
	
	

}
