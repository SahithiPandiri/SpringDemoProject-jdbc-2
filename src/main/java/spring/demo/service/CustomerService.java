package spring.demo.service;

import spring.demo.entity.users;
import spring.demo.entity.Payroll;

import java.util.List;

public interface CustomerService {
    List<users> getCustomers();

    void saveCustomer1(users theUsers, String pass);

    users getCustomer(int id);

    void deleteCustomer(int id);
    public List<Payroll> getAccounts();
    public Payroll getAccount(int id);
    public String saveAccount(Payroll payroll);
    void saveCustomer(users theUsers);
    users getCustomer(String username);

    void saveCustomer3(users theUsers, String uname, String fname, String lname);
}
