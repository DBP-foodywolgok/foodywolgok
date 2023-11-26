package model;

import java.util.List;

public class Customer {

	private int customer_id;
	private String email;
	private String password;
	private String name;
	
	private List<Comments> customer_comments;
	private List<Diary> customer_diaries;
	private List<Customer_Category> customer_categories;
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", email=" + email + ", password=" + password + ", name=" + name
				+ ", customer_comments=" + customer_comments + ", customer_diaries=" + customer_diaries
				+ ", customer_categories=" + customer_categories + "]";
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Comments> getCustomer_comments() {
		return customer_comments;
	}
	public void setCustomer_comments(List<Comments> customer_comments) {
		this.customer_comments = customer_comments;
	}
	public List<Diary> getCustomer_diaries() {
		return customer_diaries;
	}
	public void setCustomer_diaries(List<Diary> customer_diaries) {
		this.customer_diaries = customer_diaries;
	}
	public List<Customer_Category> getCustomer_categories() {
		return customer_categories;
	}
	public void setCustomer_categories(List<Customer_Category> customer_categories) {
		this.customer_categories = customer_categories;
	}
	public Customer(int customer_id, String email, String password, String name, List<Comments> customer_comments,
			List<Diary> customer_diaries, List<Customer_Category> customer_categories) {
		super();
		this.customer_id = customer_id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.customer_comments = customer_comments;
		this.customer_diaries = customer_diaries;
		this.customer_categories = customer_categories;
	}
	

	
	
}
