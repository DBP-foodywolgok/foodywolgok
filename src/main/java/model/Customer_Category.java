package model;

public class Customer_Category {

	
	private Customer customer;
	private Category category;
	@Override
	public String toString() {
		return "Customer_Category [customer=" + customer + ", category=" + category + "]";
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Customer_Category(Customer customer, Category category) {
		super();
		this.customer = customer;
		this.category = category;
	}
	
	
	
}
