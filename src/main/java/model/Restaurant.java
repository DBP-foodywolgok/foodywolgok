package model;

import java.util.List;

public class Restaurant {

	private int restaurant_id;
	private Category cateogry;
	private String introduction;
	private Float latitude;
	private Float longtitude;
	private String name;
	private String address;
	
	private List<Restaurant_Wishlist> restuarnat_wishlists;

	@Override
	public String toString() {
		return "Restaurant [restaurant_id=" + restaurant_id + ", cateogry=" + cateogry + ", introduction="
				+ introduction + ", latitude=" + latitude + ", longtitude=" + longtitude + ", name=" + name
				+ ", address=" + address + ", restuarnat_wishlists=" + restuarnat_wishlists + "]";
	}

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public Category getCateogry() {
		return cateogry;
	}

	public void setCateogry(Category cateogry) {
		this.cateogry = cateogry;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongtitude() {
		return longtitude;
	}

	public void setLongtitude(Float longtitude) {
		this.longtitude = longtitude;
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

	public List<Restaurant_Wishlist> getRestuarnat_wishlists() {
		return restuarnat_wishlists;
	}

	public void setRestuarnat_wishlists(List<Restaurant_Wishlist> restuarnat_wishlists) {
		this.restuarnat_wishlists = restuarnat_wishlists;
	}

	public Restaurant(int restaurant_id, Category cateogry, String introduction, Float latitude, Float longtitude,
			String name, String address, List<Restaurant_Wishlist> restuarnat_wishlists) {
		super();
		this.restaurant_id = restaurant_id;
		this.cateogry = cateogry;
		this.introduction = introduction;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.name = name;
		this.address = address;
		this.restuarnat_wishlists = restuarnat_wishlists;
	}
	
	
	
	
}
