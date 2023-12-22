package controller.restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.customer.UserSessionUtils;
import model.Restaurant;
import model.Wishlist;
import model.dao.RestaurantDAO;

public class RestaurantController implements Controller {
    private RestaurantDAO restaurantDAO = new RestaurantDAO();
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            HttpSession session = request.getSession();
            int customerId = (int) session.getAttribute(UserSessionUtils.USER_SESSION_KEY);
            
            // (1) 위시리스트 검색
            List<Wishlist> wishlists = restaurantDAO.getWishlistByCustomerId(customerId);
            
            // (2) 위시리스트의 레스토랑 ID들을 찾아옴
            Set<Integer> restaurantIds = new HashSet<>(); // Set을 사용하여 중복된 값 방지
            for (Wishlist wishlist : wishlists) {
                int wishlistId = wishlist.getWishlist_id();
                List<Integer> wishlistRestaurantIds = restaurantDAO.getRestaurantIdsByWishlistId(wishlistId);
                restaurantIds.addAll(wishlistRestaurantIds); // 중복 없이 추가
                System.out.println("Wishlist ID: " + wishlistId + ", Restaurant IDs: " + wishlistRestaurantIds);
            }
            System.out.println("Unique Restaurant IDs: " + restaurantIds);

            Set<Integer> uniqueRestaurantIds = new HashSet<>(restaurantIds);
            restaurantIds.clear();
            restaurantIds.addAll(uniqueRestaurantIds);

            System.out.println("Unique Restaurant IDs: " + restaurantIds);

            List<Restaurant> restaurants = new ArrayList<>();
            for (int restaurantId : restaurantIds) {
                Restaurant restaurant = restaurantDAO.getRestaurantById(restaurantId);
                boolean isDuplicate = false;
                for (Restaurant existingRestaurant : restaurants) {
                    if (existingRestaurant != null && existingRestaurant.getRestaurant_id() == restaurantId) {
                        isDuplicate = true;
                        break;
                    }
                }
                if (restaurant != null && !isDuplicate) {
                    restaurants.add(restaurant);
                }
            }

            System.out.println("Final Restaurants: " + restaurants);

            request.setAttribute("restaurants", restaurants);
            

            return "/MapMainView.jsp";

        } catch (NumberFormatException e) {
            // 숫자로 변환할 수 없는 경우의 예외 처리
            System.out.println("오류 발생됨: " + e.getMessage());
            return "redirect:/restaurant/map";
        } catch (Exception e) {
            System.out.println("로그인이 되어있지 않습니다." + e.getMessage());
            return "redirect:/restaurant/map";
        }
    }
}
