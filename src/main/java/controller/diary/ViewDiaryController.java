package controller.diary;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Comments;
import model.Diary;
import model.dao.CommentsDAO;
import model.dao.DiaryDAO;

public class ViewDiaryController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int diaryId = Integer.parseInt(request.getParameter("diaryId"));
		
    	Diary diary = null;
    	DiaryDAO diaryDAO = new DiaryDAO();
    	
    	CommentsDAO commentsDAO = new CommentsDAO();
    	
		diary = diaryDAO.findDiary(diaryId);	// 다이어리 정보 검색	
		List<Comments> myDiaryComments = commentsDAO.findCommentsWithNameByDiary(diaryId); //댓글 리스트 검색 
		
		request.setAttribute("diary", diary);		// 다이어리 정보 저장	
		request.setAttribute("diaryCommentsList", myDiaryComments);
		
		return "/DiaryDetail.jsp";
	}

}
