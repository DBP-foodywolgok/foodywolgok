package controller.myrestaurant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.Controller;
import model.My_restaurant;
import model.dao.MyRestaurantDAO;

public class DeleteMyRestaurantController implements Controller{
	private static final Logger log = LoggerFactory.getLogger(DeleteMyRestaurantController.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/* GET request: My Restaurant Delete 요청 */
		log.debug("My Restaurant View Request");
		
		String id = request.getParameter("id");
		MyRestaurantDAO MyRestaurantDAO = new MyRestaurantDAO();
		
		int result = MyRestaurantDAO.deleteMyRestaurant(Integer.parseInt(id));
		
		return "redirect:/myRestaurant/list?sort=0";
	}

}
