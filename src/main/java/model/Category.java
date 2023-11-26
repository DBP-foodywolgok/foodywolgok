package model;

import java.util.List;

public class Category {

	private int category_id;
	private String name;
	
	private List<Customer_Category> customer_categories;

	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", name=" + name + ", customer_categories="
				+ customer_categories + "]";
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Customer_Category> getCustomer_categories() {
		return customer_categories;
	}

	public void setCustomer_categories(List<Customer_Category> customer_categories) {
		this.customer_categories = customer_categories;
	}

	public Category(int category_id, String name, List<Customer_Category> customer_categories) {
		super();
		this.category_id = category_id;
		this.name = name;
		this.customer_categories = customer_categories;
	}
	

	
	
}
