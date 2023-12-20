package controller.customer;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Customer;
import model.Restaurant;
import model.dao.CustomerDAO;


import controller.Controller;


public class CustomerRecommendationController implements Controller {
	
	  private CustomerDAO customerDAO = new CustomerDAO();

	    @Override
	   
	    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      
	    	  HttpSession session = request.getSession();
	          int customerId = (int) session.getAttribute(UserSessionUtils.USER_SESSION_KEY); // 세션에서 ID 가져오기

	          try {
	              // 만약 로그인된 사용자 ID가 없다면 로그인 페이지로 리다이렉트하도록 처리할 수 있습니다.
	              if (customerId == 0) { // ID가 0인 경우에도 로그인되지 않은 것으로 판단합니다. 적절한 조건을 사용해주세요.
	                  return "redirect:/login"; // 로그인 페이지 URL로 리다이렉트
	              }
	              
	          
	              List<Map<String, String>> favoriteCategories = customerDAO.getFavoriteCategoriesListByCustomerId(customerId);
	              request.setAttribute("favoriteCategories", favoriteCategories);
	              
	            List<Integer> ids =   customerDAO.getCustomerFavoriteCategoryIds(customerId);
	              
	    
	            List<Restaurant> category1 = customerDAO.getCategoryRestaurant(ids.get(0));
	            List<Restaurant> category2 = customerDAO.getCategoryRestaurant(ids.get(1)); // categoryId2 대신 ids.get(1) 사용
	            List<Restaurant> category3 = customerDAO.getCategoryRestaurant(ids.get(2)); // categoryId3 대신 ids.get(2) 사용
	  
	            
	            
	              
	              // Store the category lists in the session
	              session.setAttribute("category1", category1);
	              session.setAttribute("category2", category2);
	              session.setAttribute("category3", category3);
	              // 회원 정보 페이지로 이동
	              return "/Recommendation.jsp";
	          } catch (Exception e) {
	              e.printStackTrace();
	              throw e; // 예외를 다시 throw하여 서블릿 컨테이너가 예외를 처리하도록 전달
	          }
	    }

}
