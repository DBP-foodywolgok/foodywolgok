package controller.customer;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Category;
import model.Customer;
import model.dao.CategoryDAO;
import model.dao.CustomerDAO;



import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;

public class CustomerRegisterController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // POST request (회원정보가 parameter로 전송됨)
        String name = request.getParameter("inputName");
        String email = request.getParameter("inputEmail");
        String password = request.getParameter("inputPassword");
        String selectedCategoriesString = request.getParameter("selectedCategories"); // 선택한 카테고리 문자열 받기

        // Create a Customer object from the received information
        Customer newCustomer = new Customer(email, password, name);

        CustomerDAO customerDAO = new CustomerDAO();
        int result = customerDAO.createCustomer(newCustomer); // Save customer info to the database

        if (result > 0) {
            // Get the ID of the registered customer
            int customerId = customerDAO.getCustomerIdByEmail(email);

            CategoryDAO categoryDAO = new CategoryDAO();
            List<Integer> categoryIds = new ArrayList<>(); 

            // Convert the selectedCategories string into an array
            String[] selectedCategories = selectedCategoriesString.split(",");
            
            // Get matching category IDs from the database
            for (String selectedCategory : selectedCategories) {
                Category category = categoryDAO.getCategoryByName(selectedCategory);
                if (category != null) {
                    categoryIds.add(category.getCategory_id()); // Add matching category ID to the list
                }
            }

            // Add the customer's selected categories to the Customer_Category table
            for (int categoryId : categoryIds) {
                customerDAO.addCustomerCategory(categoryId, customerId);
            }

            // Successful registration: Redirect to the login page
            return "redirect:/customer/loginPage";
        } else {
            // Registration failed: Redirect to the registration page with an error message
            return "/MemberJoin.jsp?error=registration_failed";
        }
    }
}