package HealthInsurance;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage{
	 WebDriver driver;
	 
	 @FindBy(xpath=".//*[@id='userForm']/fieldset[3]/div/a[1]")
	 WebElement Register;
	 
 @FindBy(id="fname")
 WebElement firstname;
 
 @FindBy(id="lname")
WebElement lastname;
 
 @FindBy(id="month")
 WebElement month;
 
 @FindBy(id="day")
 WebElement day;
 
 @FindBy(id="year")
 WebElement year;
 
 @FindBy(id="address")
 WebElement address;
 
 @FindBy(id="address2")
 WebElement address2;
 @FindBy(id="city")
 WebElement city;
 
 @FindBy(id="state")
 WebElement state;
 
 @FindBy(id="zip" )
 WebElement zip;
 
 @FindBy(name="_eventId_next")
 WebElement next;
 
 
 public RegisterPage(WebDriver driver){

     this.driver = driver;
     PageFactory.initElements(driver, this);

 }
 public void register(){

	 Register.click();

     }
 public void setFName(String strFName){

	 firstname.sendKeys(strFName);

     }


 public void setLName(String strLName){

	 lastname.sendKeys(strLName);

     }
 public void setmonth(String strmonth){

	 month.sendKeys(strmonth);

     }
 public void setDay(String strDay){

	day.sendKeys(strDay);

     }
 
 public void setYear(String strYear){

	year.sendKeys(strYear);

     }
 
 public void setAddress(String strAddress){

	 address.sendKeys(strAddress);

     }
 public void setAddress2(String strAddress2){

	 address2.sendKeys(strAddress2);

     }
 public void setCity(String strCity){

	 city.sendKeys(strCity);

     }
 public void setState(String strState){

	state.sendKeys(strState);

     }
 public void setZip(String strZip){

	 zip.sendKeys(strZip);

     }
 public void setNext()
 {
	 next.click();
 }
 public void RegisterNext(String strFName,String strLName,String strmonth,String strDay,String strYear,String strAddress,String strAddress2,String strCity,String strState,String strZip) 
 {
	 this.register();
	 this.setFName(strFName);
	 this.setLName(strLName);
	 this.setmonth(strmonth);
	 this.setDay(strDay);
	 this.setYear(strYear);
	 this.setAddress(strAddress);
	 
	 this.setAddress2(strAddress2);
	 this.setCity(strCity);
	 this.setState(strState);
	 this.setZip(strZip);
	 this.setNext();
 }
 
}
