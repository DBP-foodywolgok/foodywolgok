package controller.diary;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Comments;
import model.Diary;
import model.dao.CommentsDAO;
import model.dao.DiaryDAO;

public class UpdateCommentsController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		if (request.getMethod().equals("GET")) {	
    		// GET request: 다이어리 수정 form 요청	
    		// 원래는 UpdateDiaryFormController가 처리하던 작업을 여기서 수행
    		
    		int commentId = Integer.parseInt(request.getParameter("commentId"));
    		
    		//log.debug("UpdateForm Request : {}", updateId);
    		
    		CommentsDAO commentsDAO = new CommentsDAO();
    		Comments comments = commentsDAO.findComment(commentId); //수정하려는 다이어리 정보 검색 
    		
			request.setAttribute("comment", comments);			
			
			return "/EditComment.jsp"; //다이어리 수정 form 으로 전송 
		}

		// POST request (댓글정보가 parameter로 전송됨)
		
		int diaryId = Integer.parseInt(request.getParameter("diaryId"));
		int commentId = Integer.parseInt(request.getParameter("commentId"));
		Comments UpdateComments = new Comments();
		CommentsDAO commentsDAO = new CommentsDAO();
		
		UpdateComments.setContent(request.getParameter("updatedContent"));
		
		int result = commentsDAO.update(UpdateComments, commentId);
		
		if (result>0) {
			return "redirect:/diary/view?diaryId=" + diaryId;
		}
		return "redirect:/diary/view?diaryId=" + diaryId;
		
	}
		
	

}