package com.tuananhdo.controller.web;

import com.tuananhdo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductDetailController {


    @Autowired
    private ProductService productService;

    @GetMapping("/product-detail{id}")
    public String productDetails(ModelMap map, @PathVariable("id") int productId){
        map.addAttribute("product",productService.getProductById(productId));
        map.addAttribute("products",productService.finAll());
        return "web/product-details";
    }
}
