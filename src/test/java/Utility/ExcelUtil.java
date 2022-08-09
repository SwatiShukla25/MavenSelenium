package Utility;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	static String projectPath ;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	
	public ExcelUtil (String excelPath , String Sheet)
	{
		try {
		String projectPath = System.getProperty("user.dir");
		workbook =new XSSFWorkbook (excelPath);
		sheet = workbook.getSheet(Sheet);}
	catch(Exception e){
		e.printStackTrace();
		
	}
	}
	public static void main (String[] args)
	{
		getRowCount();
		getColCount();
		//getCellDataString(0, 0);
	//	getCellDataNumber(1,1);
		
	}
	public static int getRowCount()
	{
		int RowCount =0;
		try {
	
		
		RowCount = sheet.getPhysicalNumberOfRows();
		//System.out.println("Num of rows:"+" "+RowCount);
	}
		catch(Exception exp)
		{
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return RowCount;
}
	
	public static int getColCount()
	{
		int ColCount =0;

		try {
	
		
		ColCount = sheet.getRow(0).getPhysicalNumberOfCells();
		//System.out.println("Num of Coloms:"+" "+ColCount);
	}
		catch(Exception exp)
		{
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
return ColCount;
	}
	
	public static String getCellDataString(int rowNum , int colNum)
	{
		String cellData = null;
		try {
			
			cellData =sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println(cellData);
			}
			catch(Exception exp)
			{
				System.out.println(exp.getMessage());
				System.out.println(exp.getCause());
				exp.printStackTrace();
			}
		return cellData;
		
	}
	
	public static double getCellDataNumber(int rowNum , int colNum)
	{
		Double cellDataNum = null ;
		try {
			
			cellDataNum =sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			//System.out.println(cellDataNum);
			}
			catch(Exception exp)
			{
				System.out.println(exp.getMessage());
				System.out.println(exp.getCause());
				exp.printStackTrace();
			}
		return cellDataNum;
		
	}

}
