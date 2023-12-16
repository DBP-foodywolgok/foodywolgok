package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.customer.CustomerInformationController;
import controller.customer.CustomerLoginController;
import controller.customer.CustomerLogoutController;
import controller.customer.CustomerRegisterController;

import controller.diary.RegisterDiaryController;
import controller.diary.ViewDiaryController;
import controller.diary.DeleteDiaryController;
import controller.diary.ListDiaryController;
import controller.restaurant.CategoryController;
import controller.restaurant.SearchController;

import model.dao.CustomerDAO;
import model.dao.RestaurantDAO;
import model.service.CustomerService;

//import controller.customer.customerController;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
  
    
    // 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// 각 uri에 대응되는 controller 객체를 생성 및 저장
        mappings.put("/customer/register", new CustomerRegisterController());
        mappings.put("/customer/loginPage", new ForwardController("/login.jsp"));
    	mappings.put("/", new ForwardController("/Main.jsp"));
        mappings.put("/customer/join", new ForwardController("/MemberJoin.jsp"));
        mappings.put("/customer/main", new ForwardController("/Main.jsp"));
        mappings.put("/customer/login",new CustomerLoginController());
        mappings.put("/customer/logout", new CustomerLogoutController());
        mappings.put("/customer/memberInformation", new CustomerInformationController());
        
        mappings.put("/customer/findPassword", new ForwardController("/FindPassword.jsp")); 
        mappings.put("/customer/diaryList", new ListDiaryController());
        mappings.put("/customer/recommendation", new ForwardController("/Recommendation.jsp"));
        mappings.put("/customer/friendlist", new ForwardController("/FriendList.jsp"));
        mappings.put("/customer/mypage", new ForwardController("/MyPage.jsp"));
      
        mappings.put("/customer/changePassword", new ForwardController("/ChangePassword.jsp"));
        mappings.put("/customer/findFriendList", new ForwardController("/FriendList.jsp"));
        
        //다이어리
        mappings.put("/diary/register", new RegisterDiaryController());
        mappings.put("/diary/register/form", new ForwardController("/RegistrationDiary.jsp"));
        mappings.put("/diary/update", new ForwardController("/EditDiary.jsp"));
        mappings.put("/diary/delete", new DeleteDiaryController());
        mappings.put("/diary/list", new ListDiaryController());
        mappings.put("/diary/view", new ViewDiaryController()); 
        
        //map
        mappings.put("/restaurant/map", new ForwardController("/MapMainView.jsp"));
        mappings.put("/restaurant/search", new SearchController()); //검색버튼 누르면
        mappings.put("/kindlist", new CategoryController());
        mappings.put("/restaurant/kindview", new ForwardController("/KindView.jsp"));
        mappings.put("/restaurant/view", new ForwardController("/MapDetailsView.jsp"));
        mappings.put("/wishlist/view", new ForwardController("/WishList.jsp"));
        
        mappings.put("/myRestaurant/list", new ForwardController("/MyRestaurantList.jsp"));
        mappings.put("/myRestaurant/register", new ForwardController("/AddMyRestaurant.jsp"));
        mappings.put("/restaurant/find", new ForwardController("/FindRestaurant.jsp"));
        mappings.put("/myRestaurant/update", new ForwardController("/ModifyMyRestaurant.jsp"));
        mappings.put("/myRestaurant/view", new ForwardController("/MyRestaurantDetail.jsp"));

    //    mappings.put("/customer/register", new customerController());
    	//mappings.put("/customer", new customerController());
   
     //   mappings.put("/customer", new customerController());
      //  mappings.put("/customer", new ForwardController("/MemberJoin.jsp"));
        // 회원 가입 폼 요청과 가입 요청 처리 병합 (폼에 커뮤니티 선택 메뉴 추가를 위함)
//      mappings.put("/user/register/form", new ForwardController("/user/registerForm.jsp"));
//      mappings.put("/user/register", new RegisterUserController());
    

        // 사용자 정보 수정 폼 요청과 수정 요청 처리 병합
//      mappings.put("/user/update/form", new UpdateUserFormController());
//      mappings.put("/user/update", new UpdateUserController());        
//        mappings.put("/user/update", new UpdateUserController());
//        
//        mappings.put("/user/delete", new DeleteUserController());
//        
//        // 커뮤니티 관련 request URI 추가
//        mappings.put("/community/list", new ListCommunityController());
//        mappings.put("/community/view", new ViewCommunityController());
//        mappings.put("/community/create/form", new ForwardController("/community/creationForm.jsp"));
//        mappings.put("/community/create", new CreateCommunityController());
//        mappings.put("/community/update", new UpdateCommunityController());
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// 주어진 uri에 대응되는 controller 객체를 찾아 반환
        return mappings.get(uri);
    }
}