package com.tuananhdo.controller.web;

import com.tuananhdo.service.ProductService;
import com.tuananhdo.service.SpecialMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SpecialMenuService specialMenuService;

    @GetMapping("/")
    public String homeFood(ModelMap map){
        map.addAttribute("listProducts",productService.finAll());
        map.addAttribute("specialMenu",specialMenuService.findAll());
        return "web/web-home";

    }

    @GetMapping("/login")
    public String login(){
        return "web/login";
    }

    @GetMapping("/register")
    public String register(){
        return "web/register";
    }

    @GetMapping("/product-details")
    public String details(){
        return "web/product-details";
    }

    @GetMapping("/checkout")
    public String checkout(){
        return "web/checkout";
    }

    @GetMapping("/menu-list")
    public String menuList(){
        return "web/menu-list";
    }

    @GetMapping("/chicken")
    public String menuChicken(){
        return "web/menu-chicken";
    }

    @GetMapping("/about-us")
    public String aboutUs(){
        return "web/about-us";
    }
}
