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
		/* GET request: My Restaurant 등록 form 요청 */
		if (request.getMethod().equals("GET")) {
			log.debug("My Restaurant RegisterForm Request");
			
			return "/AddMyRestaurant.jsp";
		}
		
		HttpSession session = request.getSession();
		String customerId = (String) session.getAttribute(UserSessionUtils.USER_SESSION_KEY);
		
		MyRestaurantDAO MyRestaurantDAO = new MyRestaurantDAO();
		
		/* POST request: My restaurant 정보를 DB에 저장 */
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String score = request.getParameter("score");
		String categoryId = request.getParameter("category");
		String memo = request.getParameter("memo");
		
		// 현재 날짜와 시간 구하기
		LocalDateTime currentDateTime = LocalDateTime.now();
		Date date = Date.valueOf(currentDateTime.toLocalDate());
		
		// 사용자가 입력한 식당일 경우
		My_restaurant newMR = new My_restaurant(name, address, Integer.parseInt(score), memo, date,
				Integer.parseInt(customerId), Integer.parseInt(categoryId));
		
		int result = MyRestaurantDAO.insertMyRestaurantByUser(newMR);
		
		if (result > 0) {
			return "redirect:/myRestaurant/list";
		}
		
		return "redirect:/myRestaurant/list";
	}
}
