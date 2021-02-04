package com.kumar.ritu.takeaway.testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Base test class.
 */
public class BaseTest {

	private static final Logger logger = LogManager.getLogger(BaseTest.class.getName());

	
	public static ExtentReports extent;
	public static ExtentHtmlReporter reporter;
	public static ExtentTest extentlogger;
	public static ExtentTest childTest;
	ExtentTest test;
	static Date date = new Date();  
    static Timestamp ts=new Timestamp(date.getTime());  
    static SimpleDateFormat timestamp = new SimpleDateFormat("yyyy-MM-dd HH_mm_ss");  
	//private static String reportFileName = "taskapi"+timestamp.format(ts)+".html";
    private static String reportFileName = "taskapi_report.html";
    private static String reportFilepath = "./target/";
    final static String filepath =  reportFilepath + reportFileName;
    

/** Method for initiate the Extent Report */
    @BeforeTest
    public void intiateReporting() {
    	
    	reporter = new ExtentHtmlReporter(filepath);
    	extent = new ExtentReports();
    	extent.setSystemInfo("Name", "Takeaway Test Assignment");
    	extent.setSystemInfo("User Name", "Ritu Puneet Kumar");
    	reporter.config().setCSS("css-string");
    	reporter.config().setEncoding("utf-8");
    	reporter.config().setJS("js-string");
    	reporter.config().setDocumentTitle("Takeaway Test Assignment");
    	reporter.config().setTheme(Theme.DARK);
    	extent.attachReporter(reporter);
    	extent.setReportUsesManualConfiguration(true);
    }
    @AfterMethod
    public void getResult(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
        	extentlogger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
        	extentlogger.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
        	extentlogger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
        }
        else {
        	extentlogger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
        	extentlogger.skip(result.getThrowable());
        }
    }
    
    @AfterTest
    public void close()
    {
    	
    	extent.flush();
    }
}
