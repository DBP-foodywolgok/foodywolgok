package controller.myrestaurant;

import java.sql.Date;
import java.time.LocalDateTime;
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

public class RegisterMyRestaurantController implements Controller {
	private static final Logger log = LoggerFactory.getLogger(RegisterMyRestaurantController.class);
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/* 로그인 확인 */
		HttpSession session = request.getSession();
		Object customerIdObject = session.getAttribute(UserSessionUtils.USER_SESSION_KEY);
		String customerId = customerIdObject.toString();
		if (customerId == null || customerId.isEmpty()) {
			return "/login.jsp";
		}
		
		/* GET request: My Restaurant 등록 form 요청 */
		if (request.getMethod().equals("GET")) {
			log.debug("My Restaurant RegisterForm Request");
			
			String pId = request.getParameter("id");
			String pName = request.getParameter("name");
			String pAddress = request.getParameter("address");
			String pCategory = request.getParameter("category");
			
			if (pId != null && pName != null && pAddress != null && pCategory != null) {
				request.setAttribute("id", pId);
				request.setAttribute("name", pName);
				request.setAttribute("address", pAddress);
				request.setAttribute("category", pCategory);
			}
			
			return "/AddMyRestaurant.jsp";
		}
		
		
		
		/* POST request: My restaurant 정보를 DB에 저장 */
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String score = request.getParameter("score");
		String categoryId = request.getParameter("category");
		String memo = request.getParameter("memo");
		String restaurantId = request.getParameter("restaurantId");
		// 현재 날짜와 시간 구하기
		LocalDateTime currentDateTime = LocalDateTime.now();
		Date date = Date.valueOf(currentDateTime.toLocalDate());
		
		MyRestaurantDAO MyRestaurantDAO = new MyRestaurantDAO();
		
		// 등록 방법 확인
		String registerType = request.getParameter("type");
		if (registerType.equals("0")) { // 1. DB에 있는 식당을 입력한 경우
			My_restaurant newMR = new My_restaurant();
			newMR.setRestaurantId(Integer.parseInt(restaurantId));
			newMR.setScore(Integer.parseInt(score));
			newMR.setCategoryId(Integer.parseInt(categoryId));
			newMR.setMemo(memo);
			newMR.setCustomerId(Integer.parseInt(customerId));
			newMR.setCreated_at(date);
			
			int result = MyRestaurantDAO.insertMyRestaurantByRes(newMR);
			if (result > 0) {
				return "redirect:/myRestaurant/list";
			}
			
		} else if (registerType.equals("1")) { // 2. 사용자가 직접 식당을 입력한 경우
			My_restaurant newMR = new My_restaurant();
			newMR.setName(name);
			newMR.setAddress(address);
			newMR.setScore(Integer.parseInt(score));
			newMR.setCategoryId(Integer.parseInt(categoryId));
			newMR.setMemo(memo);
			newMR.setCustomerId(Integer.parseInt(customerId));
			newMR.setCreated_at(date);
						
			int result = MyRestaurantDAO.insertMyRestaurantByUser(newMR);
			if (result > 0) {
				return "redirect:/myRestaurant/list";
			}
			
		}
		
		return "/myRestaurant/list";
	}
}
