package controller.diary;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.Comments;

import model.dao.CommentsDAO;


public class RegisterCommentsController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		    	
		Comments comments = new Comments();
		CommentsDAO commentsDAO = new CommentsDAO();
		
		comments.setContent(request.getParameter("diary_comments"));
		comments.setCustomer_id(Integer.parseInt(request.getParameter("customerId")));
		comments.setDiary_id(Integer.parseInt(request.getParameter("diaryId")));
		
		int result = commentsDAO.create(comments);
		int diaryId = Integer.parseInt(request.getParameter("diaryId"));
				
		if (result>0) {
			return "redirect:/diary/view?diaryId=" + diaryId;
		}
		return "redirect:/diary/view?diaryId=" + diaryId;
	}

}
