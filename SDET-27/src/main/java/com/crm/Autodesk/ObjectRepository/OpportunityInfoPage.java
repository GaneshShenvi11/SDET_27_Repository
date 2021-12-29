package com.crm.Autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityInfoPage {
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement opportunityHeaderText ;
	
	public OpportunityInfoPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOpportunityHeaderText() {
		return opportunityHeaderText;
	}

	// Business Library
	public String getOpportunityInfo()
	{
		return (opportunityHeaderText.getText());
	}

}
