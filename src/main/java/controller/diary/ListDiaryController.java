package controller.diary;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.customer.UserSessionUtils;
import model.Customer;
import model.Diary;
import model.dao.CustomerDAO;
import model.dao.DiaryDAO;

public class ListDiaryController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		// customerId 
        HttpSession session = request.getSession();
        int customerId = (int) session.getAttribute(UserSessionUtils.USER_SESSION_KEY);
        
        DiaryDAO diaryDAO = new DiaryDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        
        List<Diary> myDiaryList = diaryDAO.findDiarysByCustomer(customerId);
        // DAO를 통해 해당 사용자의 친구 id 리스트 가져오기
        List<Customer> friendList = customerDAO.getFriends(customerId);
        StringBuilder friendIds = new StringBuilder();

        for (Customer customer : friendList) {
            if (friendIds.length() > 0) {
                friendIds.append(",");
            }
            friendIds.append(customer.getCustomer_id());
        }

        //String friends= friendIds.toString();
        
        List<Diary> friendDiaryList = diaryDAO.findDiarysByFriends(friendIds.toString());
        request.setAttribute("customerId", customerId);
        
        //
        String command = request.getParameter("command");
        //System.out.println("Command: " + command);

        if ("my".equals(command)) {
            request.setAttribute("diaryList", myDiaryList);
            return "/DiaryList.jsp";
        } else if ("friend".equals(command)) {
        	request.setAttribute("diaryList", friendDiaryList);
        	
        	return "/DiaryList.jsp";
        }
        
        request.setAttribute("diaryList", myDiaryList);
        
		return "/DiaryList.jsp";
	}

}
