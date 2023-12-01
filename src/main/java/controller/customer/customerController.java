package controller.customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import controller.Controller;
import model.Customer;
import model.dao.CustomerDAO;
import model.service.CustomerService;


public class customerController implements Controller {
	  private CustomerService customerService;
	  private static final Logger logger = LoggerFactory.getLogger(customerController.class);
	  
	  
	    public customerController() {
	        this.customerService = new CustomerService();
	    }
	    @Override
	    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    	String email = request.getParameter("inputEmail");
	    	String password = request.getParameter("inputPassword");
	    	String name = request.getParameter("inputName");
	    	
	    	 logger.info("Email: {}", email);
	         logger.info("Password: {}", password);
	         logger.info("Name: {}", name);

	        // CustomerService를 이용하여 회원가입 처리
	        boolean isRegistered = customerService.registerCustomer(email, password, name);

	        if (isRegistered) {
	            return "redirect:/login"; // 성공 시 로그인 페이지로 리다이렉트
	        } else {
	            // 실패 시 어떤 처리를 할지 결정
	            return "/MemberJoin"; // 실패 시 회원가입 페이지로 포워딩
	        }
	    }
}
