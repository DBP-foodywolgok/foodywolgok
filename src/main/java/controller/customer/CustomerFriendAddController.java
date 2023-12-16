package controller.customer;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.dao.CustomerDAO;


import controller.Controller;

public class CustomerFriendAddController implements Controller {

	  private CustomerDAO customerDAO = new CustomerDAO();

	    @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    	
	        String email = request.getParameter("friendEmail");
	        System.out.println("Received friendEmail: " + email);

	        
	        HttpSession session = request.getSession();
	        int customerId = (int) session.getAttribute(UserSessionUtils.USER_SESSION_KEY);

	        try {
	           
	            boolean isSuccess = customerDAO.addFriend(customerId, email);

	            if (isSuccess) {
	                return "redirect:/customer/FriendList";
	            } else {
	                return "redirect:/customer/mypage";
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw e;
	        }
	    
	    }
	    	
	 
}
