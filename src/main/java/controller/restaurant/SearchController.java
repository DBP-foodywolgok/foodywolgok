package controller.restaurant;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Restaurant;
import model.dao.CustomerDAO;
import model.dao.RestaurantDAO;

public class SearchController implements Controller{
    private RestaurantDAO restaurantDAO = new RestaurantDAO();
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        String keyword = request.getParameter("searchKeyword");
        
        try {
            List<Restaurant> searchedRestaurants = restaurantDAO.searchRestaurants(keyword);
            
            request.setAttribute("searchedRestaurants", searchedRestaurants);


            return "/MapSearchView.jsp";
        }catch (Exception e) {
            System.out.println("오류 발생: " + e.getMessage());
            return "redirect:/restaurant/map";
        }
    }
    

}