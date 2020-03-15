package com.driverFactory;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.buildium.base.BaseLibrary;
import com.buildium.pages.HomePage;
import com.buildium.pages.LoginPage;
import com.buildium.pages.RentalsPage;
import com.buildium.utilities.PropertyFileUtil;
import org.testng.Assert;

public class FileUploadTest extends BaseLibrary{
	
	LoginPage loginPage;
	HomePage homePage;
	RentalsPage rentalsPage;
	
	@BeforeMethod
	public void setUp() throws Exception{
		startBrowser();
		openApplication();
		loginPage = new LoginPage();		
	}
	
	@Test
	public void fileUploadTest() throws Exception{
		
		homePage = loginPage.login(PropertyFileUtil.getValueForKey("UserName"), PropertyFileUtil.getValueForKey("Password"));
		click(homePage.rentalsLnk);
		rentalsPage=homePage.clickOnPropertiesLnk();
		Thread.sleep(10000);
		click(rentalsPage.tripleDotLnk);
		click(rentalsPage.propertySummaryLnk);
		click(rentalsPage.addFileLnk);
		click(rentalsPage.fileUploadLnk);
		
		String fileToUpload="Current_Tenants.pdf";
		
		uploadFileWithRobot(fileToUpload);
		
		Thread.sleep(10000);
		click(rentalsPage.saveBtn);
		
		Thread.sleep(10000);
		boolean flag=driver.findElement(By.xpath("(//a[contains(text(),'"+fileToUpload+"')])[1]")).isDisplayed();	
		Assert.assertEquals(true, flag);
		
	}	
}
