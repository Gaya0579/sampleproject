package Utilites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

public class testparameterization {
	
	
	public static excelreader excel;
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
		
		driver.get("http://www.demo.guru99.com/V4");
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	}
	
	
	@DataProvider
	public static Object[][] getData(){
		
		
		
		if(excel==null){
			
			excel=new excelreader(System.getProperty("user.dir")+"/Flight/src/test/resources/executefile/testdata.xlsx");
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

