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

public class CustomerFindPasswordController implements Controller {

	private CustomerDAO customerDAO = new CustomerDAO();

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String email = request.getParameter("findPasswordByEmail");

		try {
			String password = customerDAO.findPasswordByEmail(email);

			// 이메일을 통해 찾은 비밀번호를 resultEmail에 설정
			request.setAttribute("resultEmail", password);

			// 반환할 뷰 페이지의 경로 설정
			return "/FindPassword.jsp"; // 이 부분은 실제 반환하는 뷰 페이지 경로로 수정해야 합니다.

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
