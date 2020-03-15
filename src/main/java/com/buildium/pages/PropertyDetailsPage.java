package com.buildium.pages;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.buildium.base.BaseLibrary;

public class PropertyDetailsPage extends BaseLibrary{
	
	@FindBy(xpath="//bd-regional-address[@address='vm.property.Address']/ul/li[1]")
	public WebElement propertyName;
	
	@FindBy(xpath="//a[contains(text(),'Units')]")
	public WebElement unitsLnk;
	
	@FindBy(xpath="//bd-regional-address[@address='vm.property.Address']/ul/li")
	public List<WebElement> address;
	
	@FindBy(xpath="//label[contains(text(),'Rental owners')]/following::span[1]/a")
	public List<WebElement> rentalOwnersList;
	
	@FindBy(xpath="//a[@ng-if='vm.hasBankingViewAccess']")
	public WebElement bnkAccntLnk;
	
	
	//Initializing the Page Objects:
	public PropertyDetailsPage() throws InterruptedException{
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}
	
	public void validatePropertyLeaseDetails(int unit,HashMap<String, String> map) throws Exception {
			
			String rentalAddress="";
			String addedpropertyName="";
			String addedowners="";
			String bnkAccnt="";
			
			
			Thread.sleep(10000);
			
			System.out.println("property name is "+driver.findElement(By.xpath("//bd-regional-address[@address='vm.property.Address']/ul/li[1]")).getText());
			address=driver.findElements(By.xpath("//bd-regional-address[@address='vm.property.Address']/ul/li"));
			
			for(WebElement e:address) {
				if(!e.getText().equals("Map it")) {
				rentalAddress=rentalAddress+" "+e.getText();	
				System.out.println("rental address list is"+rentalAddress);
				}
			}
			
			address=driver.findElements(By.xpath("//label[contains(text(),'Rental owners')]/following::span[1]/a"));
			for(WebElement e:rentalOwnersList) {
				System.out.println("owners list lis "+e.getText());
			}
			
			System.out.println("bank account is "+bnkAccntLnk.getText());

		}
	}

