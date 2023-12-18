package controller.myrestaurant;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import controller.customer.UserSessionUtils;
import model.My_restaurant;
import model.dao.MyRestaurantDAO;

public class ListMyRestaurantController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(ListMyRestaurantController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/* 로그인 확인 */
		HttpSession session = request.getSession();
		Object customerIdObject = session.getAttribute(UserSessionUtils.USER_SESSION_KEY);
		String customerId = customerIdObject.toString();
		if (customerId == null || customerId.isEmpty()) {
			return "/login.jsp";
		}
		
		/* GET request: My Restaurant List 요청 */
		log.debug("My Restaurant List Request");
		
		MyRestaurantDAO MyRestaurantDAO = new MyRestaurantDAO();
		
		List<My_restaurant> list = MyRestaurantDAO.getAllMyRestaurant(Integer.parseInt(customerId));
		
		if (list.isEmpty()) {
			request.setAttribute("ResultCode", 0);
		} else {
			request.setAttribute("ResultCode", 1);
			request.setAttribute("list", list);
		}
			
		return "/MyRestaurantList.jsp";
		
	}
	
}
