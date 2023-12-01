package model;

import java.util.Date;
import java.util.List;

public class Wishlist {

	private int wishlist_id;
	private String color;
	private Date created_at;
	private Customer customer;
	private String name;
	private String memo;
	private List<Restaurant_Wishlist> restaurant_wishlists;
	@Override
	public String toString() {
		return "Wishlist [wishlist_id=" + wishlist_id + ", color=" + color + ", created_at=" + created_at
				+ ", customer=" + customer + ", name=" + name + ", memo=" + memo + ", restaurant_wishlists="
				+ restaurant_wishlists + "]";
	}
	public int getWishlist_id() {
		return wishlist_id;
	}
	public void setWishlist_id(int wishlist_id) {
		this.wishlist_id = wishlist_id;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
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
	public List<Restaurant_Wishlist> getRestaurant_wishlists() {
		return restaurant_wishlists;
	}
	public void setRestaurant_wishlists(List<Restaurant_Wishlist> restaurant_wishlists) {
		this.restaurant_wishlists = restaurant_wishlists;
	}
	public Wishlist(int wishlist_id, String color, Date created_at, Customer customer, String name, String memo,
			List<Restaurant_Wishlist> restaurant_wishlists) {
		super();
		this.wishlist_id = wishlist_id;
		this.color = color;
		this.created_at = created_at;
		this.customer = customer;
		this.name = name;
		this.memo = memo;
		this.restaurant_wishlists = restaurant_wishlists;
	}
}
