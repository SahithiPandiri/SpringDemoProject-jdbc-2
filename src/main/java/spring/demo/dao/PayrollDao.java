package spring.demo.dao;

import spring.demo.entity.Payroll;

import java.util.List;

public interface PayrollDao {
    public List<Payroll>  getAccounts();
    public Payroll getEmployee(int id);
    public String saveAccount(Payroll payroll);
}
