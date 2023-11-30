package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Restaurant;

public class RestaurantDAO {
    private JDBCUtil jdbcUtil = null;
    
    public RestaurantDAO() {               
        jdbcUtil = new JDBCUtil();
    }
    
    //음식점 검색
    public List<Restaurant> searchRestaurants(String keyword) {
        ResultSet rs = null;
        List<Restaurant> restaurants = new ArrayList<>();

        StringBuilder query = new StringBuilder();
        query.append("SELECT restaurant_id, category_id, introduction, latitude, longitude, name, address ");
        query.append("FROM restaurant ");
        query.append("WHERE name LIKE ? OR address LIKE ?");

        try {
            jdbcUtil.setSqlAndParameters(query.toString(), new Object[]{"%" + keyword + "%", "%" + keyword + "%"}); // 검색어를 포함하는 음식점 검색
            rs = jdbcUtil.executeQuery();
            while (rs.next()) {
                int restaurantId = rs.getInt("restaurant_id");
                int categoryId = rs.getInt("category_id");
                String introduction = rs.getString("introduction");
                float latitude = rs.getFloat("latitude");
                float longitude = rs.getFloat("longitude");
                String name = rs.getString("name");
                String address = rs.getString("address");

                Restaurant restaurant = new Restaurant(restaurantId, categoryId, introduction, latitude, longitude, name, address);
                restaurants.add(restaurant);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close(); // ResultSet, PreparedStatement, Connection 등 해제
        }
        return restaurants;
    }

   
    //음식점 상세정보 조회
    //Restaurant 기본생성자 추가
    public Restaurant getRestaurantsInWishlist(float latitude,float longitude){
        ResultSet rs = null;
        Restaurant restaurant = null;
        
        StringBuilder query = new StringBuilder();
        query.append("SELECT restaurant_id, category_id, introduction, name, adress ");
        query.append("FROM restaurant ");
        query.append("WHERE latitude = ?, longitude = ?");
        
        try {
            jdbcUtil.setSqlAndParameters(query.toString(), new Object[]{latitude, longitude}); // JDBCUtil에 질의문과 파라미터 설정
            rs = jdbcUtil.executeQuery();
            if (rs.next()) {
                int restaurantId = rs.getInt("restaurant_id");
                int categoryId = rs.getInt("category_id");
                String introduction = rs.getString("introduction");
                String name = rs.getString("name");
                String address = rs.getString("address");

                restaurant = new Restaurant(restaurantId, categoryId, introduction, latitude, longitude, name, address);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                jdbcUtil.close();       // ResultSet, PreparedStatement, Connection 등 해제
            }
        return restaurant;        
    }
    
    //Wishlist 조회
    //Restaurant dto 수정함
    public List<Restaurant> getRestaurantsInWishlist(int wishlistId) {
        ResultSet rs = null;
        List<Restaurant> restaurants = new ArrayList<>();
        
        StringBuilder query = new StringBuilder();
        query.append("SELECT r.restaurant_id, r.category_id, r.introduction, r.latitude, r.longitude, r.name, r.adress FROM restaurant r");
        query.append("INNER JOIN restaurant_wishlist rw ON r.restaurant_id = rw.restaurant_id ");
        query.append("WHERE rw.wishlist_id = ?");

        try {
            jdbcUtil.setSqlAndParameters(query.toString(), new Object[]{wishlistId}); // JDBCUtil에 질의문과 파라미터 설정
            rs = jdbcUtil.executeQuery();
            while(rs.next()) { // 결과에서 레스토랑 정보 가져오기
                int restaurantId = rs.getInt("restaurant_id");
                int categoryId = rs.getInt("category_id");
                String introduction = rs.getString("introduction");
                float latitude = rs.getFloat("latitude");
                float longitude = rs.getFloat("longitude");
                String name = rs.getString("name");
                String address = rs.getString("address");

                // Restaurant 객체 생성 후 리스트에 추가
                Restaurant restaurant = new Restaurant(restaurantId, categoryId, introduction, latitude, longitude, name, address);
                restaurants.add(restaurant);
            }
            return restaurants;
            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                jdbcUtil.close();       // ResultSet, PreparedStatement, Connection 등 해제
            }
        return null;
    }
    
  //Wishlist에 음식점 추가
    public void addRestaurantToWishlist(int wishlistId, int restaurantId) {
        String insert = "INSERT INTO restaurant_wishlist (wishlist_id, restaurant_id) VALUES (?, ?)";
        try {
        jdbcUtil.setSqlAndParameters(insert.toString(), new Object[]{wishlistId, restaurantId}); // JDBCUtil에 질의문과 파라미터 설정
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();       // ResultSet, PreparedStatement, Connection 등 해제
        }
    }
    
 // Wishlist에서 음식점 삭제
    public void removeRestaurantFromWishlist(int wishlistId, int restaurantId) {
        String delete = "DELETE FROM restaurant_wishlist WHERE wishlist_id = ? AND restaurant_id = ?";
        try {
            jdbcUtil.setSqlAndParameters(delete.toString(), new Object[]{wishlistId, restaurantId}); // JDBCUtil에 질의문과 파라미터 설정
             } catch (Exception ex) {
                 jdbcUtil.rollback();
                 ex.printStackTrace();
             } finally {
                 jdbcUtil.commit();
                 jdbcUtil.close();       // ResultSet, PreparedStatement, Connection 등 해제
             }
    }
    
}