package InsuranceTestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import HealthInsurance.HomePage;
import HealthInsurance.RegisterPage;

public class MainPage {
	private WebDriver driver;
	HomePage objHomePage;
	RegisterPage objRegisterPage;


	@BeforeTest
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.get("http://www.cigna.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Test
	public void test() {
		
		objHomePage = new HomePage(driver);
		objHomePage.HomePageClick();
		objRegisterPage=new RegisterPage(driver);
		objRegisterPage.RegisterNext("Gaya", "Gobi", "April", "4", "2000", "375 w Burgundy st", "unit 208", "HighlandsRanch", "Co", "80130");

	}
	
	@AfterClass
	public void tearDown() throws Exception {
		driver.quit();
	}

}
