package spring.demo.controller;

import org.springframework.validation.BindingResult;
import spring.demo.entity.users;
import spring.demo.entity.Payroll;
import spring.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.validation.Valid;
import java.io.PrintStream;
import java.util.List;
@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    public CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/list")
    public String listCustomers(Model model)
    {
        List<users> theUsers =customerService.getCustomers();
        model.addAttribute("customers", theUsers);
        return "listCustomers";
    }
    @RequestMapping("/showFormForAdd")
    public String addCustomers(Model model)
    {
        users theUsers =new users();
        model.addAttribute("customer", theUsers);
        return "customerForm";
    }
   @RequestMapping("/saveCustomerReg")
    //@PostMapping("/saveCustomer")
    public String saveCustomer(@Valid @ModelAttribute("customer") users theUsers ,BindingResult bindingResult )
    {
        if(bindingResult.hasErrors()){
            return "customerForm";
        }
        String pass= theUsers.getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    customerService.saveCustomer1(theUsers,encoder.encode(pass));
        return "redirect:/customer/list";
    }
    @RequestMapping("/showFormForUpdate")
    public String doUpdate( @RequestParam("customerId") int id, Model model)
    {
        users tempUsers =customerService.getCustomer(id);
        model.addAttribute("customer", tempUsers);
        return "customerForm";
    }
    @RequestMapping("/delete")
    public String doDelete(@RequestParam("customerId") int id)
    {
        customerService.deleteCustomer(id);
        return "redirect:/customer/list";
    }
    @RequestMapping("/empList")
    public String empList(Model model)
    {
        List<users> theUsers =customerService.getCustomers();
        model.addAttribute("customers", theUsers);
        return "empList";
    }
    @RequestMapping("/getSingleEmployee")
    public String getSingleEmployee(@RequestParam("user_id") int id ,Model model1){

        users user1 =customerService.getCustomer(id);

        model1.addAttribute("user2", user1);
        return "SinglecustomerUpdateForm";
    }
    @RequestMapping("/saveCustomer1")
    public String saveCustomer1(@Valid @ModelAttribute("user2") users theUsers,BindingResult bindingResult, Model model)
    {
       if(bindingResult.hasErrors()){
           System.out.println("in binding error");
           System.out.println(theUsers);
           return "SinglecustomerUpdateForm";
       }
        customerService.saveCustomer(theUsers);
        model.addAttribute("user", theUsers);
        return "empList1";
    }
    @RequestMapping("/showFormForAddAccount")
    public String addCustomerAccount(Model model)
    {
        Payroll theAccount=new Payroll();
        model.addAttribute("account",theAccount);
        return "AccontForm";
    }
    @RequestMapping("/saveAccount")
    //@PostMapping("/saveCustomer")
    public String saveAccount( @Valid @ModelAttribute("account")  Payroll theAccount,BindingResult bindingResult)
    {
        if(bindingResult.hasErrors()){
            System.out.println("has errors");
            return "AccontForm";
        }

        customerService.saveAccount(theAccount);
        return "redirect:/payroll/accounts";
    }
    @RequestMapping("/saveCustomer")
    //@PostMapping("/saveCustomer")
    public String saveCustomer1(@ModelAttribute("customer") users theUsers)
    {
        String pass= theUsers.getPassword();
        customerService.saveCustomer(theUsers);
        return "redirect:/customer/list";
    }
    @RequestMapping("/getMyDetails")
    public String getDetails(@RequestParam("user_name") String name, Model model)
    {
       users list= customerService.getCustomer(name);
       model.addAttribute("tempAccount",list);

       return "systems";
    }

}
