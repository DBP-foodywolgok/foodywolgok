package test;


import java.sql.SQLException;

import model.Diary;
import model.dao.DiaryDAO;

public class DiaryTest {
    
    
    public static void main(String[] args) {
    	
    	//다이어리 등록 
       
        Diary diary1= new Diary();
        diary1.setTitle("오늘은 제나키친을 갔다.");
        diary1.setIsShared(1);
        diary1.setContent("완전 맛있었음 김치찜 강추~~ 다음에 오면 다른거 먹어봐야겠다");
        diary1.setCustomer_id(8);
        diary1.setRestaurant_id(1);
        
        Diary diary2 = new Diary();
        diary2.setTitle("오늘 저녁에 국수나무에 갔다!!");
        diary2.setIsShared(0);
        diary2.setContent("음 돈까스는 그저 그런..... 뭐를 먹지 다음엔");
        diary2.setCustomer_id(8);
        diary2.setRestaurant_id(1);
        Diary[] diarys= {diary1, diary2};
        		
        DiaryDAO diaryDAO = new DiaryDAO();
        
        try {
        	for(Diary diary : diarys) {
        	
                int result = diaryDAO.create(diary);
                
                if (result > 0) {
                    System.out.println("다이어리 글 추가 완료" +diary);

                }
                else
                    System.out.println("다이어리 글 추가 실패"+diary);
        		
        	}
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        //다이어리 수정 
        
        DiaryDAO dao = new DiaryDAO();
		Diary diary2ToUpdate = new Diary();
		diary2ToUpdate.setTitle("국수나무 돈까스 클리어~");
		diary2ToUpdate.setIsShared(1);
		diary2ToUpdate.setContent("음.. 사실 맛있게 먹었음ㅎㅎ 돈까스도 강추");
		
		try {
			//System.out.println(diary2.getDiary_id());
			int result = dao.update(diary2ToUpdate, diary2.getDiary_id());
			
			if (result > 0) {
				System.out.println("다이어리 글 수정 완료");
			} else {
				System.out.println("다이어리 글 수정 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }
    
    
}

