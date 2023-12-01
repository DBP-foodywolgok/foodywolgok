package test;

import java.sql.SQLException;

import model.Customer;
import model.dao.CustomerDAO;

public class CustomerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Customer customer = new Customer("example@email.com", "password123", "John Doe");
	        customer.setCustomer_id(1); // 고객 ID 설정 (고유한 값)
	        customer.setEmail("1234@naver.com"); // 이메일 설정
	        customer.setPassword("password123"); // 비밀번호 설정
	        customer.setName("John Doe"); // 이름 설정

	        // CustomerDAO 인스턴스 생성
	        CustomerDAO customerDAO = new CustomerDAO();

	        try {
	            // CustomerDAO를 사용하여 생성된 고객 정보를 DB에 추가
	            int result = customerDAO.createCustomer(customer);
	            if (result > 0) {
	                System.out.println("Customer 정보가 성공적으로 추가되었습니다.");
	            } else {
	                System.out.println("Customer 정보 추가에 실패했습니다.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	}

