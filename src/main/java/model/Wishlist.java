package model;

import java.util.Date;
import java.util.List;

public class Wishlist {

	private int wishlist_id;
	private String color;
	private Date created_at;
	private int customer_id;
	private String name;
	private String memo;

	public Wishlist() {
        super();
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
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
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
	
	public Wishlist(int wishlist_id, String color, Date created_at, int customer_id, String name, String memo) {
		super();
		this.wishlist_id = wishlist_id;
		this.color = color;
		this.created_at = created_at;
		this.customer_id = customer_id;
		this.name = name;
		this.memo = memo;
	}
}
