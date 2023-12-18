package model;

import java.util.Date;

public class My_restaurant {

	private int id = 0;
	private String name = null;
	private String address = null;
	private int score = 0;
	private String memo = null;
	private Date created_at = null;
	private Date updated_at = null;
	private int customerId = 0;
	private int restaurantId = 0;
	private int categoryId = 0;
	private String category = null; // category의 이름
	
	// default 생성자
	public My_restaurant() {
		
	}
	
	// 멤버 변수 초기화 생성자
	public My_restaurant(int id, String name, String address, int score, String memo, Date created_at, Date updated_at,
			int customerId, int restaurantId, int categoryId, String category) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.score = score;
		this.memo = memo;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.customerId = customerId;
		this.restaurantId = restaurantId;
		this.categoryId = categoryId;
		this.category = category;
	}
	
	// 사용자 직접 등록
	public My_restaurant(String name, String address, int score, String memo, Date created_at,
			int customerId, int categoryId) {
		this.name = name;
		this.address = address;
		this.score = score;
		this.memo = memo;
		this.created_at = created_at;
		this.customerId = customerId;
		this.categoryId = categoryId;
	}
	
	// getter & setter
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	// toString
	@Override
	public String toString() {
		return "My_restaurant [id=" + id + ", name=" + name + ", address=" + address + ", score=" + score + ", memo="
				+ memo + ", created_at=" + created_at + ", updated_at=" + updated_at + ", customerId=" + customerId
				+ ", restaurantId=" + restaurantId + ", categoryId=" + categoryId + ", category=" + category + "]";
	}

}
