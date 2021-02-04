package com.kumar.ritu.takeaway.pojos;

import java.util.List;

/**
* POJOs for API Response   http://<domain>/api/vi/tasks
 * e.g. http://localhost:8000/api/vi/tasks
 * 
 * POJOs required to have actual representations of our particular API's response
 * 
 * @author Ritu
 */
public class AllTasks {

private List<Data> data;

public List<Data> getData() {
return data;
}

public void setData(List<Data> data) {
this.data = data;
}
	
	
}
