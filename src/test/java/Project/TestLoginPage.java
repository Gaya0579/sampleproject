package Project;


import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import Guru99.ExecutePrg;
import Utilites.testutil;
//import Utilites.Loginpage;


public class TestLoginPage extends ExecutePrg{
	//Loginpage objlogin;
	
	@Test(dataProvider="getData" , priority=2)
	public void Login(String useremail,String password) throws IOException{
		 
		
		driver.get("http://www.demo.guru99.com/V4/");

		
		
		driver.findElement(By.name(or.getProperty("useremail"))).sendKeys(useremail);
	    driver.findElement(By.name(or.getProperty("password"))).sendKeys(password);
	    driver.findElement(By.name(or.getProperty("loginbutton"))).click();
		
	    String actual = driver.getTitle();
		String expected = "Guru99 Bank Manager HomePage";
		Assert.assertEquals(actual, expected);
		System.out.println( actual );
		
String Title=driver.findElement(By.cssSelector(or.getProperty("title"))).getText();
String Titlename="Manger Id : mngr42746";
Assert.assertEquals(Title, Titlename);
System.out.println(Title);
screenshot(driver,"Googlehomepage1.jpg");
screenshot(driver,"Googlehomepage2.jpg");
		
		driver.findElement(By.xpath(or.getProperty("logoutIcon"))).click();
		
		try{
			
			Alert alrt = driver.switchTo().alert();
			String text = alrt.getText();
			System.out.println("Alert MSG:"+text);

			
			alrt.accept();


			System.out.println(driver.getTitle());
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
	}
	
	@DataProvider
	public static Object[][] getData(){
			
	return testutil.getData("AddCustomerTest");
		
		
		
	}
	
	
	  @AfterClass
	  public void afterClass() {
		  
		  //System.out.println("After Login Class");
	  }

	  @BeforeTest
	  public void beforeTest() {
		  //System.out.println("Before Login Test");
	  }

	  @AfterTest
	  public void afterTest() {
		  //System.out.println("After Login Test");
	  }

		

}
