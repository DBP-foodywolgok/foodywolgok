package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import controller.customer.UserSessionUtils;
import model.Customer;


public class CustomerDAO {

	private JDBCUtil jdbcUtil = null;
	
	public CustomerDAO() {			
		jdbcUtil = new JDBCUtil();	// JDBCUtil 객체 생성
	}
	
	// 회원 가입 
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
	
	// 카테고리 추가 
	public void addCustomerCategory(int categoryId, int customerId) {
	    String sql = "INSERT INTO Customer_Category VALUES (?, ?)";
	    Object[] param = new Object[] { categoryId, customerId };
	    jdbcUtil.setSqlAndParameters(sql, param);
	    try {
	        jdbcUtil.executeUpdate();
	    } catch (Exception ex) {
	        jdbcUtil.rollback();
	        ex.printStackTrace();
	    } finally {
	        jdbcUtil.commit();
	        jdbcUtil.close();
	    }
	}
	
	// id 로 customer 객체 찾기 
	public Customer getCustomerById(int customerId) throws SQLException {
	    Customer customer = null;

	    String sql = "SELECT * FROM Customer WHERE customer_id = ?";
	    jdbcUtil.setSqlAndParameters(sql, new Object[]{customerId});

	    try {
	        ResultSet rs = jdbcUtil.executeQuery();
	        if (rs.next()) {
	            customer = new Customer();
	            customer.setCustomer_id(rs.getInt("customer_id"));
	            
	            customer.setEmail(rs.getString("email"));
	            customer.setPassword(rs.getString("password"));
	            customer.setName(rs.getString("name"));
	            // Add more attributes if there are others in the Customer class
	        }
	    } catch (Exception ex) {
	        jdbcUtil.rollback();
	        ex.printStackTrace();
	    } finally {
	        jdbcUtil.commit();
	        jdbcUtil.close();
	    }
	    return customer;
	}
	
	// 회원 이름으로 아이디 가져오기 
	public int getCustomerIdByName(String customerName) throws SQLException {
	    int customerId = 0;
	    String sql = "SELECT customer_id FROM Customer WHERE name = ?";
	    jdbcUtil.setSqlAndParameters(sql, new Object[]{customerName});

	    try {
	        ResultSet rs = jdbcUtil.executeQuery();
	        if (rs.next()) {
	            customerId = rs.getInt("customer_id");
	        }
	        return customerId;
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        jdbcUtil.close();
	    }
	    return customerId;
	}
	
	public String getCustomerNameById(int customerId) throws SQLException {
	    String customerName = "";
	    String sql = "SELECT name FROM Customer WHERE customer_id = ?";
	    jdbcUtil.setSqlAndParameters(sql, new Object[]{customerId});

	    try {
	        ResultSet rs = jdbcUtil.executeQuery();
	        if (rs.next()) {
	            customerName = rs.getString("name");
	        }
	    } catch (Exception ex) {
	        jdbcUtil.rollback();
	        ex.printStackTrace();
	    } finally {
	        jdbcUtil.commit();
	        jdbcUtil.close();
	    }
	    return customerName;
	}
	
	public Customer getCustomerByEmail(String email) throws SQLException {
	    Customer customer = null;
	    String sql = "SELECT * FROM Customer WHERE email = ?";
	    jdbcUtil.setSqlAndParameters(sql, new Object[]{email});

	    try {
	        ResultSet rs = jdbcUtil.executeQuery();
	        if (rs.next()) {
	            customer = new Customer();
	            customer.setCustomer_id(rs.getInt("customer_id"));
	            customer.setEmail(rs.getString("email"));
	            customer.setPassword(rs.getString("password"));
	            customer.setName(rs.getString("name"));
	            // Add more attributes if there are others in the Customer class
	        }
	    } catch (Exception ex) {
	        jdbcUtil.rollback();
	        ex.printStackTrace();
	    } finally {
	        jdbcUtil.commit();
	        jdbcUtil.close();
	    }
	    return customer;
	}
	
	public int getCustomerIdByEmail(String email) throws SQLException {
	    int customerId = 0;
	    String sql = "SELECT customer_id FROM Customer WHERE email = ?";
	    jdbcUtil.setSqlAndParameters(sql, new Object[]{email});

	    try {
	        ResultSet rs = jdbcUtil.executeQuery();
	        if (rs.next()) {
	            customerId = rs.getInt("customer_id");
	        }
	        return customerId;
	    } catch (Exception ex) {
	        jdbcUtil.rollback();
	        ex.printStackTrace();
	    } finally {
	        jdbcUtil.commit();
	        jdbcUtil.close();
	    }
	    return customerId;
	}
	
	// 회원정보 수정 
	   public int update(Customer customer, String email) throws SQLException {
	        String sql = "UPDATE Customer SET email=?, name=? WHERE email=?";
	        Object[] param = new Object[]{customer.getEmail(), customer.getName(), email};
	        jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil에 update문과 매개 변수 설정

	        try {
	            int result = jdbcUtil.executeUpdate(); // update 문 실행
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
	
	
	// 로그인 구현 
	// CustomerDAO 클래스의 login 메서드 내용 수정
	    public boolean login(String email, String password) throws SQLException {
	        boolean isValid = false;
	        String sql = "SELECT customer_id FROM Customer WHERE email = ? AND password = ?";
	        jdbcUtil.setSqlAndParameters(sql, new Object[]{email, password});

	        try {
	            ResultSet rs = jdbcUtil.executeQuery();
	            isValid = rs.next(); // 결과가 있으면 로그인 성공
	        } catch (Exception ex) {
	            System.out.println("로그인 중 에러 발생: " + ex.getMessage()); // 에러 메시지 출력
	            jdbcUtil.rollback();
	            ex.printStackTrace();
	        } finally {
	            jdbcUtil.commit();
	            jdbcUtil.close();
	        }
	        return isValid;
	    }

	
	// 비밀번호 찾기 
	public String findPasswordByEmail(String email) throws SQLException {
	    String password = null;
	    String sql = "SELECT password FROM Customer WHERE email = ?";
	    jdbcUtil.setSqlAndParameters(sql, new Object[]{email});

	    try {
	        ResultSet rs = jdbcUtil.executeQuery();
	        if (rs.next()) {
	            password = rs.getString("password");
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    } finally {
	        jdbcUtil.close();
	    }
	    return password;
	}
	
	// 회원정보 조회 
	
	
	// 비밀번호 변경 
	
	 public int updatePassword(int customerId, String newPassword) throws SQLException {
	        String sql = "UPDATE Customer SET password=? WHERE customer_id=?";
	        Object[] param = new Object[]{newPassword, customerId};
	        jdbcUtil.setSqlAndParameters(sql, param); // JDBCUtil에 update문과 매개 변수 설정

	        try {
	            int result = jdbcUtil.executeUpdate(); // update 문 실행
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
	 
	 // 친구 추가 
	 public boolean addFriend(int customerId1, String email) throws SQLException {
		    boolean isSuccess = false;
		    int friendId = getCustomerIdByEmail(email);

		    String sql1 = "INSERT INTO FriendList(cust_id, friend_id) VALUES (?, ?)";
		    String sql2 = "INSERT INTO FriendList(cust_id, friend_id) VALUES (?, ?)";

		    try {
		        jdbcUtil.setSqlAndParameters(sql1, new Object[]{customerId1, friendId});
		        int result1 = jdbcUtil.executeUpdate();

		        jdbcUtil.setSqlAndParameters(sql2, new Object[]{friendId, customerId1});
		        int result2 = jdbcUtil.executeUpdate();

		        if (result1 > 0 && result2 > 0) {
		            isSuccess = true;
		        }
		    } catch (Exception ex) {
		        jdbcUtil.rollback();
		        ex.printStackTrace();
		    } finally {
		        jdbcUtil.commit();
		        jdbcUtil.close();
		    }
		    return isSuccess;
		}
	 
	
	    // 친구 조회 

	 public List<Customer> getFriends(int customerId) throws SQLException {
		    List<Customer> friends = new ArrayList<>();
		    String sql = "SELECT c.customer_id, c.name, c.email " +
		                 "FROM Customer c " +
		                 "INNER JOIN FriendList f ON c.customer_id = f.friend_id " +
		                 "WHERE f.cust_id = ?";
		    jdbcUtil.setSqlAndParameters(sql, new Object[]{customerId});

		    try {
		        ResultSet rs = jdbcUtil.executeQuery();
		        while (rs.next()) {
		            Customer friend = new Customer();
		            friend.setCustomer_id(rs.getInt("customer_id"));
		            friend.setName(rs.getString("name"));
		            friend.setEmail(rs.getString("email"));
		            friends.add(friend);
		        }
		    } catch (Exception ex) {
		        jdbcUtil.rollback();
		        ex.printStackTrace();
		    } finally {
		        jdbcUtil.commit();
		        jdbcUtil.close();
		    }

		    return friends;
		}
	 
// 친구 삭제 
	 public boolean deleteFriend(int customerId, int friendId) throws SQLException {
		    boolean isSuccess = false;
		    String sql = "DELETE FROM FriendList WHERE (cust_id = ? AND friend_id = ?) OR (cust_id = ? AND friend_id = ?)";
		    
		    jdbcUtil.setSqlAndParameters(sql, new Object[]{customerId, friendId, friendId, customerId});
		    
		    try {
		        int result = jdbcUtil.executeUpdate();
		        if (result > 0) {
		            isSuccess = true;
		        }
		    } catch (Exception ex) {
		        jdbcUtil.rollback();
		        ex.printStackTrace();
		    } finally {
		        jdbcUtil.commit();
		        jdbcUtil.close();
		    }
		    return isSuccess;
		}
  }
	

