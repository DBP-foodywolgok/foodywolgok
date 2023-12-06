package controller.customer;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.dao.CustomerDAO;


import controller.Controller;



public class CustomerLoginController implements Controller {
    private CustomerDAO customerDAO = new CustomerDAO();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String email = request.getParameter("inputEmail");
        String password = request.getParameter("inputPassword");

        HttpSession session = request.getSession();

        try {
            // 로그인 성공 여부 확인
            boolean isValidLogin = customerDAO.login(email, password);

            // 콘솔에 로그인 성공 여부 출력
            System.out.println("로그인 성공 여부: " + isValidLogin);

            if (isValidLogin) {
                // 사용자 ID 가져오기
                int customerId = customerDAO.getCustomerIdByEmail(email);

                // 사용자 정보를 세션에 저장
                session.setAttribute(UserSessionUtils.USER_SESSION_KEY, customerId);
             
               
                
                String csName = customerDAO.getCustomerNameById(customerId);
                
                session.setAttribute("customerName", csName);
                // 로그인 성공 시 Main.jsp로 이동
                return "redirect:/customer/main";
            } else {
                // 로그인 실패 시 로그인 페이지로 이동
                return "redirect:/customer/loginPage";
            }
        } catch (Exception e) {
            // 로그인 과정에서 예외 발생 시 로그를 남기고 로그인 페이지로 이동
            System.out.println("로그인 중 오류 발생: " + e.getMessage());
            return "redirect:/customer/loginPage";
        }
    }
}

