package controller.myrestaurant;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.customer.UserSessionUtils;
import model.dao.MyRestaurantDAO;

public class FindRestaurantController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(FindRestaurantController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/* 로그인 확인 */
		HttpSession session = request.getSession();
		Object customerIdObject = session.getAttribute(UserSessionUtils.USER_SESSION_KEY);
		String customerId = customerIdObject.toString();
		if (customerId == null || customerId.isEmpty()) {
			return "/login.jsp";
		}
		
		/* GET request: Restaurant 검색창 요청 */
		if (request.getMethod().equals("GET")) {
			log.debug("My Restaurant RegisterForm Request");
			
			return "/FindRestaurant.jsp";
		}
		
		/* POST request: Restaurant 검색 결과 */
		String keyword = request.getParameter("keyword");
		MyRestaurantDAO MyRestaurantDAO = new MyRestaurantDAO();
		
		List<String[]> list = MyRestaurantDAO.findRestaurant(keyword);
		
		if (list.isEmpty()) {
			request.setAttribute("ResultCode", 0);
		} else {
			request.setAttribute("ResultCode", 1);
			request.setAttribute("list", list);
		}
		
		return "/FindRestaurant.jsp";
	}
	
}
