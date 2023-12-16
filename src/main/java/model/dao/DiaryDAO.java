package model.dao;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Diary;
/**
* 사용자 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
* DIARY 테이블에 사용자 정보를 추가, 수정, 삭제, 검색 수행
*/
public class DiaryDAO {
	private JDBCUtil jdbcUtil = null;
	public DiaryDAO() {
		jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성
	}
	/**
	* 다이어리 새로운 글 생성
	 */
	public int create(Diary diary) throws SQLException {
		String sql = "INSERT INTO DIARY VALUES (diary_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		
		// 현재 날짜와 시간을 LocalDateTime을 사용하여 가져옴
        LocalDateTime currentDateTime = LocalDateTime.now();
        // LocalDateTime을 Date로 변환하여 바인딩
        Date date = Date.valueOf(currentDateTime.toLocalDate());
        
		Object[] param = new Object[] {diary.getTitle(),
				diary.getIsShared(), date, diary.getContent(),
				diary.getRestaurant_id(), diary.getCustomer_id(), diary.getPicture()};
	
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil 에 insert문과 매개 변수 설정
		
		String key[] = {"diary_id"};
		try {
			int result = jdbcUtil.executeUpdate(key); // insert 문 실행
		   	ResultSet rs = jdbcUtil.getGeneratedKeys();
		   	int generatedKey = 0;
		   	if(rs.next()) {
		   		generatedKey = rs.getInt(1);     //  PK 컬럼 값(들)을 읽음
		   		diary.setDiary_id(generatedKey); 	// id필드에 저장  
		   		  
		   	}
		   	return result;
	
		} catch (Exception ex) {
			//System.out.println("오류");
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return 0;
	}
	
	/**
	 * 
	 * 기존의 다이어리를 수정. */
	public int update(Diary diary, int diary_id) throws SQLException {
		String sql = "UPDATE DIARY " + "SET title=?, isshared=?, content=? " + "WHERE diary_id= ?";
	
		Object[] param = new Object[] {diary.getTitle(), diary.getIsShared(),
				 diary.getContent(), diary_id};
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil에 update문과 매개 변수 설정
		try {
			int result = jdbcUtil.executeUpdate(); // update 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return 0;
	}
	
	/**
	 * 다이어리 ID에 해당하는 다이어리를 삭제.
	 */
	public int remove(int diary_id) throws SQLException {
		String sql = "DELETE FROM DIARY WHERE diary_id=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {diary_id});	// JDBCUtil에 delete문과 매개 변수 설정

		try {				
			int result = jdbcUtil.executeUpdate();	// delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}
	
	/**
	 * 주어진 다이어리 ID에 해당하는 다이어리 정보를 데이터베이스에서 찾아 Diary도메인 클래스에
	 * 저장하여 반환. */
	public Diary findDiary(int diary_id) throws SQLException {
		String sql = "SELECT title, isshared, nowdate, content, restaurant_id, customer_id, picture "
				+ "FROM DIARY " + "WHERE diary_id=? ";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {diary_id}); //JDBCUtil에 query문과 매개 변수 설정
		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query실행
			
			if (rs.next()) { //다이어리 정보 발견
				java.sql.Date nowDate = rs.getDate("nowdate");  // DATE 타입 컬럼 --> java.sql.Date
				java.util.Date utilDate = new java.util.Date(nowDate.getTime());   // java.sql.Date --> java.util.Date 
				Diary diary = new Diary( // Diary객체를 생성하여 다이어리 정보를 저장
						diary_id, rs.getString("title"),
						rs.getInt("isshared"),
						utilDate,				
						rs.getString("content"),
						rs.getInt("restaurant_id"),
						rs.getInt("customer_id"),
						rs.getString("picture"));
				return diary;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource 반환
		}
		return null;
	}
	/**
	 * 특정 customer가 작성한 다이어리를 검색하여 List에 저장 및 반환, 날짜 순
	 */
	
	public List<Diary> findDiarysByCustomer(int customer_id) throws SQLException {
		String sql = "SELECT diary_id, title, isshared, nowdate, content, restaurant_id, customer_id, picture FROM DIARY "
				+ "WHERE customer_id = ? "
				+ "ORDER BY diary_id DESC";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {customer_id}); //JDBCUtil에 query문과 매개 변수 설정
		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query실행
			List<Diary> diaryList = new ArrayList<Diary>(); // 다이어리리스트 생성
			
			while (rs.next()) {
				java.sql.Date nowDate = rs.getDate("nowdate");  // DATE 타입 컬럼 --> java.sql.Date
				java.util.Date utilDate = new java.util.Date(nowDate.getTime());   // java.sql.Date --> java.util.Date 
				Diary diary = new Diary( // Diary 객체를 생성하여 현재 행의 정보를 저장
						rs.getInt("diary_id"),
						rs.getString("title"),
						rs.getInt("isshared"),
						utilDate,
						rs.getString("content"),
						rs.getInt("restaurant_id"),
						rs.getInt("customer_id"),
						rs.getString("picture"));
				diaryList.add(diary); // List에 diary 객체 저장
			}
			return diaryList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource 반환
		}	
		return null;
	}
	/**
	 * 특정 customer가 작성한 다이어리 수를 count하여 반환
	 */
	/*
	public int getNumberOfDiarysByCustomer(int customer_id) {
		String sql = "SELECT COUNT(diary_id) FROM DIARY "	
				+ "WHERE customer_id = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {customer_id}); //JDBCUtil에 query문과 매개 변수 설정
		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			rs.next();
			return rs.getInt(1);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource 반환
		}
		return 0;
	}
	*/
	
}
