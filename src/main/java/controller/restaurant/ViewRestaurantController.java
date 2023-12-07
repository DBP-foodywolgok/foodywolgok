package controller.restaurant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Restaurant;
import model.dao.RestaurantDAO;

public class ViewRestaurantController implements Controller {
    private RestaurantDAO restaurantDAO = new RestaurantDAO();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        float latitude = Float.parseFloat(request.getParameter("latitude"));
        float longitude = Float.parseFloat(request.getParameter("longitude"));

        try {
            Restaurant restaurant = restaurantDAO.getRestaurantByLocation(latitude, longitude);
            request.setAttribute("restaurant", restaurant);
            return "/MapDetailsView.jsp";
        } catch (Exception e) {
            System.out.println("음식점 상세 정보를 가져오는 중 오류 발생: " + e.getMessage());
            return "redirect:/restaurant/map";
        }
    }
}
