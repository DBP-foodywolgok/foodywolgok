package model;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

public class Diary {

	private int diary_id;
	private String title;
	private int isShared;
	private Date nowDate;
	private Blob photo;
	private String content;
	private int restaurant_id;
	private int customer_id;
	
	public Diary() {}

	public Diary(int diary_id, String title, int isShared, Date nowDate, Blob photo, String content, int restaurant_id,
			int customer_id) {
		super();
		this.diary_id = diary_id;
		this.title = title;
		this.isShared = isShared;
		this.nowDate = nowDate;
		this.photo = photo;
		this.content = content;
		this.restaurant_id = restaurant_id;
		this.customer_id = customer_id;
	}

	public int getDiary_id() {
		return diary_id;
	}

	public void setDiary_id(int diary_id) {
		this.diary_id = diary_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIsShared() {
		return isShared;
	}

	public void setIsShared(int isShared) {
		this.isShared = isShared;
	}

	public Date getNowDate() {
		return nowDate;
	}

	public void setNowDate(Date nowDate) {
		this.nowDate = nowDate;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	@Override
	public String toString() {
		return "Diary [diary_id=" + diary_id + ", title=" + title + ", isShared=" + isShared + ", nowDate=" + nowDate
				+ ", photo=" + photo + ", content=" + content + ", restaurant_id=" + restaurant_id + ", customer_id="
				+ customer_id + "]";
	};
	
	
	
	
}
