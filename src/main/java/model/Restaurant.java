package model;

import java.util.List;

public class Restaurant {

	private int restaurantId;
    private int categoryId;
    private String introduction;
    private double latitude;
    private double longitude;
    private String name;
    private String address;
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", categoryId=" + categoryId + ", introduction="
				+ introduction + ", latitude=" + latitude + ", longitude=" + longitude + ", name=" + name + ", address="
				+ address + "]";
	}
	public Restaurant(int restaurantId, int categoryId, String introduction, double latitude, double longitude,
			String name, String address) {
		super();
		this.restaurantId = restaurantId;
		this.categoryId = categoryId;
		this.introduction = introduction;
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
		this.address = address;
	}
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
    
    
	
	
}
