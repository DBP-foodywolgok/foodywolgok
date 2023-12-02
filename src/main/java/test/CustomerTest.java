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
		
		// 회원가입 
//	    Customer customer = new Customer();
//
//        customer.setEmail("mn2302@naver.com");
//        customer.setPassword("password12345");
//        customer.setName("Min");
//
//        List<String> selectedCategories = Arrays.asList("한식", "양식", "중식");
//        customer.setFavoriteCategories(selectedCategories);
//
//        CustomerDAO customerDAO = new CustomerDAO();
//        CategoryDAO categoryDAO = new CategoryDAO();
//
//        try {
//            int result = customerDAO.createCustomer(customer); // 고객 추가
//            int customerId = customerDAO.getCustomerIdByName(customer.getName());
//          
//            if (result > 0) {
//                System.out.println("Customer 정보가 성공적으로 추가되었습니다.");
//              
//                for (String category : selectedCategories) {
//                    int categoryId = categoryDAO.getCategoryIdByName(category); // 카테고리 ID 가져오기
//                     System.out.println(categoryId);
//                    // Customer_Category 테이블에 추가
//                    int categoryResult = categoryDAO.addCustomerCategory(categoryId, customerId);
//
//                    if (categoryResult > 0) {
//                        System.out.println("Customer_Category 정보가 성공적으로 추가되었습니다.");
//                    } else {
//                        System.out.println("Customer_Category 정보 추가에 실패했습니다.");
//                    }
//                }
//            } else {
//                System.out.println("Customer 정보 추가에 실패했습니다.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    
	
//	    
//	Customer customer2 = new Customer();
//	
//    
//    customer2.setCustomer_id(1); // 고객 ID 설정 (고유한 값)
//    customer2.setEmail("1234@naver.com"); // 이메일 설정
//    customer2.setPassword("password123"); // 비밀번호 설정
//    customer2.setName("Jimin"); // 이름 설정
//
//    // CustomerDAO 인스턴스 생성
//
//    try {
//        // CustomerDAO를 사용하여 생성된 고객 정보를 DB에 추가
//        int result = customerDAO.createCustomer(customer2);
//        if (result > 0) {
//            System.out.println("Customer 정보가 성공적으로 추가되었습니다.");
//        } else {
//            System.out.println("Customer 정보 추가에 실패했습니다.");
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
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
	
	  // 
	
	// 로그인 
		  CustomerDAO customerDAO = new CustomerDAO();
//	    String inputEmail = "glp0509@naver.com";
//	    String inputPassword = "password123";
//
//	    try {
//	        boolean isLoggedIn = customerDAO.login(inputEmail, inputPassword);
//	        if (isLoggedIn) {
//	            System.out.println("로그인이 완료되었습니다.");
//	        } else {
//	            System.out.println("정보를 잘못 입력하셨습니다.");
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	    
//	    // 비밀번호 찾기 
//	
//
//	    try {
//	        String foundPassword = customerDAO.findPasswordByEmail(inputEmail);
//	        if (foundPassword != null) {
//	            System.out.println("찾은 비밀번호: " + foundPassword);
//	        } else {
//	            System.out.println("해당 이메일을 가진 사용자가 없습니다.");
//	        }
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	    
//	    // 회원 정보 조회 
//	    try {
//            // 이메일을 기반으로 회원 정보 조회
//            Customer customerInfo = customerDAO.getCustomerByEmail(inputEmail);
//
//            if (customerInfo != null) {
//                // 조회된 회원 정보 출력
//                System.out.println("회원 정보:");
//                System.out.println("ID: " + customerInfo.getCustomer_id());
//                System.out.println("Email: " + customerInfo.getEmail());
//                System.out.println("Password: " + customerInfo.getPassword());
//                System.out.println("Name: " + customerInfo.getName());
//            } else {
//                System.out.println("해당 이메일을 가진 사용자가 없습니다.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    
//	    
	  // 회원 정보 수정 
	    Customer customerToUpdate = new Customer();
        customerToUpdate.setCustomer_id(1); // 수정할 회원의 고유한 ID 설정
        customerToUpdate.setEmail("swiftie0509@gmail.com");
        customerToUpdate.setName("june");
        String email = "glp0509@naver.com";
        try {
            
            int result = customerDAO.update(customerToUpdate,email);

            if (result > 0) {
                System.out.println("회원 정보가 성공적으로 수정되었습니다.");
            } else {
                System.out.println("회원 정보 수정에 실패했습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
	
	// 비밀번호 변경 
	   int customerId = 8; // 해당 고객의 ID
       String newPassword = "newPassword123"; // 새로운 비밀번호

       try {
           int result = customerDAO.updatePassword(customerId, newPassword);

           if (result > 0) {
               System.out.println("비밀번호가 성공적으로 변경되었습니다.");
           } else {
               System.out.println("비밀번호 변경에 실패했습니다.");
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
       
       // 친구 추가 
       // 친구 추가 
 	  int customerId1 = 15; // 첫 번째 고객 ID
       int customerId2 = 8; // 두 번째 고객 ID

       try {
           boolean result = customerDAO.addFriend(customerId1, customerId2);

           if (result) {
               System.out.println("친구 추가가 완료되었습니다.");
           } else {
               System.out.println("친구 추가에 실패했습니다.");
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
//	
   
	
	// 친구 조회 
    try {
        // customerId가 1인 고객의 친구 목록 조회
        int customer_Id = 15;
        System.out.println("CustomerId가 " + customer_Id + "인 고객의 친구 목록:");

        // 특정 고객의 친구 목록 가져오기
        List<Integer> friendList = customerDAO.getFriendList(customer_Id);

        if (friendList.isEmpty()) {
            System.out.println("친구가 없습니다.");
        } else {
            for (int friendId : friendList) {
                System.out.println("친구 ID: " + friendId);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
  // 친구 삭제 
//    int customerId1 = 15; // 첫 번째 사용자 ID
//    int customerId2 = 8; // 두 번째 사용자 ID
//
//    try {
//        boolean isRemoved = customerDAO.removeFriend(customerId1, customerId2);
//
//        if (isRemoved) {
//            System.out.println("친구 관계 삭제 성공");
//        } else {
//            System.out.println("친구 관계 삭제 실패");
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//}
//    
    
}
}
  








	

