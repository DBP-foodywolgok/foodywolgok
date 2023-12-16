package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Restaurant;
import model.Wishlist;

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
    public Restaurant getRestaurantById(int restaurantId) {
        ResultSet rs = null;
        Restaurant restaurant = null;

        StringBuilder query = new StringBuilder();
        query.append("SELECT category_id, introduction, latitude, longitude, name, address ");
        query.append("FROM restaurant ");
        query.append("WHERE restaurant_id = ?");

        try {
            jdbcUtil.setSqlAndParameters(query.toString(), new Object[]{restaurantId});
            rs = jdbcUtil.executeQuery();
            if (rs.next()) {
                int categoryId = rs.getInt("category_id");
                String introduction = rs.getString("introduction");
                float latitude = rs.getFloat("latitude");
                float longitude = rs.getFloat("longitude");
                String name = rs.getString("name");
                String address = rs.getString("address");

                restaurant = new Restaurant(restaurantId, categoryId, introduction, latitude, longitude, name, address);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return restaurant;
    }
    
    //customerId에 해당하는 위시리스트 가져오기
    public List<Wishlist> getWishlistByCustomerId(int customerId) {
        ResultSet rs = null;
        List<Wishlist> wishlist = new ArrayList<>();
        StringBuilder query = new StringBuilder();
        query.append("SELECT wishlist_id, color, created_at, name, memo FROM WISHLIST WHERE customer_id = ?");
        
        try {
            jdbcUtil.setSqlAndParameters(query.toString(), new Object[]{customerId}); // JDBCUtil에 질의문과 파라미터 설정
            rs = jdbcUtil.executeQuery();
            
            while (rs.next()) {
                int wishlistId = rs.getInt("wishlist_id");
                String color = rs.getString("color");
                Date createdAt = rs.getDate("created_at");
                String name = rs.getString("name");
                String memo = rs.getString("memo");

                Wishlist item = new Wishlist();
                item.setWishlist_id(wishlistId);
                item.setColor(color);
                item.setCreated_at(createdAt);
                item.setCustomer_id(customerId);
                item.setName(name);
                item.setMemo(memo);

                wishlist.add(item);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return wishlist;
    }

    //Wishlistid로 음식점들 검색
    public List<Restaurant> getRestaurantsInWishlist(int wishlistId) {
        ResultSet rs = null;
        List<Restaurant> restaurants = new ArrayList<>();
        
        StringBuilder query = new StringBuilder();
        query.append("SELECT r.restaurant_id, r.category_id, r.introduction, r.latitude, r.longitude, r.name, r.address FROM restaurant r ");
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
        jdbcUtil.executeUpdate(); // Insert 쿼리 실행
        jdbcUtil.commit(); // 커밋
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();       // ResultSet, PreparedStatement, Connection 등 해제
        }
    }
    
 // Wishlist에서 음식점 삭제
    public void removeRestaurantFromWishlist(int wishlistId, int restaurantId) {
        String delete = "DELETE FROM restaurant_wishlist WHERE wishlist_id = ? AND restaurant_id = ?";
        try {
            jdbcUtil.setSqlAndParameters(delete.toString(), new Object[]{wishlistId, restaurantId}); // JDBCUtil에 질의문과 파라미터 설정
            jdbcUtil.executeUpdate(); // Delete 쿼리 실행
            jdbcUtil.commit(); // 커밋
        } catch (Exception ex) {
                 jdbcUtil.rollback();
                 ex.printStackTrace();
             } finally {
                 jdbcUtil.close();       // ResultSet, PreparedStatement, Connection 등 해제
             }
    }
    
    public List<Restaurant> getRestaurantsByCategory(String category_name) {
        ResultSet rs = null;
        List<Restaurant> restaurants = new ArrayList<>();

        StringBuilder query = new StringBuilder();

        query.append("SELECT r.restaurant_id, r.category_id, r.introduction, r.latitude, r.longitude, r.name, r.address FROM restaurant r ");
        query.append("INNER JOIN category c ON r.category_id = c.category_id ");
        query.append("WHERE c.name = ?");

        try {
            jdbcUtil.setSqlAndParameters(query.toString(), new Object[]{category_name}); // 검색어를 포함하는 음식점 검색
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
    
    
 // 음식점이 위시리스트에 있는지 확인하는 메서드
    public boolean isRestaurantInWishlist(int restaurantId) {
        ResultSet rs = null;
        boolean isRestaurantInWishlist = false;

        StringBuilder query = new StringBuilder();
        query.append("SELECT COUNT(*) AS count FROM restaurant_wishlist WHERE restaurant_id = ?");

        try {
            jdbcUtil.setSqlAndParameters(query.toString(), new Object[]{restaurantId});
            rs = jdbcUtil.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                isRestaurantInWishlist = (count > 0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return isRestaurantInWishlist;
    }
    
    //위시리스트에서 특정 음식점을 확인
    public boolean containsRestaurant(int wishlistId, int restaurantId) {
        ResultSet rs = null;
        boolean isRestaurantInWishlist = false;

        StringBuilder query = new StringBuilder();
        query.append("SELECT COUNT(*) AS count FROM restaurant_wishlist WHERE wishlist_id = ? AND restaurant_id = ?");

        try {
            jdbcUtil.setSqlAndParameters(query.toString(), new Object[]{wishlistId, restaurantId});
            rs = jdbcUtil.executeQuery();

            if (rs.next()) {
                int count = rs.getInt("count");
                isRestaurantInWishlist = (count > 0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return isRestaurantInWishlist;
    }



}
