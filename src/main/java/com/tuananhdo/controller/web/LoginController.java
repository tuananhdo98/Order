package com.tuananhdo.controller.web;

import com.tuananhdo.entity.OrderProduct;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "web/login";
    }

    @GetMapping("/login-checkout")
    public String logincheckout(ModelMap map, HttpSession session) {
        map.put("VAT",CheckOutController.VAT(session));
        map.put("totalItem", CartController.totalItem(session));
        map.put("shiping",CheckOutController.Shiping());
        map.put("totalOrder",CheckOutController.totalItemOrder(session));
        map.addAttribute("orderProduct", new OrderProduct());
        return "web/checkout";
    }

    @GetMapping("/403")
    public String Eror403() {
        return "web/403";
    }

}
