package controller.diary;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dao.CommentsDAO;
import model.dao.DiaryDAO;

public class DeleteCommentsController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int commentId = Integer.parseInt(request.getParameter("commentId"));
		CommentsDAO commentsDAO = new CommentsDAO();
		
		commentsDAO.remove(commentId);
		int diaryId = Integer.parseInt(request.getParameter("diaryId"));
		
		return "redirect:/diary/view?diaryId=" + diaryId;
	}

}
