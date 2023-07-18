package S2practice;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class iTest implements ITestListener
{
	ExtentSparkReporter spark ;
	ExtentReports reports;
	ExtentTest test ;
    WebDriver wd ;
    
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		reports.flush();
		
	    
		
	
	 		
		
		
	}
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

		spark = new ExtentSparkReporter("test-output/spark.html");
		reports = new ExtentReports();
		
		reports.attachReporter(spark);
	    test = reports.createTest("Logging through Itest Listners")
			  .log(Status.INFO, "First Tescase logged");
	     
		
	}
	
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	
	 System.out.println("TestStarted" +result.getMethod());
	 test.createNode("Test Started").log(Status.INFO, "Test Started");
		
	}

	public void onTestFailure(ITestResult result) {
		
		try {
		 System.out.println("TestFailed");
		 test.createNode("TestFailed").log(Status.FAIL, "TestFailed");
		 screenshotUtility s =new screenshotUtility();
		 String screenpath = s.screenshot(wd, "screenshotNo");  
		 test.log(Status.FAIL, "Snapshot below "+test.addScreenCaptureFromPath(screenpath));
		
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
	}
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.createNode("Test Passed ").log(Status.FAIL, "Test Sucess");
		 screenshotUtility s =new screenshotUtility();
		String screenpath = s.screenshot(wd, "screenshotNo");  
		test.log(Status.PASS, "Snapshot below "+test.addScreenCaptureFromPath(screenpath));
		
	}
	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.createNode("Test Passed ").log(Status.SKIP, "Test Skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		test.createNode("TestFailed with percentage ").log(Status.FAIL, "Test Skipped");
		screenshotUtility s =new screenshotUtility();
		String screenpath = s.screenshot(wd, "screenshotNo");  
		test.log(Status.FAIL, "Snapshot below "+test.addScreenCaptureFromPath(screenpath));
		
		
	}
	
	
}
