package com.driverFactory;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.buildium.base.BaseLibrary;
import com.buildium.pages.HomePage;
import com.buildium.pages.LoginPage;
import com.buildium.utilities.PropertyFileUtil;



public class LoginTest extends BaseLibrary{
	
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() throws Exception{
		startBrowser();
		openApplication();
		loginPage = new LoginPage();		
	}
	
	@Test()
	public void loginTest() throws Exception{
		homePage = loginPage.login(PropertyFileUtil.getValueForKey("UserName"), PropertyFileUtil.getValueForKey("Password"));	
	}
	
	@AfterMethod
	public void tearDown() throws Exception{
		closeDriver();
	}
	
	
}
