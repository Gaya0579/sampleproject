
package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameterization {
	
	
	public static ExcelReader excel;
	public static WebDriver driver;
	


	@BeforeClass
	public void  launchBrowser()
	{
		
			driver = new FirefoxDriver();
		
	}
	
	@AfterTest
	public void quitBrowser(){
		
		driver.quit();
		
	}
	
	@Test(dataProvider="getData")
	public void testData(String username,String password){
		
		driver.get("http://www.gmail.com/");
		driver.findElement(By.id("Email")).sendKeys(username);
	}
	
	
	@DataProvider
	public static Object[][] getData(){
		
		
		
		if(excel==null){
			
			excel=new ExcelReader(System.getProperty("user.dir")+"/Flight/src/test/resources/testdata.xlsx");
		}
		
		
		String sheetName = "AddCustomerTest";
		
		int rows = excel.getRowCount(sheetName);
		System.out.println("Total rows are : "+rows);
		int cols = excel.getColumnCount(sheetName);
		System.out.println("Total cols are : "+cols);
		Object[][] data = new Object[rows-1][cols];
		
	
		

		for(int rowNum = 2 ; rowNum <= rows ; rowNum++){ //2
			
			for(int colNum=0 ; colNum< cols; colNum++){
				data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum); //-2
			}
		}
		
		
	return data;
		
		
		
		
		
	}

}

