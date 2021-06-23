package com.optimus.genericUtils;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class Listeners extends TestListenerAdapter{
	public ExtentHtmlReporter htmlReporter;
	public ExtentTest test;
	public ExtentReports extent;

	public void onStart(ITestContext testContext) {
		//Specifying location
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/reports/myReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");//title of report
		htmlReporter.config().setReportName("Rest API Testing Report");//name of report
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Project Name", "Optimus");
		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("Enviroment", "QA");
		extent.setSystemInfo("User", "Vishnu Raj");
				
	}		
	 public void  onTestSuccess(ITestResult result) {
//		test=extent.createTest(result.getClass().getName()) ;
//		test.createNode(result.getName());
		test=extent.createTest(result.getName());	
		test.log(Status.PASS,"Test Case Passed is "+result.getName());		
				
	 }
	
	 public void onTestFailure(ITestResult result) {
		 test=extent.createTest(result.getName());//add name to report
		 test.log(Status.FAIL,"Test Case Failed is "+result.getName());
		 test.log(Status.FAIL,"Test Case Failed is "+result.getThrowable());
	 }
	
	 public void onTestSkipped(ITestResult result) {
		 test=extent.createTest(result.getName());//create new entry the report
		 test.log(Status.SKIP,"Test Case Skipped is "+result.getName());
	 }
	 public void onFinish(ITestContext testContext) {
		 extent.flush();
	 }	
	
}
