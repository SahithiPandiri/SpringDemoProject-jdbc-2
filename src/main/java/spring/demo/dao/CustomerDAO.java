package spring.demo.dao;

import spring.demo.entity.users;

import java.util.List;

public interface CustomerDAO {
    List<users> getCustomers();

    void saveCustomer(users theUsers);

    users getCustomer(int id);

    void deleteCustomer(int id);
    void saveCustomer1(users theUsers, String  pass);
    users getCustomer(String username);

    void saveCustomer3(users theUsers, String uname, String fname, String lname);
}
