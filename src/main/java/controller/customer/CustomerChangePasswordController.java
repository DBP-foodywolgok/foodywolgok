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

public class CustomerChangePasswordController implements Controller {

	private CustomerDAO customerDAO = new CustomerDAO();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String email = request.getParameter("wantPassword");

		HttpSession session = request.getSession();
		int customerId = (int) session.getAttribute(UserSessionUtils.USER_SESSION_KEY);

		try {
			String password = customerDAO.updatePassword(customerId, email);

			// 이메일을 통해 찾은 비밀번호를 resultEmail에 설정
			request.setAttribute("changedPassword", password);

			// 반환할 뷰 페이지의 경로 설정
			return "/ChangePassword.jsp"; // 이 부분은 실제 반환하는 뷰 페이지 경로로 수정해야 합니다.

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
