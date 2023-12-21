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

public class UpdateMyRestaurantController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(UpdateMyRestaurantController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/* 로그인 확인 */
		HttpSession session = request.getSession();
		Object customerIdObject = session.getAttribute(UserSessionUtils.USER_SESSION_KEY);
		String customerId = customerIdObject.toString();
		if (customerId == null || customerId.isEmpty()) {
			return "/login.jsp";
		}
		
		/* GET request: My Restaurant 수정 form 요청 */
		if (request.getMethod().equals("GET")) {
			log.debug("My Restaurant UpdateForm Request");
			
			String id = request.getParameter("id");
			MyRestaurantDAO MyRestaurantDAO = new MyRestaurantDAO();
			
			My_restaurant mr = MyRestaurantDAO.getMyRestaurantById(Integer.parseInt(id));
			
			if (mr == null) {
				request.setAttribute("ResultCode", 0);
			} else {
				request.setAttribute("ResultCode", 1);
				request.setAttribute("mr", mr);
			}
			
			return "/ModifyMyRestaurant.jsp";
		}
		
		
		
		/* POST request: My restaurant 정보를 수정 */
		String score = request.getParameter("score");
		String memo = request.getParameter("memo");
		String mrId = request.getParameter("mrId");
		
		MyRestaurantDAO MyRestaurantDAO = new MyRestaurantDAO();
		
		int result = MyRestaurantDAO.updateMyRestaurant(Integer.parseInt(score), memo, Integer.parseInt(mrId));
		
		return "redirect:/myRestaurant/list";
	}

}
