package com.kumar.ritu.takeaway.testcases;

import com.aventstack.extentreports.Status;
import com.kumar.ritu.takeaway.businesslayer.TestCasesBusinessLogic;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * This class contains all the test cases that perform the delete operation.
 * We are separating test cases so that they will be easy to manage
 * 
 * @author Ritu
 */

public class DeleteOpsTask extends BaseTest{

	private static final Logger logger = LogManager.getLogger(DeleteOpsTask.class.getName());
	private TestCasesBusinessLogic testCasesBusinessLogic;
	
	
	
	
	public DeleteOpsTask() {
		testCasesBusinessLogic = new TestCasesBusinessLogic();
		
	}


	@Test()
	public void testDeleteTask() {
		
		extentlogger = extent.createTest("testDeleteTask: Delete User's all tasks");
	    extentlogger.log(Status.INFO, "Delete the task ");
		
	    logger.info("Delete User's all tasks");
	    
		int statusCode =testCasesBusinessLogic.deleteTask();
		logger.info("Response status message is  "+TestCasesBusinessLogic.msg);
		extentlogger.log(Status.INFO, "Response status message is  "+TestCasesBusinessLogic.msg);
		Assert.assertEquals(statusCode, HttpStatus.SC_NO_CONTENT);
		
		
		
		
	}
	
	
}
