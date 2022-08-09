package Utility;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class excelDataProvider {
	
	
	@Test(dataProvider = "testingData")
	public void testing1(String UserName, String Password)
	{
		System.out.println(UserName+ "|"+Password);
	}
	
	@DataProvider(name="testingData")
	public Object[][] getData(){
		
		String projectPath = System.getProperty("user.dir");
		Object data[][]= testData(projectPath+ "/DataExcel/TestDataExcel.xlsx","Sheet1");
		return data;
	}
	public  Object[][] testData(String excelPath,String SheetName)
	{
		ExcelUtil excelName = new ExcelUtil(excelPath ,SheetName );
		int rowCount = excelName.getRowCount();
		int colCount = excelName.getColCount();
		System.out.println("Number of Rows:"+" "+ rowCount);
		System.out.println("Num of Colums:" +" "+colCount);
		
		Object data[][]=  new Object [rowCount-1][colCount];
		
		for(int i =1; i<rowCount; i++)
		{
			for(int j=0;j<colCount;j++)
			{
				String cellData = excelName.getCellDataString(i, j);
				System.out.print(cellData+ " | ");	
				data[i-1][j]=cellData;
			}
			System.out.println(" ");
		}
		return data;
	}
}
