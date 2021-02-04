package com.kumar.ritu.takeaway.testcases;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.kumar.ritu.takeaway.businesslayer.TestCasesBusinessLogic;
import com.kumar.ritu.takeaway.data.DataProviderClass;
import com.kumar.ritu.takeaway.data.yaml.YamlTestDataForAPI2;
import com.kumar.ritu.takeaway.pojos.Tasks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

/**
 * This class contains all the test cases related to Post operation.
 * We are separating test cases so that they will be easy to manage
 * 
 * @author Ritu
 */

public class PostOpsCreateTasks extends BaseTest{

	private static final Logger logger = LogManager.getLogger(PostOpsCreateTasks.class.getName());
	private TestCasesBusinessLogic testCasesBusinessLogic;
	private Gson gson = new Gson();
	
	
	public PostOpsCreateTasks() {
		testCasesBusinessLogic = new TestCasesBusinessLogic();
				
	}


	@Test(dataProvider = "common_test_data_provider", dataProviderClass = DataProviderClass.class)
	public void createTaskTest(YamlTestDataForAPI2 apitestdata) {
		
		
		logger.info("Call the method createTasks and send the parameters: .", gson.toJson(apitestdata));
		extentlogger = extent.createTest("createTaskTest: Create Task");  
		Tasks tasks = testCasesBusinessLogic.createTasks(gson.toJson(apitestdata));
		
		//Create the test case for extent report
		 
		    
		logger.info("Response status message is  "+TestCasesBusinessLogic.msg); 
		extentlogger.log(Status.INFO, "Response status message is  "+TestCasesBusinessLogic.msg);
		logger.info("Method return : Task tile - {} .", tasks.getData().getTitle());
		logger.info("Task Id - {} .", tasks.getData().getId());
		logger.info("Task created by {}.", tasks.getData().getAuthor().getName());
			
		
		
		extentlogger.log(Status.INFO, "Task is created");
		extentlogger.log(Status.INFO, "Task Title is "+tasks.getData().getTitle());
		extentlogger.log(Status.INFO, "Task Id  is "+tasks.getData().getId());
		extentlogger.log(Status.INFO, "Task due at is "+tasks.getData().getDue_at());
		extentlogger.log(Status.INFO, "Task is completed "+tasks.getData().getIs_completed());
		extentlogger.log(Status.INFO, "Task author id is "+tasks.getData().getAuthor().getId());
		extentlogger.log(Status.INFO, "Task author name is "+tasks.getData().getAuthor().getName());
		extentlogger.log(Status.INFO, "Task author email is "+tasks.getData().getAuthor().getEmail());
		
		Assert.assertNotNull(tasks.getData().getId());
		
			
		
	}
	
}
