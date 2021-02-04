package com.kumar.ritu.takeaway.pojos;


public class Tasks {

	private Data data;
	
	public Tasks() {
		super();
	}
	public Tasks(Data data) {
		this();
		this.data = data;
				
	}
	
	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

		
}
