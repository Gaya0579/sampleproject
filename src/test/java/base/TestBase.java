package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



import utilities.ExcelReader;
//import utilities.monitoringMail;

public class TestBase {
	
	/*
	 * 
	 * Logs
	 * Excel
	 * Properties - OR, Config
	 * Java Mail
	 * WebDriver - browser
	 * 
	 */
	public static WebDriver driver;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static Properties OR = new Properties();
	public static Properties Config = new Properties();
	//public static monitoringMail mail = new monitoringMail();
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"//src//test//resources//properties//testdata.xlsx");
	public static FileInputStream fis;
	public static WebDriverWait wait;
	public static String panNumber;
	
	
	
	@BeforeSuite
	public void setUp(){
		
		
		if(driver==null){
			
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//properties//Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Config.load(fis);
				log.debug("Config file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//properties//OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(Config.getProperty("browser").equals("firefox")){
				
				driver = new FirefoxDriver();
				log.debug("Firefox Launched");
			}else if(Config.getProperty("browser").equals("chrome")){
				
				System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
				driver = new ChromeDriver();
				
			}else if(Config.getProperty("browser").equals("ie")){
				
				System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				
			}
			
			
			//driver.navigate().to(Config.getProperty("testsiteurl"));
			driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
			/*wait = new WebDriverWait(driver, 5L);
			try {
				DbManager.setMysqlDbConnection();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			
		}
		
		
		
		
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
