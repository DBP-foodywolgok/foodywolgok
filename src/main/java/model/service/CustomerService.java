package model.service;

import model.Customer;
import model.dao.CustomerDAO;

public class CustomerService {
    private CustomerDAO customerDAO;

    public CustomerService() {
        this.customerDAO = new CustomerDAO();
    }

    public boolean registerCustomer(String email, String password, String name) {
        Customer customer = new Customer(email,password,name);
        try {
            int result = customerDAO.createCustomer(customer);
            return result > 0; // 성공적으로 생성되었는지 여부를 반환
        } catch (Exception e) {
            e.printStackTrace();
            return false; // 실패 시 false 반환
        }
    }
}