package controller.diary;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Diary;
import model.dao.DiaryDAO;

public class UpdateDiaryController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		if (request.getMethod().equals("GET")) {	
    		// GET request: 다이어리 수정 form 요청	
    		// 원래는 UpdateDiaryFormController가 처리하던 작업을 여기서 수행
    		
    		int updateId = Integer.parseInt(request.getParameter("diaryId"));

    		//log.debug("UpdateForm Request : {}", updateId);
    		
    		DiaryDAO diaryDAO = new DiaryDAO();
    		Diary diary = diaryDAO.findDiary(updateId); //수정하려는 다이어리 정보 검색 
    		
			request.setAttribute("diary", diary);			
			
			return "/EditDiary.jsp"; //다이어리 수정 form 으로 전송 
		}
		
		// POST request (다이어리 정보가 parameter로 전송됨)
		
		int diaryId = Integer.parseInt(request.getParameter("diaryId"));
    	Diary UpdateDiary = new Diary();
    	DiaryDAO diaryDAO = new DiaryDAO();
    	
    	UpdateDiary = diaryDAO.findDiary(diaryId);
    	
    	UpdateDiary.setTitle(request.getParameter("diary_title"));
		UpdateDiary.setIsShared(request.getParameter("diary_friend")!=null?1:0);
		UpdateDiary.setContent(request.getParameter("diary_content"));
		
		int result = diaryDAO.update(UpdateDiary, diaryId);
		
		if (result>0) {
			Diary diary = diaryDAO.findDiary(diaryId);
			request.setAttribute("diary", diary);
			return "/DiaryDetail.jsp";	
		}
		return "/EditDiary.jsp";
	}

}
