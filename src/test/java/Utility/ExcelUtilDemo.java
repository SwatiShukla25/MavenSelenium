package Utility;

public class ExcelUtilDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String projectPath = System.getProperty("user.dir");
		ExcelUtil excel = new ExcelUtil(projectPath +"/DataExcel/TestDataExcel.xlsx","Sheet1");
		excel.getRowCount();
		excel.getColCount();
		

	}

}
