package spring.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import spring.demo.controller.CustomerController;
import spring.demo.controller.LoginController;
import spring.demo.controller.PayrollController;
import spring.demo.dao.CustomerDAO;
import spring.demo.dao.PayrollDao;
import spring.demo.entity.Payroll;
import spring.demo.entity.users;
import spring.demo.service.CustomerService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	CustomerService customerService;
	@MockBean
	PayrollDao payrollDao;
	@Mock
	Model model;
	@MockBean
	CustomerDAO customerDAO;
	@Mock
	BindingResult bResult;
	@Test
	public void getAccountsTest(){
		PayrollController payrollController=new PayrollController(customerService);
		String ac= payrollController.listAccounts(model);
		String ex="listAccounts";
		Assertions.assertEquals(ac,ex);

	}
	@Test
	public void updateAccountTest(){
		PayrollController payrollController=new PayrollController(customerService);
		int id=2;
		String ac= payrollController.doUpdate(id,model);
		String ex="salaryUpdateForm";
		Assertions.assertEquals(ac,ex);
	}
	@Test
	public void saveAccountTest(){
		Payroll payroll=new Payroll(3,3000);
		PayrollController payrollController=new PayrollController(customerService);
		String ac= payrollController.saveAccount(payroll,bResult);
		String ex;
		if(bResult.hasErrors()){
			 ex="AccontForm";
		}
		else {
			 ex = "redirect:/payroll/accounts";
		}
		Assertions.assertEquals(ac,ex);

	}
	@Test
	public void getEmployeeTest(){
		PayrollController payrollController=new PayrollController(customerService);

		int id=2;
		String ac= payrollController.showEmployee(id,model);
		String ex="empDetailForm";
		Assertions.assertEquals(ac,ex);
	}
	@Test
	public void getCustomersTest(){
//        when(customerDAO.getCustomers()).thenReturn(Stream.of(new users(2,"sahithi","sag",1,"role_emp","sahithi","pandiri"),new users(1,"sahithi","sag",1,"role_emp","sahithi","pandiri")).collect(Collectors.toList()));
//        assertEquals(2,customerService.getCustomers().size());
		CustomerController customerController=new CustomerController(customerService);
		String ac=customerController.listCustomers(model);
		String ex="listCustomers";
		Assertions.assertEquals(ex,ac);

	}
	@Test
	public  void addCustomerTest(){
		CustomerController customerController=new CustomerController(customerService);
		String ac=customerController.addCustomers(model);
		String ex="customerForm";
		Assertions.assertEquals(ac,ex);

	}
	@Test
	public void saveCustomerTest(){
		CustomerController customerController=new CustomerController(customerService);
		users user=new users(2,"sahithi","sag",1,"role_emp","sahithi","pandiri");
		String ac=customerController.saveCustomer(user,bResult);
		String ex="redirect:/customer/list";
		Assertions.assertEquals(ac,ex);
	}
	@Test
	public void updateCustomerTest(){
		CustomerController customerController=new CustomerController(customerService);
		int id=3;
		String ac=customerController.doUpdate(id,model);
		String ex="customerForm";
		Assertions.assertEquals(ac,ex);
	}
	@Test
	public void doDeleteTest(){
		CustomerController customerController=new CustomerController(customerService);
		int id=3;
		String ac=customerController.doDelete(3);
		String ex="redirect:/customer/list";
		Assertions.assertEquals(ac,ex);
	}
	@Test
	public  void empListTest(){
		CustomerController customerController=new CustomerController(customerService);
		String ac=customerController.empList(model);
		String ex= "empList";
		Assertions.assertEquals(ac,ex);

	}
	@Test
	public void getSingleEmployeeTest(){
		CustomerController customerController=new CustomerController(customerService);
		int id=3;
			String ac=customerController.getSingleEmployee(id,model);
		String ex="SinglecustomerUpdateForm";
		Assertions.assertEquals(ac,ex);
	}
	@Test
	public void saveCustomer1Test(){
		CustomerController customerController=new CustomerController(customerService);
		int id=3;
		users user=new users(2,"sahithi","sag",1,"role_emp","sahithi","pandiri");
		String ac=customerController.saveCustomer1(user,bResult,model);
		String ex="empList1";
		Assertions.assertEquals(ac,ex);
	}
	@Test
	public void addCustomerAccountTest(){
		CustomerController customerController=new CustomerController(customerService);
		String ac=customerController.addCustomerAccount(model);
		String ex="AccontForm";
		Assertions.assertEquals(ac,ex);
	}
	@Test
	public void saveAccount1Test(){
		Payroll payroll=new Payroll(3,3000);
		PayrollController payrollController=new PayrollController(customerService);
		String ac= payrollController.saveAccount(payroll,bResult);
		String ex="redirect:/payroll/accounts";
		Assertions.assertEquals(ac,ex);
	}
	@Test
	public void getSingleEmployeeDetailsTest(){
		CustomerController customerController=new CustomerController(customerService);
		String name="sahithi";
		String ac=customerController.getDetails(name,model);
		String ex="systems";
		Assertions.assertEquals(ac,ex);
	}

	@Test
	public void loginPage()
	{
		LoginController loginController = new LoginController();
		String actual = loginController.showLoginPage();
		String expected = "login_page";
		Assertions.assertEquals(expected,actual);
	}
	@Test
	public void accessPage()
	{
		LoginController loginController = new LoginController();
		String actual = loginController.accessDenied();
		String expected = "accessDenied";
		Assertions.assertEquals(expected,actual);
	}
	@Test
	@WithMockUser(username = "Meghana123" , authorities = {"ROLE_EMPLOYEE"})
	public void EmployeeHomePage() throws Exception {
		LoginController loginController = new LoginController();
		String actual = loginController.showHome();
		String expected = "home";
		Assertions.assertEquals(expected, actual);

	}
	@Test
	@WithMockUser(username = "Keerthana121" , authorities = {"ROLE_ADMIN"})
	public void AdminHomePage() throws Exception {
		LoginController loginController = new LoginController();
		String actual = loginController.showHome();
		String expected = "home";
		Assertions.assertEquals(expected,actual);
	}
	@Test
	@WithMockUser(username = "Sahithi121" , authorities = {"ROLE_MANAGER"})
	public void ManagerHomePage() throws Exception {
		LoginController loginController = new LoginController();
		String actual = loginController.showHome();
		String expected = "home";
		Assertions.assertEquals(expected,actual);
	}





}
