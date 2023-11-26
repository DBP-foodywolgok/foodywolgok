package model;

import java.util.Date;

public class My_restaurant {

	private int my_restaurant_id;
	private int score;
	private Date created_at;
	private Date updated_at;
	private Category category;
	private Restaurant restaurant;
	private Customer customer;
	private String name;
	private String memo;
	private String address;
	@Override
	public String toString() {
		return "My_restaurant [my_restaurant_id=" + my_restaurant_id + ", score=" + score + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + ", category=" + category + ", restaurant=" + restaurant + ", customer="
				+ customer + ", name=" + name + ", memo=" + memo + ", address=" + address + "]";
	}
	public int getMy_restaurant_id() {
		return my_restaurant_id;
	}
	public void setMy_restaurant_id(int my_restaurant_id) {
		this.my_restaurant_id = my_restaurant_id;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public My_restaurant(int my_restaurant_id, int score, Date created_at, Date updated_at, Category category,
			Restaurant restaurant, Customer customer, String name, String memo, String address) {
		super();
		this.my_restaurant_id = my_restaurant_id;
		this.score = score;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.category = category;
		this.restaurant = restaurant;
		this.customer = customer;
		this.name = name;
		this.memo = memo;
		this.address = address;
	}
	
	
}
