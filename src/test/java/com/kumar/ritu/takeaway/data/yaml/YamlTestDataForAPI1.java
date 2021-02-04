package com.kumar.ritu.takeaway.data.yaml;

public class YamlTestDataForAPI1  extends TestData{

	String name;
	String email;
	String password;
	String password_confirmation;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getPassword_confirmation() {
		return password_confirmation;
	}

	public void setPassword_confirmation(String password_confirmation) {
		this.password_confirmation = password_confirmation;
	}

	@Override
	public String toString() {
		return "YamlTestDataForAPI1 [name="+name+",email="+email+",password="+password+",password_confirmation="+password_confirmation+"]";
	}

}
