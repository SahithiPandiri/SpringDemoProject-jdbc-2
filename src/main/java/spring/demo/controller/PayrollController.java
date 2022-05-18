package spring.demo.controller;

import spring.demo.entity.users;
import spring.demo.entity.Payroll;
import spring.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/payroll")
public class  PayrollController {
    private CustomerService payrollService;
    @Autowired
   public PayrollController(CustomerService payrollService){
       this.payrollService=payrollService;
    }

    @RequestMapping("/accounts")
    public String listAccounts(Model model)
    {
        List<Payroll> theAccounts=payrollService.getAccounts();
        model.addAttribute("accounts",theAccounts);
        return "listAccounts";
    }
    @RequestMapping("/showFormForUpdateAccount")
    public String doUpdate(@RequestParam("EmpId") int id, Model model)
    {
        Payroll tempEmp=payrollService.getAccount(id);
        model.addAttribute("Employee",tempEmp);
        return "salaryUpdateForm";
    }
    @RequestMapping("/saveAccount")
    public String saveAccount(@ModelAttribute("Employee") Payroll account)
    {
        payrollService.saveAccount(account);
        return "redirect:/payroll/accounts";
    }
    @RequestMapping("/employeeDetails")
    public String showEmployee(@RequestParam("EmpId") int id, Model model)
    {
        users tempEmp=payrollService.getCustomer(id);
        model.addAttribute("tempCustomer",tempEmp);
        return "empDetailForm";
    }
}
