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
		
		// POST request (다이어리 정보가 parameter로 전송됨)
		
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
