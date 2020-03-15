package com.driverFactory;

import com.buildium.base.BaseLibrary;
import com.buildium.pages.CommunicationsPage;
import com.buildium.pages.HomePage;
import com.buildium.pages.LoginPage;
import com.buildium.utilities.PropertyFileUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddMailingTemplateTest extends BaseLibrary{
	
	LoginPage loginPage;
	HomePage homePage;
	CommunicationsPage communicationsPage;
  
	  @BeforeMethod
	  public void setUp() throws Exception{
			startBrowser();
			openApplication();
			loginPage = new LoginPage();		
	  }
	  
	  @Test()
	  public void multiUnitPropertyTest() throws Exception{
			homePage = loginPage.login(PropertyFileUtil.getValueForKey("UserName"), PropertyFileUtil.getValueForKey("Password"));
			click(homePage.communicationsLnk);
			communicationsPage=homePage.clickMailingsLnk();
			click(communicationsPage.addTemplateBtn);
			Thread.sleep(5000);
			click(communicationsPage.contentTokensBtn);
			Thread.sleep(5000);
			switchtoFrame("cke_124_iframe");
			WebElement e=driver.findElement(By.xpath("//select[@name='ddlText']"));
			selectDropDown(e,"Rental_Owner_Full_Name");
			
			System.out.println(communicationsPage.validateLoginPageTitle());
	  }
	  
		@AfterMethod
		public void tearDown() throws Exception{
			closeDriver();
		}
	  
}
