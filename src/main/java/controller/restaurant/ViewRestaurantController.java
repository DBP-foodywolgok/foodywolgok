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
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Restaurant restaurant = restaurantDAO.getRestaurantById(id);
            System.out.println("id확인 : " + id);
            System.out.println("restaurant확인 : " + restaurant);
            request.setAttribute("restaurant", restaurant);
            
            boolean isInWishlist = restaurantDAO.isRestaurantInWishlist(restaurant.getRestaurant_id());
            request.setAttribute("isInWishlist", isInWishlist);
            System.out.println("isInWishlist확인 : " + isInWishlist);
            
            return "/MapDetailsView.jsp";
        } catch (NumberFormatException e) {
            // 숫자로 변환할 수 없는 경우의 예외 처리
            System.out.println("유효하지 않은 ID입니다: " + e.getMessage());
            return "redirect:/restaurant/map";
        } catch (Exception e) {
            System.out.println("음식점 상세 정보를 가져오는 중 오류 발생: " + e.getMessage());
            return "redirect:/restaurant/map";
        }
    }

}
