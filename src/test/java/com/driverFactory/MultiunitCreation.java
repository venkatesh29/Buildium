package com.driverFactory;


import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.buildium.base.BaseLibrary;
import com.buildium.pages.HomePage;
import com.buildium.pages.LoginPage;
import com.buildium.pages.PropertyDetailsPage;
import com.buildium.pages.RentalsPage;
import com.buildium.utilities.PropertyFileUtil;

public class MultiunitCreation extends BaseLibrary{
	

	LoginPage loginPage;
	HomePage homePage;
	RentalsPage rentalsPage;
	PropertyDetailsPage propertydetailsPage;
	
	@BeforeMethod
	public void setUp() throws Exception{
		startBrowser();
		openApplication();
		loginPage = new LoginPage();		
	}
	
	@Test(dataProvider = "data")
	public void multiUnitPropertyTest(HashMap<String, String> map) throws Exception{
		
		homePage = loginPage.login(PropertyFileUtil.getValueForKey("UserName"), PropertyFileUtil.getValueForKey("Password"));
		click(homePage.rentalsLnk);
		rentalsPage=homePage.clickOnPropertiesLnk();
		click(rentalsPage.addPropertyBtn);
				
		rentalsPage.selectPropertyType("Multi-Family");
		
		rentalsPage.typeAddress(map.get("completeAddress"),map.get("propertyNumber"));
		rentalsPage.typeCity(map.get("city"));
		rentalsPage.typeZip(map.get("zipcode"));
		rentalsPage.selectState(map.get("state"));
		rentalsPage.selectCountry(map.get("country"));
		
		rentalsPage.selectRentalOwner(map.get("rentalOwnerfn"), map.get("rentalOwnerln"));
		rentalsPage.addRentalOwner(map.get("addedOwnerfn"),map.get("addedOwnerln"));	
		
		rentalsPage.addPrimaryBankAccount(map.get("bnkAccount"));
		
//		System.out.println("added property is "+rentalsPage.addedPropertyName.getText());
		
		rentalsPage.addAnotherUnit();
		rentalsPage.addLease(2);
		
		rentalsPage.selectStartDate("04/13/1996");
		
		rentalsPage.addTenant(map.get("tenantfn"),map.get("tenantln"));
		
		click(rentalsPage.createLeaseBtn);
		
		propertydetailsPage=rentalsPage.clickCreatePropertyBtn();
		
		propertydetailsPage.validatePropertyLeaseDetails(2,map);		
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception{
		closeDriver();
	}
	
	@DataProvider(name = "data")
	public Object[][] dataSupplier() {

		HashMap<String, String> map  = new HashMap<String,String>(); 
		
		int propertyNumber=generateRandom();

		map.put("rentalOwnerfn", "ownerfn1"); 
		map.put("propertyNumber", String.valueOf(propertyNumber));
		map.put("rentalOwnerln","ownerln1");
		map.put("addedOwnerfn","ownerfn10"); 
		map.put("addedOwnerln","ownerln10"); 
		map.put("tenantfn","tenantfn1"); 
		map.put("tenantln","tenantln1"); 
		map.put("bnkAccount","hdfc"); 
		map.put("unitName","CPT JOHN DOE"+propertyNumber); 
		map.put("city","APO"); 
		map.put("zipcode","96278"); 
		map.put("state","AE"); 
		map.put("country","United Kingdom"); 
		map.put("completeAddress","CPT JOHN DOE,UNIT 2050 BOX 4190,APO AP 96278"); 
		map.put("startDate","04/13/1996"); 
		
		Object[][] obj = new Object[1][1];
		obj[0][0] = map;		
		return obj;
	  }
	
}
