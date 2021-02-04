package com.kumar.ritu.takeaway.pojos;

/**
 * POJOs for API Response   http://<domain>/auth/vi/register
 * e.g. http://localhost:8000/api/auth/vi/register
 * 
 * POJOs required to have actual representations of our particular API's response
 * 
 * @author Ritu
 */
public class Author {

	String id;
	String name;
	String email;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
