package controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Customer;
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
        // Add other fields as needed

        // Create a Customer object from the received information
        Customer newCustomer = new Customer(email, password, name);

        CustomerDAO customerDAO = new CustomerDAO();
        int result = customerDAO.createCustomer(newCustomer); // Save customer info to the database

        if (result > 0) {
            // Successful registration: Redirect to the login page
            return "redirect:/customer/loginPage";
        } else {
            // Registration failed: Redirect to the registration page with an error message
            return "/MemberJoin.jsp?error=registration_failed";
        }
    }
}