package com.crm.Autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.Autodesk.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility{  // Step 1 : create a separate class for WebPage  (Home)
	
	// Step 2 : Declaration
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationsLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportuitiesLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productsLnk;
	
	@FindBy(linkText = "Documents")
	private WebElement documentsLnk;
	
	@FindBy(linkText = "Email")
	private WebElement emailLnk;
	
	@FindBy(linkText = "Trouble Tickets")
	private WebElement troubleTicketsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLnk;
	
	// Step 3 : Intialization
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	

	// Step 4 : Utilization
	
	public WebElement getOrganizationsLnk() {
		return organizationsLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getOpportuitiesLnk() {
		return opportuitiesLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getDocumentsLnk() {
		return documentsLnk;
	}

	public WebElement getEmailLnk() {
		return emailLnk;
	}

	public WebElement getTroubleTicketsLnk() {
		return troubleTicketsLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	
	// Business Library to click on Organizations
	
	public void clickOnOrganizationsLink()
	{
		organizationsLnk.click();
	}
	
	// Business Library to click on Contacts
	
	public void clickOnContactsLink()
	{
		contactsLnk.click();
	}
	
	// Business Library for Logout
	
	public void logout (WebDriver driver) 
	{
		mouseOverOnElement(driver, administratorImg);
		signOutLnk.click();
	}
}
