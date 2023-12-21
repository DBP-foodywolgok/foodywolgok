package controller.restaurant;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.customer.UserSessionUtils;
import model.Restaurant;
import model.Wishlist;
import model.dao.RestaurantDAO;

public class WishlistUpdateController implements Controller {
    private final RestaurantDAO restaurantDAO = new RestaurantDAO();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            request.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession();
            int customerId = (int) session.getAttribute(UserSessionUtils.USER_SESSION_KEY);
            String name = request.getParameter("name");
            String memo = request.getParameter("memo");
            String color = request.getParameter("color");
            Date currentDate = new java.sql.Date(System.currentTimeMillis());

            System.out.println("customerId: " + customerId);
            
            Wishlist newWishlist = new Wishlist();
            newWishlist.setCustomer_id(customerId);
            newWishlist.setName(name);
            newWishlist.setMemo(memo);
            newWishlist.setCreated_at(currentDate);
            newWishlist.setColor(color);

            System.out.println("newWishlist: " + newWishlist.getColor() + newWishlist.getCreated_at());
            restaurantDAO.createWishlist(newWishlist);
            
            List<Wishlist> wishlist = restaurantDAO.getWishlistByCustomerId(customerId);
            request.setAttribute("wishlist", wishlist);
            
            return "/ViewWishlist.jsp";
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