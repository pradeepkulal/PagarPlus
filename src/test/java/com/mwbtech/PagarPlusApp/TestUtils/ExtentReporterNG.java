package com.mwbtech.PagarPlusApp.TestUtils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG   {
	static ExtentReports extent;
	
	public static ExtentReports getReporterObject()
	{
		
	//	ExtentReports , ExtentSparkReporter
		String path =System.getProperty("user.dir")+"//reports//index.html"; //path to create HTML Report in desired location
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Mobile Automation Results-Pagar Plus");
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().enableTimeline(true);
		 extent =new ExtentReports();
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Tester", "Pradeep Kulal");
		extent.setSystemInfo("Platform Name", "Android 13.0");
		return extent;
		
	}

	
}
