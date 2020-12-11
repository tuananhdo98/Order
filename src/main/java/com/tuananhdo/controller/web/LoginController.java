package com.tuananhdo.controller.web;

import com.tuananhdo.entity.OrderProduct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "web/login";
    }

    @GetMapping("/login-checkout")
    public String logincheckout(Model model) {
        model.addAttribute("orderProduct", new OrderProduct());
        return "web/checkout";
    }

    @GetMapping("/403")
    public String Eror403() {
        return "web/403";
    }

}
