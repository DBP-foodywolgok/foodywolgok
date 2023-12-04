package test;

import java.sql.SQLException;

import model.Comments;
import model.dao.CommentsDAO;

public class CommentsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//댓글 등록 

        Comments comment1= new Comments();
        comment1.setContent("나랑도 같이 가자~~");
        comment1.setCustomer_id(8);
        comment1.setDiary_id(93);
       
        Comments comment2= new Comments();
        comment2.setContent("오늘 완전 맛있었음!!");
        comment2.setCustomer_id(8);
        comment2.setDiary_id(93);
       
        Comments[] comment = {comment1, comment2};
        
        CommentsDAO comments = new CommentsDAO();
        try {
        	for (Comments commentN : comment) {
        		int result;
        		result = comments.create(commentN);
        	
        		if (result > 0) {
        			System.out.println("댓글 추가 완료" +commentN);
        		}
        		else
        			System.out.println("댓글 추가 실패" +commentN);
        	}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        //댓글 수정 
        CommentsDAO dao = new CommentsDAO();
		Comments comment2ToUpdate = new Comments();
		comment2ToUpdate.setContent("오늘 완전 맛있었음!! 담에 또 가자 ㅎㅎㅎㅎ");

		try {
		
			int result = dao.update(comment2ToUpdate, comment2.getComment_id());

			if (result > 0) {
				System.out.println("댓글 수정 완료");
			} else {
				System.out.println("댓글 수정 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
