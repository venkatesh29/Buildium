package com.buildium.pages;


import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.buildium.base.BaseLibrary;

public class RentalsPage extends BaseLibrary{
	
	@FindBy(xpath="//a[contains(text(),'Add property')]")
	public WebElement addPropertyBtn;
	
	@FindBy(id="propertyType_innerSelectizeInput")
	public WebElement propertyTypeDrpdwnTxtBox;
	
	@FindBy(xpath="//input[contains(@ng-model,'vm.address.Line')]")
	public List<WebElement> streetAddressTxtBoxes;
	
	@FindBy(id="city_vm.address")
	public WebElement citysTxtBox;
	
	@FindBy(id="zip_vm.address")
	public WebElement zipTxtBox;  

	@FindBy(id="state_vm.address-dropdown")
	public WebElement stateDrpdwndiv;
	
	@FindBy(xpath="//ul[@id='state_vm.address-dropdown-menu']/li/span")
	public List<WebElement> stateDrpdwn;
		
	@FindBy(id="country_vm.address-dropdown")
	public WebElement countryDrpdwndiv;
	
	@FindBy(xpath="//ul[@id='country_vm.address-dropdown-menu']/li/span")
	public List<WebElement> countryDrpdwn;
	
	@FindBy(xpath="//div[contains(@class,'not-full')]/input[contains(@id,'rentalOwner-')]")
	public WebElement rentalOwnerDrpdwnTxtBox;
		
	@FindBy(id="addAnotherRentalOwner")
	public WebElement rentalAnotherOwnerLnk;
	
	@FindBy(id="vm.rentalOwner-FirstName")
	public WebElement rentalOwnerFirstNameTxtBox;
	
	@FindBy(id="vm.rentalOwner-LastName")
	public WebElement rentalOwnerLastNameTxtBox;
	
	@FindBy(id="RentalOwnerAddEditSaveButton")
	public WebElement createOwnerBtn;
	
//	@FindBy(id="vm.rentalOwner-LegalName")
//	public WebElement rentalOwnercmpNameTxtBox;
	
	@FindBy(xpath="//button[@id='addAnotherUnit']")
	public WebElement addAnotherUnitBtn;
	
	@FindBy(id="addLeaseDetails")
	public List<WebElement> addLeaseDetailsBtn;
	
	
	@FindBy(id="operatingAccount_innerSelectizeInput")
	public WebElement operatingAccountTxtbox;
	
	@FindBy(xpath="(//button[@class='ui-datepicker-trigger'])[1]")
	public WebElement startDate;
	
	@FindBy(xpath="(//button[@class='ui-datepicker-trigger'])[2]")
	public WebElement endDate;
	
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	public WebElement calendarMonthDrpdwn;
	
	@FindBy(xpath="//select[@class='ui-datepicker-year']")
	public WebElement calendarYearDrpdwn;
	
	@FindBy(xpath="//td/a[@class='ui-state-default']")
	public List<WebElement> calendartdDate;
	
	@FindBy(xpath="(//div[@ng-repeat='text in vm.headerTitle']//following::div[@ng-click='vm.edit()'])[1]")
	public WebElement addedPropertyName;
	
	@FindBy(id="saveLeaseDetails")
	public WebElement createLeaseBtn;
	
	@FindBy(xpath="//span[contains(text(),'Add tenant or cosigner')]//parent::a")
	public WebElement addtenantBtn;
	
	@FindBy(id="firstName")
	public WebElement tenantFirstNameTxtBox;
	
	@FindBy(id="lastName")
	public WebElement tenantLastNameTxtBox;
	
	@FindBy(xpath="//button[contains(text(),'Add tenant')]")
	public WebElement addTenantBtn;
	
	@FindBy(xpath="//a[contains(text(),'Lease added ')]")
	public List<WebElement> leaseaddedLnks;
	
	@FindBy(id="addProperty")
	public WebElement createPropertyBtn;
	
	@FindBy(xpath="(//div[@class='quick-menu-icon']//preceding::a)[98]")
	public WebElement tripleDotLnk;
	
	@FindBy(xpath="//*[@id='btn-propertySummary-0']")
	public WebElement propertySummaryLnk;
	
	@FindBy(xpath="(//*[contains(text(),'Files')])[2]/following::a[1]")
	public WebElement addFileLnk;
	
	@FindBy(xpath="//*[@id='lnkFileUpload']")
	public WebElement fileUploadLnk;
	
	@FindBy(xpath="(//button[@id='btnSave'])[2]")
	public WebElement saveBtn;
	
	//Initializing the Page Objects:
	public RentalsPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void typeAddress(String Address,String randomnumber) throws Exception {

		int i=0;
		
		for(WebElement e :streetAddressTxtBoxes) {
			
			String[]Addresslines=Address.split(",");
			
			if(!Addresslines[i].equalsIgnoreCase("")) {
				if(i==0) {
					e.sendKeys(Addresslines[i]+randomnumber);
				
				}else {
					e.sendKeys(Addresslines[i]);
				}
			}
			
			i++;
		}			
		
	} 
	
	public void typeCity(String valuetoenter) {
		citysTxtBox.sendKeys(valuetoenter);
	}
	
	public void typeZip(String valuetoenter) {
		zipTxtBox.sendKeys(valuetoenter);
	}
	
	
	public void selectPropertyType(String valuetoSelect) throws Exception {
		
		waitForElement(BaseLibrary.driver, propertyTypeDrpdwnTxtBox, 60);
		propertyTypeDrpdwnTxtBox.sendKeys(valuetoSelect);
		propertyTypeDrpdwnTxtBox.sendKeys(Keys.ENTER);
			
	}
	
	
	public void selectState(String valuetoSelect) throws InterruptedException {
		
		stateDrpdwndiv.click();
				
		for(WebElement e :stateDrpdwn) {
			if(e.getText().equalsIgnoreCase(valuetoSelect)) {
				e.click();
				break;
			}
		}	
		
	}
	
	public void selectCountry(String valuetoSelect) throws InterruptedException {
		
		countryDrpdwndiv.click();
				
		for(WebElement e :countryDrpdwn) {

			if(e.getText().equalsIgnoreCase(valuetoSelect)) {
				e.click();
				break;
			}
		}	
		
	}
	
	public void selectRentalOwner(String rentalownerfn,String rentalownerln) throws Exception {
		
		waitForElement(BaseLibrary.driver, rentalOwnerDrpdwnTxtBox, 60);
		rentalOwnerDrpdwnTxtBox.sendKeys(rentalownerfn+" "+rentalownerln);
		rentalOwnerDrpdwnTxtBox.sendKeys(Keys.ENTER);
			
	}
	
	public void addRentalOwner(String fname,String lname) throws Exception {	
		rentalAnotherOwnerLnk.click();
		
		waitForElement(BaseLibrary.driver, rentalOwnerDrpdwnTxtBox, 60);
		rentalOwnerDrpdwnTxtBox.sendKeys("Add rental owner");
		rentalOwnerDrpdwnTxtBox.sendKeys(Keys.ENTER);
			
		rentalOwnerFirstNameTxtBox.sendKeys(fname);
		rentalOwnerLastNameTxtBox.sendKeys(lname);
		createOwnerBtn.click();
			
	}
	
	public void addPrimaryBankAccount(String bnkAccntName) throws Exception {
		waitForElement(BaseLibrary.driver, operatingAccountTxtbox, 60);
		operatingAccountTxtbox.sendKeys(bnkAccntName);
		operatingAccountTxtbox.sendKeys(Keys.ENTER);
	}
	
	public void addAnotherUnit() throws Exception {
		waitForElement(BaseLibrary.driver, addAnotherUnitBtn, 60);
		addAnotherUnitBtn.click();
	}
	
	public void addLease(int unitNumber) {
		addLeaseDetailsBtn.get(unitNumber-1).click();
	}
	
	public void selectStartDate(String dateToSelect) throws Exception {
			
		waitForElement(BaseLibrary.driver, startDate, 60);
		startDate.click();
		
		String[] dateArray=dateToSelect.split("/");
		
		String calendarMonth=dateArray[0];
		String calendarDate=dateArray[1];
		String calendarYear=dateArray[2];		
		
		HashMap<String,String> map = new HashMap<String,String>(); 
		
		map.put("01","Jan"); 
        map.put("02","Feb"); 
        map.put("03", "Mar"); 
        map.put("04", "Apr"); 
        map.put("05", "May"); 
        map.put("06", "Jun");
        map.put("07", "Jul"); 
        map.put("08", "Aug"); 
        map.put("09", "Sep");
        map.put("10", "Oct"); 
        map.put("11", "Nov"); 
        map.put("12", "Dec");
        
		selectDropDown(calendarMonthDrpdwn,map.get(calendarMonth));
		selectDropDown(calendarYearDrpdwn,calendarYear);
		
		for(WebElement tdDateElement:calendartdDate) {
			
			if(tdDateElement.getText().equalsIgnoreCase(calendarDate)) {
				tdDateElement.click();
				break;	
			}
			
		}
		
	}
	
	public void addTenant(String fname,String lname) throws Exception {	
		addtenantBtn.click();
	
		waitForElement(BaseLibrary.driver, tenantFirstNameTxtBox, 60);
//		rentalOwnerDrpdwnTxtBox.sendKeys("Add rental owner");
//		rentalOwnerDrpdwnTxtBox.sendKeys(Keys.ENTER);
			
		tenantFirstNameTxtBox.sendKeys(fname);
		tenantLastNameTxtBox.sendKeys(lname);
		addTenantBtn.click();
			
	}
		
	public PropertyDetailsPage clickCreatePropertyBtn() throws Exception{
		click(createPropertyBtn);	    	
		return new PropertyDetailsPage();
	}
			
}
	
	
	
	
	


