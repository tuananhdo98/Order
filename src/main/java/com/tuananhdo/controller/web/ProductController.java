package com.tuananhdo.controller.web;

import com.tuananhdo.service.OrderService;
import com.tuananhdo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("/")
    public String homeFood(ModelMap map){
        map.addAttribute("listProducts",productService.finAll());
        return "web/web-home";

    }

    @GetMapping("/product-details")
    public String details(){
        return "web/product-details";
    }


    @GetMapping("/menu-list")
    public String menuList(ModelMap map){
        map.addAttribute("menuList",productService.finAll());
        return "web/menu-list";
    }

    @GetMapping("/about-us")
    public String aboutUs(){
        return "web/about-us";
    }
}
