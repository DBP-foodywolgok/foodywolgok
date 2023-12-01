package test;


import java.sql.SQLException;

import model.Diary;
import model.dao.DiaryDAO;

public class DiaryTest {
    
    // 다이어리 등록
    public static void main(String[] args) {
    	
        Diary diary = new Diary(1, "오늘은 제나키친을 갔다", 1, null, null,
                "완전 맛있었음. 김치찜 강추!! 다음에 오면 다른거 먹어봐야겠다~~", 1, 8);
        
        DiaryDAO diaryDAO = new DiaryDAO();
        
        try {
            int result;
            result = diaryDAO.create(diary);
            
            if (result > 0)
                System.out.println("다이어리 글 추가 완료" + diary);
            else
                System.out.println("다이어리 글 추가 실패" + diary);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

