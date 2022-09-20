package org.doordash.genericUtility;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementataion implements ITestListener {
  private ExtentReports reports;
  public  static ExtentTest stest;
  private ExtentTest test;
  
  @Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./extentReport/extentreport.html");
		spark.config().setDocumentTitle("Document Title-Doordash");
		spark.config().setReportName("Reporter Name-Doordash");
		spark.config().setTheme(Theme.DARK);
		
		 reports = new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("Author","Akshatha");
		reports.setSystemInfo("OS","win 8" );
		reports.setSystemInfo("Browser", "chrome");
	}
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	 test=reports.createTest(result.getMethod().getMethodName());
	 stest=test;
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.pass(result.getMethod().getMethodName()+" pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.fail(result.getMethod().getMethodName()+" fail");
		test.fail(result.getThrowable());
		String path = new WebDriverUtility().screenShot(BaseClass.sdriver);
		test.addScreenCaptureFromBase64String(path);
		//System.out.println(Thread.currentThread().getId());
//		try {
//			new WebDriverUtility().screenShot(BaseClass.sdriver, BaseClass.sjavautility, result.getMethod().getMethodName());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.skip(result.getMethod().getMethodName()+ " skip");
		test.fail(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		reports.flush();
	}

}
