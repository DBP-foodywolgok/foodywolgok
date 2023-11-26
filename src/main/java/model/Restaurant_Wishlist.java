package model;

public class Restaurant_Wishlist {

	private int restaurant_wishlist_id;
	private String nickname;
	
	private Restaurant restaurant;
	
	private Wishlist wishlist;

	@Override
	public String toString() {
		return "Restaurant_Wishlist [restaurant_wishlist_id=" + restaurant_wishlist_id + ", nickname=" + nickname
				+ ", restaurant=" + restaurant + ", wishlist=" + wishlist + "]";
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

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Wishlist getWishlist() {
		return wishlist;
	}

	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}

	public Restaurant_Wishlist(int restaurant_wishlist_id, String nickname, Restaurant restaurant, Wishlist wishlist) {
		super();
		this.restaurant_wishlist_id = restaurant_wishlist_id;
		this.nickname = nickname;
		this.restaurant = restaurant;
		this.wishlist = wishlist;
	}
	
	
	
	
	
}
