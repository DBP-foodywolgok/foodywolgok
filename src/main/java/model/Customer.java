package model;

import java.util.List;


public class Customer {
    private int customer_id; // ID가 자동 생성되는 경우 일시적인 값으로 설정
    private String email;
    private String password;
    private String name;

    private List<String> favoriteCategories; // 고객이 선택한 카테고리 정보를 담을 리스트

    public List<String> getFavoriteCategories() {
        return favoriteCategories;
    }

    public void setFavoriteCategories(List<String> favoriteCategories) {
        this.favoriteCategories = favoriteCategories;
    }
  

    public Customer(String email, String password, String name) {
		super();
	
		this.email = email;
		this.password = password;
		this.name = name;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	// ID에 접근하기 위한 게터와 세터
    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    // 나머지 필드들에 접근하기 위한 게터와 세터
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}