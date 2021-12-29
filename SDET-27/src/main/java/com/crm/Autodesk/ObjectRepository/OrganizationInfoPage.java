package com.crm.Autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	@FindBy(xpath = "//span[@class ='dvHeaderText']")
	private WebElement orgHeaderText ;
	
	public OrganizationInfoPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	}
	
	// Business Library
	public String getOrgInfo()
	{
		return (orgHeaderText.getText());
	}
	
	
	

}
