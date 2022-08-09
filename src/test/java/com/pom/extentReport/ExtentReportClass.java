package com.pom.extentReport;
import org.testng.Assert;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportClass {

	
	 ExtentHtmlReporter htmlReporter; 
	  ExtentReports extent;
	  ExtentTest logger;
	 
	  @BeforeTest 
	  public void startReport()
	  {
	  String path=System.getProperty("user.dir") + "/test-output/ExtentReport.html";
	  System.out.println("Path is::"+path); 
	  htmlReporter = new ExtentHtmlReporter(path); 
	  extent = new ExtentReports();
	  extent.attachReporter(htmlReporter); 
	  extent.setSystemInfo("Host Name", "Extent AvenStack"); 
	  extent.setSystemInfo("Environment", "QA");
	  extent.setSystemInfo("User Name", "Swati");
	  htmlReporter.config().setDocumentTitle("Extent Report");
	  htmlReporter.config().setReportName("Page Object Model Practice");
	 // htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
	  htmlReporter.config().setTheme(Theme.DARK); }
	  
	  @Test 
	  public void passTest()
	  { 
	  logger = extent.createTest("passTest");
	  Assert.assertTrue(true); 
	  logger.log(Status.PASS, MarkupHelper.createLabel("Test Case Passed is passTest", ExtentColor.GREEN));
	  }
	  
	  @Test 
	  public void failTest() 
	  { 
		  logger = extent.createTest("failTest");
	      logger.log(Status.FAIL,MarkupHelper.createLabel("Test Case (failTest) Status is passed", ExtentColor.ORANGE)); 
	      logger.log(Status.FAIL,MarkupHelper.createLabel("Test Case (failTest) Status is passed", ExtentColor.GREEN)); 
	      Assert.assertTrue(false); }
	  
	  @Test 
	  public void skipTest() 
	  { 
		  logger = extent.createTest("skipTest"); 
		  throw
	  new SkipException("Skipping - This is not ready for testing "); }
	  
	  @AfterMethod 
	  public void getResult(ITestResult result) 
	  { 
		  if (result.getStatus() == ITestResult.FAILURE) 
		  { 
			  logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			  logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			  }
		  else if (result.getStatus() == ITestResult.SKIP) 
		  {
	  logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE)); } }
	  
	  @AfterTest 
	  
	  public void endReport() 
	  {
		  extent.flush(); 
		  }
	 
}


