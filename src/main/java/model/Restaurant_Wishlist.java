package model;

public class Restaurant_Wishlist {

	private int restaurant_wishlist_id;
	private String nickname;
	private int restaurant_id;
	private int wishlist_id;

	@Override
	public String toString() {
		return "Restaurant_Wishlist [restaurant_wishlist_id=" + restaurant_wishlist_id + ", nickname=" + nickname
				+ ", restaurant=" + restaurant_id + ", wishlist=" + wishlist_id + "]";
	}

	public int getRestaurant_wishlist_id() {
		return restaurant_wishlist_id;
	}

	public void setRestaurant_wishlist_id(int restaurant_wishlist_id) {
		this.restaurant_wishlist_id = restaurant_wishlist_id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public int getWishlist_id() {
		return wishlist_id;
	}

	public void setWishlist_id(int wishlist_id) {
		this.wishlist_id = wishlist_id;
	}

	public Restaurant_Wishlist(int restaurant_wishlist_id, String nickname, Restaurant restaurant, Wishlist wishlist) {
		super();
		this.restaurant_wishlist_id = restaurant_wishlist_id;
		this.nickname = nickname;
		this.restaurant_id = restaurant_id;
		this.wishlist_id = wishlist_id;
	}
	
	
	
	
	
}
