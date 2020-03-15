package com.buildium.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.buildium.utilities.PropertyFileUtil;

public class BaseLibrary {

	public static WebDriver driver;
	public String status;
	public int PAGE_LOAD_TIMEOUT=60;
	
	public WebDriver startBrowser() throws Exception{
		
		if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}else if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("ie")){
			System.setProperty("webdriver.InternetExplorer.driver", System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}else{
			System.out.println("invalid browser");
		}
		
		return driver;
	}
	
	public void openApplication() throws Exception{
		
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.get(PropertyFileUtil.getValueForKey("Url"));
			driver.manage().window().maximize();
	}
	
	public static void takeScreenshot() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	public static int generateRandom() {
		// create instance of Random class 
        Random rand = new Random(); 
     // Generate random integers in range 0 to 99999
        int rand_int = rand.nextInt(100000);
		return rand_int; 
	}
	
	public void click(WebElement elementtoClick) throws Exception {
		waitForElement(driver,elementtoClick,60);
		elementtoClick.click();
	}
	
	public void waitForElement(WebDriver driver,WebElement element,int waittime) throws Exception{
	
		try {
			WebDriverWait mywait=new WebDriverWait(driver,waittime);
			mywait.until(ExpectedConditions.visibilityOf(element));
		}catch(Exception e) {
			e.getMessage();
		}
	
	}
	
	public void selectDropDown(WebElement element,String valueToSelect) throws Exception {
		
		waitForElement(driver,element,60);
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		
		Select dropdown = new Select(element); 
		//dropdown.selectByVisibleText(valueToSelect); 
		dropdown.selectByValue(valueToSelect);
			
	}
	
	public void closeDriver() {
		driver.close();
	}
	
	public static void captureData(String datatowrite) throws Exception{
		
		FileWriter fw=new FileWriter(System.getProperty("user.dir")+"\\TestOutput\\testdata.txt");
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(datatowrite);
		bw.flush();
		bw.close();
		
	}
	
	public static void switchtoFrame(String index) {
		try {
		driver.switchTo().frame(index);
		System.out.println("passed");
		}catch(Exception e) {
			System.out.println("failed");
			System.out.println(e.getMessage());
			 final List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
			    for (WebElement iframe : iframes) {
			      System.out.println(iframe.getAttribute("id"));
			    }
		}
		
	}
	
	//File upload by Robot Class
    public void uploadFileWithRobot (String filename) throws InterruptedException {
    	
    	String filePath="C:\\Users\\"+System.getProperty("user.name")+"\\Downloads"+"\\"+filename;
    	
    	Thread.sleep(10000);
    	System.out.println("wait completed");
        StringSelection stringSelection = new StringSelection(filePath);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
 
        Robot robot = null;
 
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
 
        robot.delay(250);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.delay(150);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
	
	
	
}
