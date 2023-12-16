package controller.diary;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Diary;
import model.dao.DiaryDAO;

public class ViewDiaryController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int diaryId = Integer.parseInt(request.getParameter("diaryId"));
		
    	Diary diary = null;
    	DiaryDAO diaryDAO = new DiaryDAO();
    	
		diary = diaryDAO.findDiary(diaryId);	// 다이어리 정보 검색	
		
		request.setAttribute("diary", diary);		// 다이어리 정보 저장	
		
		return "/DiaryDetail.jsp";
	}

}
