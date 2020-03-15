package com.buildium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buildium.base.BaseLibrary;

public class LoginPage extends BaseLibrary{
	
		@FindBy(id="emailAddressInput")
		WebElement username;
		
		@FindBy(id="passwordInput")
		WebElement password;
		
		@FindBy(xpath="//button[contains(text(),'Sign in')]")
		WebElement signInBtn;
		
		//Initializing the Page Objects:
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		
		public HomePage login(String un, String pwd) throws Exception{
			username.sendKeys(un);
			password.sendKeys(pwd);
			click(signInBtn);
			    	
			return new HomePage();
		}
}
