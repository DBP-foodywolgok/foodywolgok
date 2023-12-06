package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Category;
import model.Customer;
import model.Customer_Category;

public class CategoryDAO {
	
	
    private JDBCUtil jdbcUtil = null;

    public CategoryDAO() {
        jdbcUtil = new JDBCUtil();
    }


    public int addCustomerCategory(int categoryId, int customerId) throws SQLException {
        String sql = "INSERT INTO Customer_Category VALUES (?, ?)";
        jdbcUtil.setSqlAndParameters(sql, new Object[]{categoryId, customerId});

        try {
            int result = jdbcUtil.executeUpdate();
            return result;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }
        return 0;
    }
    public Category getCategoryByName(String categoryName) {
        String sql = "SELECT * FROM Category WHERE name = ?";
        jdbcUtil.setSqlAndParameters(sql, new Object[]{categoryName});

        try {
            ResultSet rs = jdbcUtil.executeQuery();
            if (rs.next()) {
                int categoryId = rs.getInt("category_id");
                String name = rs.getString("name");
                // 필요한 다른 필드 정보 가져오기

                Category category = new Category(categoryId, name);
                // 필요한 다른 필드 설정

                return category;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close();
        }

        return null; // 해당하는 카테고리가 없을 경우 null 반환
    }
    
    // 기존 코드와 동일한 부분은 생략했습니다.

    // 모든 카테고리를 가져오는 메서드
    public List<Category> getAllCategories() {
        String sql = "SELECT * FROM Category"; // Category 테이블에서 모든 카테고리를 가져오는 쿼리
        jdbcUtil.setSqlAndParameters(sql, null);

        try {
            ResultSet rs = jdbcUtil.executeQuery(); // 쿼리 실행
            List<Category> categories = new ArrayList<>();

            while (rs.next()) {
                int categoryId = rs.getInt("category_id");
                String categoryName = rs.getString("name");

                // Category 객체 생성 후 리스트에 추가
                Category category = new Category(categoryId, categoryName);
                categories.add(category);
            }

            return categories; // 모든 카테고리를 담은 리스트 반환

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            jdbcUtil.close();
        }

        return null; // 오류 발생 시 null 반환
    }



    public int getCategoryIdByName(String categoryName) throws SQLException {
        int categoryId = 0;
        String sql = "SELECT category_id FROM Category WHERE name = ?";
        jdbcUtil.setSqlAndParameters(sql, new Object[]{categoryName});

        try {
            ResultSet rs = jdbcUtil.executeQuery();
            if (rs.next()) {
                categoryId = rs.getInt("category_id");
            }
            return categoryId;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            jdbcUtil.close();
        }
        return categoryId;
    }

 
    public int createCategory(Category category) throws SQLException {
        String sql = "INSERT INTO Category VALUES (category_seq.nextval, ?)";
        jdbcUtil.setSqlAndParameters(sql, new Object[]{category.getName()});

        try {
            int result = jdbcUtil.executeUpdate();
            return result;
        } catch (Exception ex) {
        	jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
        	jdbcUtil.commit();
            jdbcUtil.close();
        }
        return 0;
    }
}