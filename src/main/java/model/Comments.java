package model;

public class Comments {

	private int comment_id;
	private Diary diary;
	private Customer customer;
	private String content;
	@Override
	public String toString() {
		return "Comments [comment_id=" + comment_id + ", diary=" + diary + ", customer=" + customer + ", content="
				+ content + "]";
	}
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public Diary getDiary() {
		return diary;
	}
	public void setDiary(Diary diary) {
		this.diary = diary;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Comments(int comment_id, Diary diary, Customer customer, String content) {
		super();
		this.comment_id = comment_id;
		this.diary = diary;
		this.customer = customer;
		this.content = content;
	}
	
	
	
	
	
	

}
