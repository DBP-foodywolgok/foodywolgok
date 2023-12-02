package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
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