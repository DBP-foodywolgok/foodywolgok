package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;


public class CustomerDAO {

	private JDBCUtil jdbcUtil = null;
	

	
	public CustomerDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
	
	public int createCustomer(Customer customer) throws SQLException {
	    String sql = "INSERT INTO Customer VALUES (customer_seq.nextval,?, ?, ?)";
	    Object[] param = new Object[] { customer.getEmail(), customer.getPassword(), customer.getName() };
	    jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil에 insert문과 매개 변수 설정
	    try {
	        int result = jdbcUtil.executeUpdate(); // insert 문 실행
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
	
	// 테이블에 새로운 사용자 정보 수정
	
	public int update(Customer customer) throws SQLException {
		String sql = "UPDATE Customer "
					+ "SET customer_id=?, email=?, password=?, name=? "
					+ "WHERE customer_id=?";
		Object[] param = new Object[] {customer.getCustomer_id(), customer.getEmail(), 
					customer.getPassword(), customer.getName()};			
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 update문과 매개 변수 설정
		try {				
			int result = jdbcUtil.executeUpdate();	// update 문 실행
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
	
	// 사용자 정보 삭제 
	
	public int remove(String customerId) throws SQLException {
		String sql = "DELETE FROM Customer WHERE customer_id=?";		
		jdbcUtil.setSqlAndParameters(sql, new Object[] {customerId});	// JDBCUtil에 delete문과 매개 변수 설정
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
}
