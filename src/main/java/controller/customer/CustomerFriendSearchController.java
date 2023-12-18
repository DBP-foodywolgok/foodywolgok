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


public class CustomerFriendSearchController implements Controller {
    private CustomerDAO customerDAO = new CustomerDAO();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        int customerId = (int) session.getAttribute(UserSessionUtils.USER_SESSION_KEY);

        // DAO를 통해 해당 사용자의 친구 리스트 가져오기
        List<Customer> friendList = customerDAO.getFriends(customerId);

        request.setAttribute("friendList", friendList); // JSP로 친구 리스트 전달

        return "/FriendList.jsp"; // 친구 리스트 뷰 반환
    }
}