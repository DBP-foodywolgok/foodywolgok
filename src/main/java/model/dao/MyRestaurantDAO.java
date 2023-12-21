package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.My_restaurant;

public class MyRestaurantDAO {
	private JDBCUtil jdbcUtil = null;
	
	// 생성자
	public MyRestaurantDAO() {
		jdbcUtil = new JDBCUtil();
	}
	
	// 사용자의 My restaurant 전체 조회
	public List<My_restaurant> getAllMyRestaurant(int customerId) {
		String allQuery = "SELECT CASE WHEN m.restaurant_id IS NOT NULL THEN r.name ELSE m.name END AS name, "
						+ "CASE WHEN m.restaurant_id IS NOT NULL THEN r.address ELSE m.address END AS address, "
						+ "c.name category, m.score score, m.memo memo, m.created_at created_at, m.customer_id customer_id, m.my_restaurant_id id "
						+ "FROM my_restaurant m LEFT OUTER JOIN restaurant r ON m.restaurant_id = r.restaurant_id "
						+ "JOIN category c ON m.category_id = c.category_id "
						+ "WHERE customer_id = ? "
						+ "ORDER BY m.created_at DESC";
		Object[] param = new Object[] { customerId };
		jdbcUtil.setSqlAndParameters(allQuery, param);
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<My_restaurant> list = new ArrayList<My_restaurant>();
			while(rs.next()) {
				My_restaurant dto = new My_restaurant();
				dto.setId(rs.getInt("ID")); // my_restaurant_id
				dto.setName(rs.getString("NAME")); // 식당 이름
				dto.setAddress(rs.getString("ADDRESS")); // 식당 주소
				dto.setCategory(rs.getString("CATEGORY")); // 식당 카테고리
				dto.setScore(rs.getInt("SCORE")); // 점수
				dto.setMemo(rs.getString("MEMO")); // 메모
				dto.setCreated_at(rs.getDate("CREATED_AT")); // 생성 시간
				
				list.add(dto);
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		} return null;
	}
	
	// My restaurant ID로 My restaurant 조회
	public My_restaurant getMyRestaurantById(int myRId) {
		String searchQuery = "SELECT CASE WHEN m.restaurant_id IS NOT NULL THEN r.name ELSE m.name END AS name, "
							+ "CASE WHEN m.restaurant_id IS NOT NULL THEN r.address ELSE m.address END AS address, "
							+ "c.name category, m.score score, m.memo memo, m.created_at created_at, m.customer_id customer_id, m.my_restaurant_id id "
							+ "FROM my_restaurant m LEFT OUTER JOIN restaurant r ON m.restaurant_id = r.restaurant_id "
							+ "JOIN category c ON m.category_id = c.category_id "
							+ "WHERE my_restaurant_id = ? "
							+ "ORDER BY m.created_at";
		Object[] param = new Object[] { myRId };
		jdbcUtil.setSqlAndParameters(searchQuery, param);
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			My_restaurant myR = null;
			if (rs.next()) {
				myR = new My_restaurant();
				myR.setId(rs.getInt("ID")); // my_restaurant_id
				myR.setName(rs.getString("NAME")); // 식당 이름
				myR.setAddress(rs.getString("ADDRESS")); // 식당 주소
				myR.setCategory(rs.getString("CATEGORY")); // 식당 카테고리
				myR.setScore(rs.getInt("SCORE")); // 점수
				myR.setMemo(rs.getString("MEMO")); // 메모
				myR.setCreated_at(rs.getDate("CREATED_AT")); // 생성 시간
			}
			return myR;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		} return null;
	}
	
	// My_restaurant 테이블에 데이터 추가 (식당이 DB에 등록되어 있는 경우)
	public int insertMyRestaurantByRes(My_restaurant myR) {
		int result = 0;
		String insertByRes = "INSERT INTO my_restaurant (my_restaurant_id, name, address, score, memo, created_at, customer_id, restaurant_id, category_id) "
							+ "VALUES (my_restaurant_seq.nextval, NULL, NULL, ?, ?, ?, ?, ?, ?)";
		Object[] param = new Object[] { myR.getScore(), myR.getMemo(), myR.getCreated_at(), myR.getCustomerId(), myR.getRestaurantId(), myR.getCategoryId() }; // my_restaurant_id는 임시로 하드코딩함
		jdbcUtil.setSqlAndParameters(insertByRes, param);
		try {
			result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		} return 0;
	}
	
	// My_restaurant 테이블에 데이터 추가 (사용자가 직접 식당 정보를 입력할 경우)
	public int insertMyRestaurantByUser(My_restaurant myR) {
		int result = 0;
		String insertByUser = "INSERT INTO my_restaurant (my_restaurant_id, name, address, score, memo, created_at, customer_id, restaurant_id, category_id) "
							+ "VALUES (my_restaurant_seq.nextval, ?, ?, ?, ?, ?, ?, NULL, ?)";
		Object[] param = new Object[] { myR.getName(), myR.getAddress(), myR.getScore(), myR.getMemo(), myR.getCreated_at(), myR.getCustomerId(), myR.getCategoryId() }; // my_restaurant_id는 임시로 하드코딩함
		jdbcUtil.setSqlAndParameters(insertByUser, param);
		try {
			result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		} return 0;
	}
	
	// My_restaurant 테이블 데이터 수정 (별점과 메모)
	public int updateMyRestaurant(int score, String memo, int mrId) {
		int result = 0;
		String updateByRes = "UPDATE my_restaurant SET score = ?, memo = ? "
							+ "WHERE my_restaurant_id = ?";
		Object[] param = new Object[] { score, memo, mrId };
		jdbcUtil.setSqlAndParameters(updateByRes, param);
		try {
			result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		} return 0;
	}
	
	// My_restaurant 테이블 데이터 삭제
	public int deleteMyRestaurant(int mrId) {
		int result = 0;
		String delete = "DELETE FROM My_restaurant "
						+ "WHERE my_restaurant_id = ?";
		Object[] param = new Object[] { mrId };
		jdbcUtil.setSqlAndParameters(delete, param);
		try {
			result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		} return 0;
	}
	
	// 식당 이름 검색어를 통해 Restaurant 테이블에서 식당 검색 (등록 시 필요)
	public List<String[]> findRestaurant(String keyword) {
		String findQuery = "SELECT r.restaurant_id, r.name name, r.address address, r.category_id, c.name category "
						+ "FROM restaurant r JOIN category c ON r.category_id = c.category_id "
						+ "WHERE r.name LIKE '%' || ? || '%'";
		Object[] param = new Object[] { keyword };
		jdbcUtil.setSqlAndParameters(findQuery, param);
		try {
			ResultSet rs = jdbcUtil.executeQuery();
			List<String[]> list = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt("RESTAURANT_ID");
				String sId = Integer.toString(id);
				String name = rs.getString("NAME");
				String address = rs.getString("ADDRESS");
				int cId = rs.getInt("CATEGORY_ID");
				String sCId = Integer.toString(cId);
				String category = rs.getString("CATEGORY");
				String[] dto = { sId, name, address, sCId, category };
				list.add(dto);
			}
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		} return null;
	}
	
}
