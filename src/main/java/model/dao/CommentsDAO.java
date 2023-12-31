package model.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Comments;
/**
* 사용자 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
* Comments 테이블에 사용자 정보를 추가, 수정, 삭제, 검색 수행
*/
public class CommentsDAO {
	private JDBCUtil jdbcUtil = null;
	public CommentsDAO() {
		jdbcUtil = new JDBCUtil(); // JDBCUtil 객체 생성
	}
	/**
	 * comments 새로운 댓글 생성
	 */
	public int create(Comments comment) throws SQLException {
		String sql = "INSERT INTO Comments VALUES (comments_seq.nextval, ?, ?, ?)";
		// 파라미터 값 가져오기 //
		Object[] param = new Object[] {
				comment.getDiary_id(),
				comment.getCustomer_id(), comment.getContent()};
		jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil 에 insert문과 매개 변수 설정
		String key[] = {"comment_id"};
		try {
			int result = jdbcUtil.executeUpdate(key); // insert 문 실행
			ResultSet rs = jdbcUtil.getGeneratedKeys();
		   	int generatedKey = 0;
		   	if(rs.next()) {
		   		generatedKey = rs.getInt(1);     //  PK 컬럼 값(들)을 읽음
		   		comment.setComment_id(generatedKey); 	// id필드에 저장  
		   	}
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close(); // resource 반환
		}
		return 0;
	}
	/**
	 * 기존의 댓글을 수정. */
	public int update(Comments comment, int comment_id) throws SQLException {
		String sql = "UPDATE COMMENTS " + "SET content=? " + "WHERE comment_id=?";
		Object[] param = new Object[] {comment.getContent(), comment_id};
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
	 * 댓글 ID에 해당하는 댓글을 삭제. */
	public int remove(int comment_id) throws SQLException {
		String sql = "DELETE FROM COMMENTS WHERE comment_id=?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {comment_id}); //JDBCUtil에 delete문과 매개 변수 설정
		try {
			int result = jdbcUtil.executeUpdate(); // delete 문 실행
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
	 * 주어진 댓글 ID에 해당하는 댓글 정보를 데이터베이스에서 찾아 Comments 도메
	인 클래스에
	 * 저장하여 반환. */
	public Comments findComment(int comment_id) throws SQLException {
		String sql = "SELECT diary_id, customer_id, content "
				+ "FROM COMMENTS "
				+ "WHERE comment_id=? ";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {comment_id}); //JDBCUtil에 query문과 매개 변수 설정
		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			if (rs.next()) { //댓글 정보 발견
				Comments comment = new Comments( //Comments 객체를 생성하여 댓글 정보를 저장
						comment_id,
						rs.getString("content"),
						rs.getInt("diary_id"),
						rs.getInt("customer_id"));
				return comment;
			}
		} catch (Exception ex) {	
			ex.printStackTrace();
		} finally {		
			jdbcUtil.close(); // resource 반환
		}
		return null;
	}
	/**
	 * 특정 다이어리에 작성된 댓글을 검색하여 List에 저장 및 반환, comment_id순
	 */
	/*public List<Comments> findCommentsWithNameByDiary(int diary_id) throws SQLException {
		String sql = "SELECT comment_id, diary_id, customer_id, content FROM COMMENTS "
				+ "WHERE diary_id = ? "
				+ "ORDER BY comment_id";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {diary_id}); //JDBCUtil에 query문과 매개 변수 설정
		try {
			ResultSet rs = jdbcUtil.executeQuery(); // query 실행
			List<Comments> commentsList = new
					ArrayList<Comments>(); // 댓글 리스트 생성
			while (rs.next()) {
				Comments comment = new Comments( //Comments 객체를 생성하여 현재 행의 정보를 저장
						rs.getInt("comment_id"),
						rs.getString("content"),
						diary_id,
						rs.getInt("customer_id"));
				commentsList.add(comment); //List에 comment 객체 저장
			}
			return commentsList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // resource 반환
		}
		return null;
	}*/
	/**
	 * 특정 다이어리에 작성된 댓글을 검색하여 List에 저장 및 반환, comment_id순 + name 추출을 위한 join query
	 */
	public List<Comments> findCommentsWithNameByDiary(int diary_id) throws SQLException {
	    String sql = "SELECT c.comment_id, c.diary_id, c.customer_id, c.content, cust.name " +
	                 "FROM COMMENTS c " +
	                 "INNER JOIN CUSTOMER cust ON c.customer_id = cust.customer_id " +
	                 "WHERE c.diary_id = ? " +
	                 "ORDER BY c.comment_id";
	    jdbcUtil.setSqlAndParameters(sql, new Object[]{diary_id});

	    try {
	        ResultSet rs = jdbcUtil.executeQuery();
	        List<Comments> commentsList = new ArrayList<>();

	        while (rs.next()) {
	            Comments comment = new Comments(
	            		rs.getInt("comment_id"),
						rs.getString("content"),
						diary_id,
						rs.getInt("customer_id"),
						rs.getString("name"));
	            commentsList.add(comment);
	        }

	        return commentsList;
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        jdbcUtil.close();
	    }

	    return null;
	}

	
	/**
	 * 특정 다이어리 글에 작성된 댓글 count하여 반환
	 */
	public int getNumberOfCommentsByDiary(int diary_id) {
		String sql = "SELECT COUNT(comment_id) FROM COMMENTS "
				+ "WHERE diary_id = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {diary_id}); //JDBCUtil에 query문과 매개 변수 설정
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
}