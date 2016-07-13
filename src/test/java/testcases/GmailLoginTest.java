package testcases;




import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import utilities.TestUtil;

public class GmailLoginTest extends TestBase{
	
	
	@Test(dataProvider="getData")
	public void Login(String useremail,String password){
		 
		
		driver.get("http://www.gmail.com/");
		driver.findElement(By.xpath(OR.getProperty("useremail"))).sendKeys(useremail);
		driver.findElement(By.xpath(OR.getProperty("nextbutton"))).click();
		driver.findElement(By.xpath(OR.getProperty("password"))).sendKeys(password);
		driver.findElement(By.xpath(OR.getProperty("signincheckbox"))).click();
		driver.findElement(By.xpath(OR.getProperty("signinbutton"))).click();
		driver.findElement(By.xpath(OR.getProperty("logoutIcon"))).click();
		
		driver.findElement(By.xpath(OR.getProperty("signoutbutton"))).click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	@DataProvider
	public static Object[][] getData(){
			
	return TestUtil.getData("AddCustomerTest");
		
		
		
	}
	@BeforeClass
	  public void beforeClass() {
		  
		  System.out.println("Before Login Class");
	  }

	  @AfterClass
	  public void afterClass() {
		  
		  System.out.println("After Login Class");
	  }

	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("Before Login Test");
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("After Login Test");
	  }

		

}
