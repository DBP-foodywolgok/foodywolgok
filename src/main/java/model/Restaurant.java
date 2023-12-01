package model;

import java.util.List;

public class Restaurant {

    private int restaurant_id;
    private int category_id;
    private String introduction;
    private float latitude;
    private float longtitude;
    private String name;
    private String address;
    
    private List<Restaurant_Wishlist> restuarnat_wishlists;

    @Override
    public String toString() {
        return "Restaurant [restaurant_id=" + restaurant_id + ", cateogry=" + category_id + ", introduction="
                + introduction + ", latitude=" + latitude + ", longtitude=" + longtitude + ", name=" + name
                + ", address=" + address + /* ", restuarnat_wishlists=" + restuarnat_wishlists + */ "]";
    }

    public int getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(int restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public int getCateogry() {
        return category_id;
    }

    public void setCateogry(int cateogry_id) {
        this.category_id = cateogry_id;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Float longtitude) {
        this.longtitude = longtitude;
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

    
    public Restaurant(int restaurant_id, int category_id, String introduction, float latitude, float longtitude,
            String name, String address) {
        super();
        this.restaurant_id = restaurant_id;
        this.category_id = category_id;
        this.introduction = introduction;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.name = name;
        this.address = address;
    }

public Restaurant() {
    super();
}
    
}
