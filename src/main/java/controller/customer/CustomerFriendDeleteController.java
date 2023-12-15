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

		// 선택된 친구 아이디 가져오기 (여러 개 선택 가능할 경우 배열 등으로 처리)
		String[] selectedFriendIds = request.getParameterValues("selectedFriends");
		
		if (selectedFriendIds != null) {
			for (String friendId : selectedFriendIds) {
				// 친구 삭제 수행
				boolean deleted = customerDAO.deleteFriend(customerId, Integer.parseInt(friendId));
				
				if (deleted) {
				   System.out.println("성공");
				} else {
					// 삭제 실패 시의 추가 로직
					// 예) 실패 메시지, 에러 처리 등
					System.out.println("실패");
				}
			}
		}
		// 삭제 후 다시 친구 목록 화면으로 이동
		return "redirect:/customer/friendList";
	}
}