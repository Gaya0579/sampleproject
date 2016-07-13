package Utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Guru99.ExecutePrg;

public class Loginpage {
	
	 WebDriver driver;
	 
	 @FindBy(name="uid")
	 WebElement username;
	 
	 @FindBy(name="password")
	WebElement password;
	 
	 @FindBy(name="btnLogin")
		WebElement login; 
	 
	 @FindBy(linkText="Log out")
		WebElement logout;
	
	public Loginpage(WebDriver driver){

	     this.driver = driver;
	     PageFactory.initElements(driver, this);

	 }
	
	public void login(){

		 login.click();

	     }
	 public void logout(){

		 logout.click();

	     }
	 public void setName(String strName){
		 username.clear();
//or.getProperty(arg0)
		username.sendKeys(strName);

	     }
	 public void setPwd(String strPwd){
              password.clear();
			password.sendKeys(strPwd);

		     }
	 public boolean verifyTitle(String expected)
		{
			return driver.getTitle().equals(expected);
		}
public void loginNext(String strName,String strPwd){

	this.logout();
	
	this.setName(strName);
	this.setPwd(strPwd);
	
	this.login();
	
}
	
}
