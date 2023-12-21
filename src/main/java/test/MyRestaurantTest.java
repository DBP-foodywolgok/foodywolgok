//package test;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import model.My_restaurant;
//import model.dao.MyRestaurantDAO;
//
//public class MyRestaurantTest {
//
//	public static void main(String[] args) throws SQLException {
//		// TODO Auto-generated method stub
//		
//		MyRestaurantDAO MyRestaurantDAO = new MyRestaurantDAO();
//		
//		/* My Restaurant 등록 */
//		// 1. 사용자가 입력한 식당 이름을 DB에서 검색
//		String rName = "한식당"; // 사용자가 입력한 식당 이름
//		
//		try {
//			List<String[]> restaurants = MyRestaurantDAO.findRestaurant(rName);
//			
//			if (restaurants.isEmpty()) {
//				System.out.println("해당 식당이 존재하지 않습니다.");
//			} else {
//				System.out.println("\'" + rName + "\' 의 검색 결과");
//				for (String[] r: restaurants) {
//					System.out.println("이름 : " + r[0] + ", 주소 : " + r[1] + ", 카테고리 : " + r[2]);
//				}
//			}
//			
//		} catch (Exception e) {
//	           e.printStackTrace();
//	    }
//		
//		// 2 - 1. 사용자가 입력한 식당 이름이 DB에 존재한다면 (한식당을 선택했을 경우)
//		
//		My_restaurant newRestaurantInDB = new My_restaurant();
//		
//		newRestaurantInDB.setScore(5); // 별점
//		newRestaurantInDB.setMemo("엄청 맛있다."); // 메모
//		newRestaurantInDB.setCustomerId(8); // 사용자 ID
//		newRestaurantInDB.setRestaurantId(4); // 식당 ID
//		newRestaurantInDB.setCategoryId(8); // 카테고리 ID
//		
//		try {
//			int result = MyRestaurantDAO.insertMyRestaurantByRes(newRestaurantInDB);
//			
//			if (result > 0) {
//				System.out.println("\n나의 식당 추가에 성공했습니다.");
//			} else {
//				System.out.println("\n나의 식당 추가에 실패했습니다.");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		// 2 - 2. 사용자가 입력한 식당 이름이 DB에 존재하지 않는다면 (사용자가 직접 입력할 경우)
//		
//		My_restaurant newRestaurantByUser = new My_restaurant();
//		
//		newRestaurantByUser.setName("스테이크집"); // 이름
//		newRestaurantByUser.setAddress("서울특별시 동덕로 10"); // 주소
//		newRestaurantByUser.setScore(4); // 별점
//		newRestaurantByUser.setMemo("맛있다."); // 메모
//		newRestaurantByUser.setCustomerId(8); // 사용자 ID
//		newRestaurantByUser.setCategoryId(1); // 카테고리 ID
//		
//		try {
//			int result = MyRestaurantDAO.insertMyRestaurantByUser(newRestaurantByUser);
//			
//			if (result > 0) {
//				System.out.println("\n나의 식당 추가에 성공했습니다.");
//			} else {
//				System.out.println("\n나의 식당 추가에 실패했습니다.");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
////		/* My Restaurant 수정 */
////		// DB에 등록된 식당일 경우
////		My_restaurant restaurantToUpdate = new My_restaurant();
////		
////		restaurantToUpdate.setScore(4); // 별점
////		restaurantToUpdate.setMemo("엄청 맛있다. 김치찌개가 진짜 맛있다."); // 메모
////		restaurantToUpdate.setRestaurantId(4); // 식당 ID
////		restaurantToUpdate.setCategoryId(8); // 카테고리 ID
////		
////		try {
////			int result = MyRestaurantDAO.updateMyRestaurantByRes(restaurantToUpdate, 4);
////			
////			if (result > 0) {
////				System.out.println("\n나의 식당 수정에 성공했습니다.");
////			} else {
////				System.out.println("\n나의 식당 수정에 실패했습니다.");
////			}
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////		
////		// DB에 등록된 식당이 아닐 경우
////		My_restaurant restaurantToUpdate2 = new My_restaurant();
////		
////		restaurantToUpdate2.setName("스테이크 식당"); // 이름
////		restaurantToUpdate2.setAddress("서울특별시 동덕로 10");
////		restaurantToUpdate2.setScore(5); // 별점
////		restaurantToUpdate2.setMemo("엄청 맛있다."); // 메모
////		restaurantToUpdate2.setCategoryId(8); // 카테고리 ID
////		
////		try {
////			int result = MyRestaurantDAO.updateMyRestaurantByUser(restaurantToUpdate2, 5);
////			
////			if (result > 0) {
////				System.out.println("\n나의 식당 수정에 성공했습니다.");
////			} else {
////				System.out.println("\n나의 식당 수정에 실패했습니다.");
////			}
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
//		
////		/* My Restaurant 삭제 */
////		try {
////			int result = MyRestaurantDAO.deleteMyRestaurant(1);
////			
////			if (result > 0) {
////				System.out.println("\n나의 식당 삭제에 성공했습니다.");
////			} else {
////				System.out.println("\n나의 식당 삭제에 실패했습니다.");
////			}
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
//		
//		/* My Restaurant 조회 */
//		try {
//			List<My_restaurant> restaurants = MyRestaurantDAO.getAllMyRestaurant(8);
//			
//			if (restaurants.isEmpty()) {
//				System.out.println("\n나의 식당이 존재하지 않습니다.");
//			} else {
//				System.out.println("\n사용자 1의 나의 식당");
//				for (My_restaurant r: restaurants) {
//					System.out.println("id : " + r.getId()); // my_restaurant_id
//					System.out.println("이름 : " + r.getName()); // 식당 이름
//					System.out.println("이름 : " + r.getAddress()); // 식당 주소
//					System.out.println("이름 : " + r.getCategory()); // 식당 카테고리
//					System.out.println("이름 : " + r.getScore()); // 점수
//					System.out.println("이름 : " + r.getMemo()); // 메모
//					System.out.println("-----------------------------------");
//				}
//			}
//			
//		} catch (Exception e) {
//	           e.printStackTrace();
//	    }
//		
//	}
//
//}
