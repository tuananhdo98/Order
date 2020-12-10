package com.tuananhdo.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CheckOrderDetalsController {


    @GetMapping("/checkorder-details")
    public String checkOrderDetailsbyEmail(){
        return "web/order-details";
    }
}
