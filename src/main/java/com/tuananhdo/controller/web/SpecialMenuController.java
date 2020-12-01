package com.tuananhdo.controller.web;

import com.tuananhdo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpecialMenuController {

    @Autowired
    private ProductService productService;

//    @GetMapping("/")
//    public String homeFood(ModelMap map){
//        map.addAttribute("specialMenu",productService.finAll());
//        return "web/web-home";
//
//    }
}
