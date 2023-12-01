package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Category;
import model.Restaurant;

public class RecommendationDAO {

//    private JDBCUtil jdbcUtil;
//
//    public RecommendationDAO() {
//        jdbcUtil = new JDBCUtil();
//    }
//
//    public List<Restaurant> getRecommendedRestaurantsForCategories(List<String> categories) {
//        List<Restaurant> recommendedRestaurants = new ArrayList<>();
//
//        String sql = "SELECT * FROM (";
//        for (int i = 0; i < categories.size(); i++) {
//            if (i != 0) {
//                sql += " UNION ALL ";
//            }
//            sql += "(SELECT * FROM Restaurant WHERE category_id = (SELECT category_id FROM Category WHERE name = ?) FETCH FIRST 3 ROWS ONLY)";
//        }
//        sql += ")";
//
//        try {
//            PreparedStatement pstmt = ((Statement) jdbcUtil).getConnection().prepareStatement(sql);
//            int paramIndex = 1;
//            for (String category : categories) {
//                pstmt.setString(paramIndex++, category);
//            }
//
//            ResultSet rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//            	  int restaurantId = rs.getInt("restaurant_id");
//            	    String introduction = rs.getString("introduction");
//            	    float latitude = rs.getFloat("latitude");
//            	    float longitude = rs.getFloat("longitude");
//            	    String name = rs.getString("name");
//            	    String address = rs.getString("address");
//            	    
//            	
//            	    // Create a new Restaurant object and set its attributes
//            	    Restaurant restaurant = new Restaurant(restaurantId,introduction, latitude, longitude, name, address);
//            	    // Add the created Restaurant object to the recommendedRestaurants list
//            	    recommendedRestaurants.add(restaurant);
//            }
//            pstmt.close();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            jdbcUtil.close();
//        }
//
//        return recommendedRestaurants;
//    }
}