package Utilites;


import Guru99.ExecutePrg;

public class testutil extends ExecutePrg{

	
	public static Object[][] getData(String sheetName){
		
		
		
		int rows = excel.getRowCount(sheetName);
		System.out.println("Sheet name is:"+sheetName);
		System.out.println("Rows are   " + rows);
	
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][cols];
		
	
		

		for(int rowNum = 2 ; rowNum <= rows ; rowNum++){ //2
			
			for(int colNum=0 ; colNum< cols; colNum++){
				data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum); //-2
			}
		}
		
		
	return data;
		
		
		
		
		
	}
}
	
