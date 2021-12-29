package com.crm.Autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOpportunitiesPage {
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOpportunityLookUpImg;
	
		
	@FindBy(name="potentialname")
	private WebElement opportunityNameEdt ; 
	
	@FindBy( xpath= "//input[@name='related_to_display']/following-sibling::img" )
	private WebElement relatedToLookUpImg ; 
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn ;
	
// Step - 3
	
	public CreateOpportunitiesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
// Step - 4
	
	public WebElement getCreateOpportunityLookUpImg() {
		return createOpportunityLookUpImg;
	}
	public WebElement getOpportunityNameEdt() {
		return opportunityNameEdt;
	}
	public WebElement getRelatedToLookUpImg() {
		return relatedToLookUpImg;
	}
	
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	// Business Library
	public void createOpportunity(String opportunityName)
	{
		opportunityNameEdt.sendKeys(opportunityName);
		
		saveBtn.click();
	}

}
