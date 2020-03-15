package com.buildium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buildium.base.BaseLibrary;

public class HomePage extends BaseLibrary{
	
	RentalsPage rentalsPage;
	CommunicationsPage communicationsPage;
	
	
	@FindBy(xpath="(//span[contains(text(),'Rentals')])[1]")
	public WebElement rentalsLnk;
	
	@FindBy(id="lnk_Properties")
	public WebElement propertiesLnk;
	
	@FindBy(xpath="//span[contains(text(),'Communication')]")
	public WebElement communicationsLnk;
	
	@FindBy(id="lnk_Mailings")
	public WebElement mailingsLnk;
	
	@FindBy(xpath="//li[@id='lnkReports']/a[text()='Reports']")
	public WebElement reportLnk;
	
	//Initializing the Page Objects:
	public HomePage(){
	 PageFactory.initElements(driver, this);
	}
	
	public RentalsPage clickOnPropertiesLnk() throws Exception{
		click(propertiesLnk);
		return new RentalsPage();
	}
	
	public CommunicationsPage clickMailingsLnk() throws Exception {
		click(mailingsLnk);
		return new CommunicationsPage();
		
	}
	
	public ReportsPage clickReportLnk() throws Exception {
		click(reportLnk);
		return new ReportsPage();
		
	}

}
