package com.kumar.ritu.takeaway.businesslayer;

import com.kumar.ritu.takeaway.data.PropertyFileReader;
import com.kumar.ritu.takeaway.pojos.AllTasks;
import com.kumar.ritu.takeaway.pojos.AuthRequest;
import com.kumar.ritu.takeaway.pojos.Data;
import com.kumar.ritu.takeaway.pojos.Tasks;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Business Layer : Sole purpose is to accept data and populate POJOs and
 * further perform some task related to particular domain
 * 
 * This class will contains all logic related to API http://localhost:8080>
 * 
 * @author Ritu
 */
public class TestCasesBusinessLogic {


	private static String baseURL;
	public static String msg;
	public static String token;
	static List<Tasks> tasksList;
	public Response response;
	
	public TestCasesBusinessLogic() {
		
		baseURL = PropertyFileReader.getPropertyData().getApis().get("homeurl");
		tasksList = new ArrayList<>();
	}

	// This method register the user
	public AuthRequest userRegistration(String data){
		
		AuthRequest auth= new AuthRequest();
	    String authMe = PropertyFileReader.getPropertyData().getApis().get("authme");
	    response =RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
						  .body(data).post(baseURL + authMe);
	   
	    if(response.getStatusCode()==HttpStatus.SC_CREATED) {
	    	
	    	auth= response.getBody().as(AuthRequest.class);
	    	//message.setMessage(" rspo"+response.getStatusLine());
	    	msg =response.getStatusLine();
			token = auth.getAccess_token();
	    }else if (response.getStatusCode()==HttpStatus.SC_BAD_REQUEST) {
	    	
	    	msg =response.getStatusLine();
	    	//message.setMessage(response.getStatusLine());
	    	
	    } 
		
		return auth;
	}

	public Tasks createTasks(String title) {
		Tasks task = null ;
		String tasks = PropertyFileReader.getPropertyData().getApis().get("tasks");
		
        response =RestAssured.given().accept(ContentType.JSON).contentType(ContentType.JSON)
							.header(new Header("Authorization", "Bearer "+token))
							.body(title)
							.post(baseURL + tasks);
        if(response.getStatusCode()==HttpStatus.SC_CREATED) {
        	task= 	response.getBody().as(Tasks.class);	
        	//message.setMessage(response.getStatusLine());
        	msg =response.getStatusLine();
        }
         else if (response.getStatusCode()==HttpStatus.SC_UNAUTHORIZED || response.getStatusCode()==HttpStatus.SC_UNPROCESSABLE_ENTITY || response.getStatusCode()==HttpStatus.SC_FORBIDDEN || response.getStatusCode()==HttpStatus.SC_BAD_REQUEST) {
        	
        	msg =response.getStatusLine();
        } 
			
	    return task;
		
		
	}
	
	public List<Tasks> getAllTaskOfUser() {
		String tasks = PropertyFileReader.getPropertyData().getApis().get("tasks");

		Response response =RestAssured.given().accept(ContentType.JSON)
				.header(new Header("Authorization", "Bearer "+token))
				.get(baseURL + tasks);
		
		if(response.getStatusCode()==HttpStatus.SC_OK) {
		List<AllTasks>listOfTasks = Arrays.asList(response.getBody().as(AllTasks.class));

		for(AllTasks allTsk : listOfTasks) {
			for(Data data : allTsk.getData()) {
				tasksList.add(new Tasks(data));
			}
		}
		  msg =response.getStatusLine();
		}
		 else if (response.getStatusCode()==HttpStatus.SC_UNAUTHORIZED || response.getStatusCode()==HttpStatus.SC_UNPROCESSABLE_ENTITY || response.getStatusCode()==HttpStatus.SC_FORBIDDEN || response.getStatusCode()==HttpStatus.SC_BAD_REQUEST) {
	        	
	        	msg =response.getStatusLine();
	        }
		
		return  tasksList;
		
	}

	public int deleteTask() {
		
		
		String tasks = PropertyFileReader.getPropertyData().getApis().get("tasks");
		
		System.out.println(token);
		for(Tasks allTsk : tasksList) {
			String taskId = allTsk.getData().getId();
		 response =RestAssured.given().accept(ContentType.JSON)
				.header(new Header("Authorization", "Bearer "+token))
				.pathParam("taskId", taskId)
				.delete(baseURL + tasks+"/{taskId}");
		
		System.out.println("deleteTask "+response.getStatusCode());
		if (response.getStatusCode()==HttpStatus.SC_NO_CONTENT) {
			msg =response.getStatusLine();
        }
		 else if (response.getStatusCode()==HttpStatus.SC_UNAUTHORIZED || response.getStatusCode()==HttpStatus.SC_UNPROCESSABLE_ENTITY || response.getStatusCode()==HttpStatus.SC_FORBIDDEN || response.getStatusCode()==HttpStatus.SC_BAD_REQUEST) {
	        	
	        	msg =response.getStatusLine();
	        }
		
		}
		return response.getStatusCode();
	}
	
	
}
