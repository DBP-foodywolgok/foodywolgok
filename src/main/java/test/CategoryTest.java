package test;

import java.sql.SQLException;
import model.Category;
import model.dao.CategoryDAO;

public class CategoryTest {

    public static void main(String[] args) {
        

    	// 고정된 카테고리 등록 
        Category[] categories = {
            new Category(1, "한식"),
            new Category(2, "중식"),
            new Category(3, "양식"),
            new Category(4, "퓨전요리"),
            new Category(5, "태국식"),
            new Category(6, "샐러드"),
            new Category(7, "죽"),
            new Category(8, "디저트"),
            new Category(9, "음료")
        };

        CategoryDAO categoryDAO = new CategoryDAO(); // Create an instance of CategoryDAO

        try {
            for (Category category : categories) {
                int result = categoryDAO.createCategory(category); // Add each category to the database
                if (result > 0) {
                    System.out.println("Category added successfully: " + category);
                } else {
                    System.out.println("Failed to add category: " + category);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
