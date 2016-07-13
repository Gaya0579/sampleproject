package HealthInsurance;






import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class HomePage {
	 WebDriver driver;
	 @FindBy(linkText="Login to myCigna")
  WebElement LoginCigna;
	
	 
	 public HomePage(WebDriver driver){

	        this.driver = driver;
	        PageFactory.initElements(driver, this);

	    }

	 
	 
	 public void clickLogin(){

         LoginCigna.click();
          String parent = driver.getWindowHandle();
       Set<String> wSet = driver.getWindowHandles();
		for(String child : wSet)
		{
			if(!(child.equals(parent)))
			{
				driver.switchTo().window(child);
				System.out.println(driver.getTitle());
				if(driver.getTitle().equals("Cigna"))
				{
					
			break;
				}
			}

		}
		

	
		
		
  }
 public void HomePageClick(){
	 
	 this.clickLogin();
 }

  
}
