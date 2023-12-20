package model;

public class Comments {

	private int comment_id;
	private String content;
	private int diary_id;
	private int customer_id;
	private String name;
	

	public Comments(){};

	/*public Comments(int comment_id, String content, int diary_id, int customer_id) {
		super();
		this.comment_id = comment_id;
		this.content = content;
		this.diary_id = diary_id;
		this.customer_id = customer_id;
	}*/
	
	public Comments(int comment_id, String content, int diary_id, int customer_id, String name) {
		super();
		this.comment_id = comment_id;
		this.content = content;
		this.diary_id = diary_id;
		this.customer_id = customer_id;
		this.name = name;
	}

	public int getComment_id() {
		return comment_id;
	}

	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getDiary_id() {
		return diary_id;
	}

	public void setDiary_id(int diary_id) {
		this.diary_id = diary_id;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	@Override
	public String toString() {
		return "Comments [comment_id=" + comment_id + ", content=" + content + ", diary_id=" + diary_id
				+ ", customer_id=" + customer_id + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	};
	
	

}
