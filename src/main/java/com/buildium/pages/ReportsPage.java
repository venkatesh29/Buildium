package com.buildium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buildium.base.BaseLibrary;

public class ReportsPage extends BaseLibrary{
	
	@FindBy(xpath="//li[@id='lnkReports']/a[text()='Reports']")
	public WebElement reportLnk;
	
	@FindBy(xpath="//a[@id='report-section-report-link-report-id-28']")
	public WebElement currentTenantsLnk;
	
	@FindBy(xpath="//a[@id='exportReportButton']")
	public WebElement exportBtn;
	
	@FindBy(xpath="//a[contains(text(),'PDF - Portrait (.pdf)')]")
	public WebElement exportpdfBtn;
	
	
	//Initializing the Page Objects:
	public ReportsPage(){
		PageFactory.initElements(driver, this);
	}
	
	
}
