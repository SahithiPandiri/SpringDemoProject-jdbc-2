package spring.demo.service;

import spring.demo.dao.CustomerDAO;
import spring.demo.dao.PayrollDao;
import spring.demo.entity.users;
import spring.demo.entity.Payroll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    public CustomerDAO customerDAO;
    @Autowired
public PayrollDao payrollDao;

    @Override
    @Transactional
    public List<users> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer1(users theUsers, String pass) {
     customerDAO.saveCustomer1(theUsers,pass);
    }

    @Override
    @Transactional
    public users getCustomer(int id) {

        return customerDAO.getCustomer(id) ;
    }
    @Override
    @Transactional
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }


    @Override
    @Transactional
    public List<Payroll> getAccounts() {
        return payrollDao.getAccounts();
    }

    @Override
    @Transactional
    public Payroll getAccount(int id) {
        return payrollDao.getEmployee(id) ;
    }

    @Override
    @Transactional
    public String saveAccount(Payroll payroll) {
        return payrollDao.saveAccount(payroll);
    }

    @Override
    @Transactional
    public void saveCustomer(users theUsers) {
        customerDAO.saveCustomer(theUsers);
    }

    @Override
    @Transactional
    public users getCustomer(String username) {
      return  customerDAO.getCustomer(username);
    }

    @Override
    @Transactional
    public void saveCustomer3(users theUsers, String uname, String fname, String lname) {
        customerDAO.saveCustomer3(theUsers,uname,fname,lname);
    }
}
