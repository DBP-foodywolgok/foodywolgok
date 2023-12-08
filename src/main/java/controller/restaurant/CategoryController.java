package controller.restaurant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import controller.Controller;
import model.Restaurant;
import model.dao.RestaurantDAO;
import java.util.List;

public class CategoryController implements Controller {
    private RestaurantDAO restaurantDAO = new RestaurantDAO();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String category = request.getParameter("category");

        try {
            List<Restaurant> categoryRestaurants = restaurantDAO.getRestaurantsByCategory(category);
            request.setAttribute("categoryRestaurants", categoryRestaurants);
            return "/KindListView.jsp";
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return "redirect:/restaurant/map";
        }
    }
}
