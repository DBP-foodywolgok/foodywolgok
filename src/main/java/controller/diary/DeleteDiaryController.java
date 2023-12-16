package controller.diary;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dao.DiaryDAO;

public class DeleteDiaryController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int diaryId = Integer.parseInt(request.getParameter("diaryId"));
		DiaryDAO diaryDAO = new DiaryDAO();
		
		diaryDAO.remove(diaryId);
		
		return "redirect:/diary/list";
	}

}
