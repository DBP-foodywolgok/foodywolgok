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
	private List<Restaurant> restaurants;
	private List<Customer> customers;
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
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	@Override
	public String toString() {
		return "Diary [diary_id=" + diary_id + ", title=" + title + ", isShared=" + isShared + ", nowDate=" + nowDate
				+ ", photo=" + photo + ", content=" + content + ", restaurants=" + restaurants + ", customers="
				+ customers + "]";
	}
	public Diary(int diary_id, String title, int isShared, Date nowDate, Blob photo, String content,
			List<Restaurant> restaurants, List<Customer> customers) {
		super();
		this.diary_id = diary_id;
		this.title = title;
		this.isShared = isShared;
		this.nowDate = nowDate;
		this.photo = photo;
		this.content = content;
		this.restaurants = restaurants;
		this.customers = customers;
	}
	
	
}
