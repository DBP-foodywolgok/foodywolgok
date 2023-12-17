package controller.restaurant;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.customer.UserSessionUtils;
import model.Restaurant;
import model.Wishlist;
import model.dao.RestaurantDAO;

public class AddWishlistController implements Controller {
    private final RestaurantDAO restaurantDAO = new RestaurantDAO();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            int restaurant_id = Integer.parseInt(request.getParameter("restaurant_id"));
            Restaurant restaurant = restaurantDAO.getRestaurantById(restaurant_id);
            request.setAttribute("restaurant", restaurant);
            
            String[] wishlistIds = request.getParameterValues("wishlistIds");
            
            //사용자가 선택한 위시리스트에 음식점 추가
            if (wishlistIds != null) {
                List<Integer> selectedWishlists = new ArrayList<>();

                // 사용자가 선택한 위시리스트 ID를 가져옴
                for (String wishlistId : wishlistIds) {
                    selectedWishlists.add(Integer.parseInt(wishlistId));
                }

                // 선택한 위시리스트에 있는 음식점을 추가
                for (int wishlistId : selectedWishlists) {
                    restaurantDAO.addRestaurantToWishlist(wishlistId, restaurant_id);
                }

                // 모든 위시리스트에서 선택한 위시리스트를 제외한 음식점을 삭제
                HttpSession session = request.getSession();
                int customerId = (int) session.getAttribute(UserSessionUtils.USER_SESSION_KEY);
                List<Wishlist> allWishlists = restaurantDAO.getWishlistByCustomerId(customerId);
                for (Wishlist wishlist : allWishlists) {
                    if (!selectedWishlists.contains(wishlist.getWishlist_id())) {
                        restaurantDAO.removeRestaurantFromWishlist(wishlist.getWishlist_id(), restaurant_id);
                    }
                }

                // isInWishlist 전달
                boolean isInWishlist = restaurantDAO.isRestaurantInWishlist(restaurant_id);
                request.setAttribute("isInWishlist", isInWishlist);
            }
            return "/MapDetailsView.jsp";
        } catch (NumberFormatException e) {
            // 숫자로 변환할 수 없는 경우의 예외 처리
            System.out.println("유효하지 않은 ID입니다: " + e.getMessage());
            return "redirect:/restaurant/map";
        } catch (Exception e) {
            System.out.println("오류 발생: " + e.getMessage());
            return "redirect:/restaurant/map";
        }
    }
}
