package model.dto;

import java.sql.Blob;
import java.util.Date;

public class Diary {

    private String title;
    private Integer isShared;
    private Date nowDate;
    private Blob photo; // Changed data type to Blob for blob storage
    private String content;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getIsShared() {
		return isShared;
	}
	public void setIsShared(Integer isShared) {
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
	@Override
	public String toString() {
		return "Diary [title=" + title + ", isShared=" + isShared + ", nowDate=" + nowDate + ", photo=" + photo
				+ ", content=" + content + "]";
	}
	public Diary(String title, Integer isShared, Date nowDate, Blob photo, String content) {
		super();
		this.title = title;
		this.isShared = isShared;
		this.nowDate = nowDate;
		this.photo = photo;
		this.content = content;
	}

    
}

