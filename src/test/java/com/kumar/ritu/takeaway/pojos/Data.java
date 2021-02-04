package com.kumar.ritu.takeaway.pojos;


public class Data {

	private String title;
	private String id;
	private String  due_at;
	private String  is_completed;
private Author author;

	 public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDue_at() {
		return due_at;
	}

	public void setDue_at(String due_at) {
		this.due_at = due_at;
	}

	public String getIs_completed() {
		return is_completed;
	}

	public void setIs_completed(String is_completed) {
		this.is_completed = is_completed;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
		
}
