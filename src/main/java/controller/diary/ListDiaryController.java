package controller.diary;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.customer.UserSessionUtils;
import model.Diary;
import model.dao.DiaryDAO;

public class ListDiaryController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		// customerId 
        HttpSession session = request.getSession();
        int customerId = (int) session.getAttribute(UserSessionUtils.USER_SESSION_KEY);
        
        DiaryDAO diaryDAO = new DiaryDAO();
        
        List<Diary> diaryList = diaryDAO.findDiarysByCustomer(customerId);
        
        request.setAttribute("diaryList", diaryList);
        request.setAttribute("customerId", customerId);
        
		return "/DiaryList.jsp";
	}

}
