package model.dto;

public class Comments {

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Comments [content=" + content + "]";
	}

	public Comments(String content) {
		super();
		this.content = content;
	}
	
	
}
