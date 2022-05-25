package spring.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/showMyLoginPage")
    public String showLoginPage(){

        return "login_page";
    }
    @GetMapping("/access-denied")
    public String accessDenied(){

        return "accessDenied";
    }
    @GetMapping("/")
    public String showHome() {

        return "home";
    }

}
