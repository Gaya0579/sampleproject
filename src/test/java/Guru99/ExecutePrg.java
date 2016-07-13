package Guru99;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utilites.excelreader;

public class ExecutePrg {
	public static WebDriver driver;
	//Loginpage objlogin;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static Properties or = new Properties();
	public static Properties Conf = new Properties();
	public static excelreader excel = new excelreader(System.getProperty("user.dir")+"//src//test//resources//executefile//testdata.xlsx");
	public static FileInputStream fis;
	public static WebDriverWait wait;
	public static String panNumber;
	
	
	
	
	
	
	
	@BeforeSuite
	  public void beforesuite() {
		  
if(driver==null){
			
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//executefile//Conf.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Conf.load(fis);
				log.debug("Config file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//executefile//or.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				or.load(fis);
				log.debug("OR file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(Conf.getProperty("browser").equals("firefox")){
				
				driver = new FirefoxDriver();
				log.debug("Firefox Launched");
			}else if(Conf.getProperty("browser").equals("chrome")){
				
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver = new ChromeDriver();
				
			}else if(Conf.getProperty("browser").equals("ie")){
				
				System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				
			}
			
			
			
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			
			
		}
		
		
		
		
	}

	public static void screenshot(WebDriver driver,String destFile) throws IOException
	{
		TakesScreenshot tsh =(TakesScreenshot) driver;

		//Taking the screenshot in file format
		File srcLoc = tsh.getScreenshotAs(OutputType.FILE);
		System.out.println("Location " + srcLoc.getAbsolutePath());
		
		//Creating an Object of File Class..
		File destLoc = new File("D:\\"+ destFile);
		
		FileUtils.copyFile(srcLoc, destLoc);
		//String s ="abc";
	}
	
	public static boolean isElementPresent(String xpath){
		
		
		try{
			
			driver.findElement(By.xpath(xpath));
			return true;
			
		}catch(Throwable t){
			
			return false;
		}
		
		
	}
	
	@AfterSuite
	public void tearDown(){
		
		
		driver.quit();
		
	}

}
