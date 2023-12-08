package controller.customer;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.Customer;
import model.dao.CustomerDAO;


import controller.Controller;

public class CustomerInformationController implements Controller {
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

            // CustomerDAO를 사용하여 사용자의 정보 가져오기
            Customer customer = customerDAO.getCustomerById(customerId);

            // 가져온 정보를 콘솔에 출력
            System.out.println("Customer 정보: " + customer);

            // 가져온 정보를 request에 저장하여 뷰 페이지로 전달
            request.setAttribute("customer", customer);

            // 회원 정보 페이지로 이동
            return "/MemberInformation.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            throw e; // 예외를 다시 throw하여 서블릿 컨테이너가 예외를 처리하도록 전달
        }
    }
}