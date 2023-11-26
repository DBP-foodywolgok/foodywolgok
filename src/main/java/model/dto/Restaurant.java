package model.dto;

public class Restaurant {

	private String introduction;
	private Float latitude;
	private Float longtitude;
	private String name;
	private String address;
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
	@Override
	public String toString() {
		return "Restaurant [introduction=" + introduction + ", latitude=" + latitude + ", longtitude=" + longtitude
				+ ", name=" + name + ", address=" + address + "]";
	}
	public Restaurant(String introduction, Float latitude, Float longtitude, String name, String address) {
		super();
		this.introduction = introduction;
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.name = name;
		this.address = address;
	}
	
	
}
