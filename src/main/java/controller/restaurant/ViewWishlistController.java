package controller.restaurant;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.customer.UserSessionUtils;
import model.Restaurant;
import model.Wishlist;
import model.dao.RestaurantDAO;

public class ViewWishlistController implements Controller {
    private RestaurantDAO restaurantDAO = new RestaurantDAO();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            HttpSession session = request.getSession();
            int customerId = (int) session.getAttribute(UserSessionUtils.USER_SESSION_KEY);
            List<Wishlist> wishlist = restaurantDAO.getWishlistByCustomerId(customerId);
            request.setAttribute("wishlist", wishlist);
            System.out.println("wishlist: " + wishlist);
            
            return "/ViewWishlist.jsp"; // 위시리스트 리스트를 보여줄 JSP
        } catch (NumberFormatException e) {
            // 숫자로 변환할 수 없는 경우의 예외 처리
            System.out.println("유효하지 않은 ID입니다: " + e.getMessage());
            return "redirect:/restaurant/map";
        } catch (Exception e) {
            System.out.println("로그인이 되어있지 않습니다." + e.getMessage());
            return "redirect:/restaurant/map";
        }
    }
}

