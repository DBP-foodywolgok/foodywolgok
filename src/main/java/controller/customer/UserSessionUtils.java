package controller.customer;

import javax.servlet.http.HttpSession;

public class UserSessionUtils {
    public static final String USER_SESSION_KEY = "customer_id";
    
    /* 현재 로그인한 사용자의 ID를 구함 */
    public static String getLoginCustomerId(HttpSession session) {
        String customer_id = (String) session.getAttribute(USER_SESSION_KEY);
        return customer_id;
    }
    
    /* 로그인한 상태인지를 검사 */
    public static boolean hasLogined(HttpSession session) {
        if (getLoginCustomerId(session) != null) {
            return true;
        }
        return false;
    }
    
    /* 현재 로그인한 사용자의 ID가 userId인지 검사 */
    public static boolean isLoginCustomer(String userId, HttpSession session) {
        String loginCustomer = getLoginCustomerId(session);
        if (loginCustomer == null) {
            return false;
        }
        return loginCustomer.equals(userId);
    }
    
    public static String getLoginCustomerName(HttpSession session) {
        int customerId = (int)session.getAttribute(USER_SESSION_KEY); // 세션에서 사용자 ID 가져오기
        // 여기서 CustomerDAO를 활용하여 사용자 ID에 해당하는 이름을 가져온다
        String customerName = ""; // CustomerDAO를 활용하여 이름을 가져오는 코드 작성
        return customerName;
    }
}
