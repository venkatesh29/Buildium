package com.buildium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buildium.base.BaseLibrary;

public class CommunicationsPage extends BaseLibrary{
	
	@FindBy(xpath="//a[contains(text(),'Add template')]")
	public WebElement addTemplateBtn;
	
	@FindBy(xpath="(//a[@title='Tokens'])[2]")
	public WebElement contentTokensBtn;
	
	@FindBy(xpath="//select[@name='ddlText']")
	public WebElement contentTokensDrpDwn;
	
	//Initializing the Page Objects:
	public CommunicationsPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
}
