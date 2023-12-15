package controller.customer;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Customer;
import model.dao.CustomerDAO;


import controller.Controller;

public class CustomerFriendAddController implements Controller {
	
    private CustomerDAO customerDAO = new CustomerDAO();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        int customerId = (int) session.getAttribute(UserSessionUtils.USER_SESSION_KEY); // 세션에서 ID 가져오기

        // 이메일 받아오기
        String email = request.getParameter("email");

        // 이메일이 비어 있거나 null인지 확인
        if (email == null || email.isEmpty()) {
            // 이메일이 없는 경우 처리
            return "error_view"; // 적절한 에러 뷰 리턴
        }

        // 친구 추가 처리
        boolean isSuccess = customerDAO.addFriend(customerId, email);

        if (isSuccess) {
            // 친구 추가 성공 시
            return "friend_added_view"; // 친구 추가 완료 뷰 리턴
        } else {
            // 친구 추가 실패 시 (사용자를 찾을 수 없는 경우)
            return "friend_not_found_view"; // 친구를 찾을 수 없는 에러 뷰 리턴
        }
    }
}