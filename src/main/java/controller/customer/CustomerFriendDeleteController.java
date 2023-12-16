package controller.customer;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Customer;
import model.dao.CustomerDAO;


import controller.Controller;


public class CustomerFriendDeleteController implements Controller {
    
    private CustomerDAO customerDAO = new CustomerDAO();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        int customerId = (int) session.getAttribute(UserSessionUtils.USER_SESSION_KEY);

        String[] selectedFriendIds = request.getParameterValues("selectedFriends");

        if (selectedFriendIds != null) {
            for (String friendId : selectedFriendIds) {
                boolean deleted = customerDAO.deleteFriend(customerId, Integer.parseInt(friendId));
                if (deleted) {
                    System.out.println("성공");
                } else {
                    System.out.println("실패");
                }
            }
        }
        return "redirect:/customer/FriendList";
    }
}