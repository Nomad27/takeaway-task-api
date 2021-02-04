package com.kumar.ritu.takeaway.testcases;

import com.aventstack.extentreports.Status;
import com.kumar.ritu.takeaway.businesslayer.TestCasesBusinessLogic;
import com.kumar.ritu.takeaway.pojos.Tasks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;

/**
 * This class contains the test method to fetch all the task created by user.
 * We are separating test cases so that they will be easy to manage
 * 
 * @author Ritu
 */

public class GetOpsAllTask extends BaseTest {

	private static final Logger logger = LogManager.getLogger(GetOpsAllTask.class.getName());
	private TestCasesBusinessLogic testCasesBusinessLogic;

	
	
	public GetOpsAllTask() {
		testCasesBusinessLogic = new TestCasesBusinessLogic();
		
	}



	@Test()
	public void testGetAllTaskOfUser() {
		
		List<Tasks> tasksList = testCasesBusinessLogic.getAllTaskOfUser();
		
		    
		 
		extentlogger = extent.createTest("testGetAllTaskOfUser: Get all the task created by user");
		extentlogger.log(Status.INFO, "Response status message is  "+TestCasesBusinessLogic.msg);
		extentlogger.log(Status.INFO, "Total number of tasks created by User "+tasksList.size());
		
		 
		//Generate the logs
		logger.info("Call the function getAllTaskOfUser. ");
		logger.info("Fetch all the task created by the user.");
		logger.info("Response status message is  "+TestCasesBusinessLogic.msg); 
		logger.info("Task lists are : ");
		    
		for(Tasks allTsk : tasksList) {
			
			
			logger.info("Task title is "+allTsk.getData().getTitle());
			logger.info( "Task Id  is "+allTsk.getData().getId());
			logger.info("Task due at is "+allTsk.getData().getDue_at());
			logger.info("Task is completed "+allTsk.getData().getIs_completed());
			logger.info("Task author id is "+allTsk.getData().getAuthor().getId());
			logger.info("Task author name is "+allTsk.getData().getAuthor().getName());
			logger.info("Task author email is "+allTsk.getData().getAuthor().getEmail());
			extentlogger.log(Status.INFO, "Task title is "+allTsk.getData().getTitle());
			extentlogger.log(Status.INFO, "Task Id  is "+allTsk.getData().getId());
			extentlogger.log(Status.INFO, "Task due at is "+allTsk.getData().getDue_at());
			extentlogger.log(Status.INFO, "Task is completed "+allTsk.getData().getIs_completed());
			extentlogger.log(Status.INFO, "Task author id is "+allTsk.getData().getAuthor().getId());
			extentlogger.log(Status.INFO, "Task author name is "+allTsk.getData().getAuthor().getName());
			extentlogger.log(Status.INFO, "Task author email is "+allTsk.getData().getAuthor().getEmail());
			
		}

		assertFalse(tasksList.isEmpty());

	}
	
	
}
