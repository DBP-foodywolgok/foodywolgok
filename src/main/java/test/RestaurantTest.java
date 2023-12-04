package test;

import java.util.List;

import model.Restaurant;
import model.dao.RestaurantDAO;

public class RestaurantTest {
    public static void main(String[] args) {
        // 음식점 DAO 객체 생성
        RestaurantDAO restaurantDAO = new RestaurantDAO();

        // 음식점 검색 테스트
        try { 
            List<Restaurant> searchedRestaurants = restaurantDAO.searchRestaurants("한식당");
        
            if (searchedRestaurants != null) {
                for (Restaurant restaurant : searchedRestaurants) {
                    System.out.println(restaurant.getName()); // 예시: 음식점 이름을 출력
                }
            } else {
                System.out.println("음식점 검색 실패");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("\n음식점 상세정보 조회 테스트");
        float latitude = 37.1234f;
        float longitude = 127.5678f;
        try{
            Restaurant restaurantInWishlist = restaurantDAO.getRestaurantsInWishlist(latitude, longitude);
        
            if (restaurantInWishlist != null) {
                System.out.println("음식점 이름: " + restaurantInWishlist.getName());
                System.out.println("음식점 이름: " + restaurantInWishlist.getAddress());
            } else {
            System.out.println("음식점 상세정보 조회 실패");
            }
        } catch(Exception e) {
            e.printStackTrace();
            }
        
     // Wishlist 조회 테스트
        System.out.println("\nWishlist 조회 테스트");
        int wishlistId = 1;
        try{
            List<Restaurant> restaurantsInWishlist = restaurantDAO.getRestaurantsInWishlist(wishlistId);
        
        if (restaurantsInWishlist != null) {
            for (Restaurant restaurant : restaurantsInWishlist) {
                System.out.println("음식점 이름: " + restaurant.getName());
            }
        } else {
            System.out.println("Wishlist 조회 실패");
        }
        } catch(Exception e) {
            e.printStackTrace();
            }
        
        System.out.println("\nWishlist에 음식점 추가 테스트");
        int addedRestaurantId = 6; // 특정한 음식점 ID 값
            restaurantDAO.addRestaurantToWishlist(wishlistId, addedRestaurantId);
        
        System.out.println("\nWishlist에서 음식점 삭제 테스트");
        int removedRestaurantId = 6; // 위에서 추가한 음식점 ID 값
        restaurantDAO.removeRestaurantFromWishlist(wishlistId, removedRestaurantId);
    }
}