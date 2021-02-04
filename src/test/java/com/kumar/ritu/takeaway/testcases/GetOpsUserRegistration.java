package com.kumar.ritu.takeaway.testcases;

import com.aventstack.extentreports.Status;
import com.google.gson.Gson;
import com.kumar.ritu.takeaway.businesslayer.TestCasesBusinessLogic;
import com.kumar.ritu.takeaway.data.DataProviderClass;
import com.kumar.ritu.takeaway.data.yaml.YamlTestDataForAPI1;
import com.kumar.ritu.takeaway.pojos.AuthRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * This class contains all the test cases related to API 
 * We are separating test cases so that they will be easy to manage
 * 
 * @author Ritu
 */

public class GetOpsUserRegistration extends BaseTest {

	
	private TestCasesBusinessLogic testCasesBusinessLogic;
	private static final Logger logger = LogManager.getLogger(GetOpsUserRegistration.class.getName());
	private Gson gson = new Gson();
	
	
	public GetOpsUserRegistration() {
		testCasesBusinessLogic = new TestCasesBusinessLogic();
	
	}

	// Test method register the user
	@Test(dataProvider = "common_test_data_provider", dataProviderClass = DataProviderClass.class)
	public void registerUserTest(YamlTestDataForAPI1 apitestdata) {
		
		//Create the test case for extent report
		extentlogger = extent.createTest("registerUserTest: User Registration");
	    extentlogger.log(Status.INFO, "Register the user");
	    extentlogger.log(Status.INFO, "User's credentials are "+gson.toJson(apitestdata));
	    logger.info("Register the user with credentials {} .", gson.toJson(apitestdata));
	    
	    //Generate the logs
	    logger.info("Call the function userRegistration and pass the parameters. ");
	    AuthRequest authData =	testCasesBusinessLogic.userRegistration(gson.toJson(apitestdata));
	    
	    
	    extentlogger.log(Status.INFO, "Response status message is  "+TestCasesBusinessLogic.msg);
		extentlogger.log(Status.INFO, "Access token for the registered user is "+authData.getAccess_token());
		extentlogger.log(Status.INFO, "User id is "+authData.getUser_id());
		
		
		logger.info("userRegistration method returns the Access Token {}  ",authData.getAccess_token());
		logger.info("userRegistration method returns the user Id  {} .", authData.getUser_id());
		
		Assert.assertNotNull(authData.getAccess_token());
		Assert.assertNotNull(authData.getUser_id());
		
		
		
	}
	
	
}
