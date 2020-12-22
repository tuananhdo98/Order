package com.tuananhdo.controller.web;

import com.tuananhdo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;

@Controller
public class FindOrderController {

    @Autowired
    private OrderRepository orderRepository;


    @GetMapping("/findOrderPhone")
    public String findOrder(Model model, @Param("phone") String phone) {
        if (phone != null) {
            model.addAttribute("findOrders", orderRepository.getOrderProductByPhoneNumber(phone));
        }else {
            return "web/order-details";
        }
        return "web/order-details";
    }
}