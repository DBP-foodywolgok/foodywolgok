package model.dto;

import java.util.Date;

public class wishlist {

	private String color;
	private Date created_at;
	private String name;
	private String memo;
	@Override
	public String toString() {
		return "wishlist [color=" + color + ", created_at=" + created_at + ", name=" + name + ", memo=" + memo + "]";
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
	public wishlist(String color, Date created_at, String name, String memo) {
		super();
		this.color = color;
		this.created_at = created_at;
		this.name = name;
		this.memo = memo;
	}

	
	
}
