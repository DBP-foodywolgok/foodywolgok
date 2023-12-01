package test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import model.Customer;
import model.dao.CustomerDAO;
import model.dao.CategoryDAO;

public class CustomerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 고객 회원가입 
//		Customer customer = new Customer();
//	
//		    
//	        customer.setCustomer_id(1); // 고객 ID 설정 (고유한 값)
//	        customer.setEmail("1234@naver.com"); // 이메일 설정
//	        customer.setPassword("password123"); // 비밀번호 설정
//	        customer.setName("Jen"); // 이름 설정
//	        
//	        List<String> selectedCategories = Arrays.asList("한식", "양식", "중식");
//	        customer.setFavoriteCategories(selectedCategories); // 고객이 선택한 카테고리 정보 설정
//
//	        // CustomerDAO 인스턴스 생성
	        CustomerDAO customerDAO = new CustomerDAO();
//
//	        try {
//	            int result = customerDAO.createCustomer(customer); // 고객 추가
//
//	            if (result > 0) {
//	                System.out.println("Customer 정보가 성공적으로 추가되었습니다.");
//
//	                // 고객이 선택한 카테고리 정보를 customer_Category 테이블에 추가
//	                for (String category : selectedCategories) {
//	                    int categoryId = getCategoryIDByName(category); // 카테고리 이름으로부터 ID를 가져옴 (메서드 구현 필요)
//	                    int customerId = customer.getCustomer_id(); // 추가한 고객의 ID 가져옴
//
//	                    // Customer_Category 테이블에 추가
//	                    int categoryResult = customerDAO.addCustomerCategory(categoryId, customerId);
//
//	                    if (categoryResult > 0) {
//	                        System.out.println("Customer_Category 정보가 성공적으로 추가되었습니다.");
//	                    } else {
//	                        System.out.println("Customer_Category 정보 추가에 실패했습니다.");
//	                    }
//	                }
//	            } else {
//	                System.out.println("Customer 정보 추가에 실패했습니다.");
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	
//	
//	    
	Customer customer2 = new Customer();
	
    
    customer2.setCustomer_id(1); // 고객 ID 설정 (고유한 값)
    customer2.setEmail("1234@naver.com"); // 이메일 설정
    customer2.setPassword("password123"); // 비밀번호 설정
    customer2.setName("Jimin"); // 이름 설정

    // CustomerDAO 인스턴스 생성

    try {
        // CustomerDAO를 사용하여 생성된 고객 정보를 DB에 추가
        int result = customerDAO.createCustomer(customer2);
        if (result > 0) {
            System.out.println("Customer 정보가 성공적으로 추가되었습니다.");
        } else {
            System.out.println("Customer 정보 추가에 실패했습니다.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
//
//
//
//Customer customer3 = new Customer();
//customer3.setCustomer_id(1); // 고객 ID 설정 (고유한 값)
//customer3.setEmail("1234@naver.com"); // 이메일 설정
//customer3.setPassword("password123"); // 비밀번호 설정
//customer3.setName("Jihee"); // 이름 설정
//
//// CustomerDAO 인스턴스 생성
//
//try {
//    // CustomerDAO를 사용하여 생성된 고객 정보를 DB에 추가
//    int result = customerDAO.createCustomer(customer3);
//    if (result > 0) {
//        System.out.println("Customer 정보가 성공적으로 추가되었습니다.");
//    } else {
//        System.out.println("Customer 정보 추가에 실패했습니다.");
//    }
//} catch (SQLException e) {
//    e.printStackTrace();
//}
//
//    // 
//}
}
}





	

