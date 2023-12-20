package controller.myrestaurant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.customer.UserSessionUtils;
import model.My_restaurant;
import model.dao.MyRestaurantDAO;

public class ViewMyRestaurantController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(ViewMyRestaurantController.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/* 로그인 확인 */
		HttpSession session = request.getSession();
		Object customerIdObject = session.getAttribute(UserSessionUtils.USER_SESSION_KEY);
		String customerId = customerIdObject.toString();
		if (customerId == null || customerId.isEmpty()) {
			return "/login.jsp";
		}
		
		/* GET request: My Restaurant View 요청 */
		log.debug("My Restaurant View Request");
		
		String id = request.getParameter("id");
		MyRestaurantDAO MyRestaurantDAO = new MyRestaurantDAO();
		
		My_restaurant mr = MyRestaurantDAO.getMyRestaurantById(Integer.parseInt(id));
		
		if (mr == null) {
			request.setAttribute("ResultCode", 0);
		} else {
			request.setAttribute("ResultCode", 1);
			request.setAttribute("mr", mr);
		}
		
		return "/MyRestaurantDetail.jsp";
	}

}
