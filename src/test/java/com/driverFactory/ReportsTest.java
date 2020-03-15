package com.driverFactory;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.buildium.base.BaseLibrary;
import com.buildium.pages.HomePage;
import com.buildium.pages.LoginPage;
import com.buildium.pages.ReportsPage;
import com.buildium.utilities.PropertyFileUtil;


public class ReportsTest extends BaseLibrary{
	LoginPage loginPage;
	HomePage homePage;
	ReportsPage reportsPage;
	
	@BeforeMethod
	public void setUp() throws Exception{
		startBrowser();
		openApplication();
		loginPage = new LoginPage();		
	}
	
	@Test()
	public void reportsTest() throws Exception{
		homePage = loginPage.login(PropertyFileUtil.getValueForKey("UserName"), PropertyFileUtil.getValueForKey("Password"));
		reportsPage=homePage.clickReportLnk();
		click(reportsPage.currentTenantsLnk);
		click(reportsPage.exportBtn);
		click(reportsPage.exportpdfBtn);

		File f = new File("C:\\Users\\"+System.getProperty("user.name")+"\\Downloads"+"\\Current_Tenants.pdf");
		
		Assert.assertEquals(true, f.exists());
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception{
		closeDriver();
	}
}
