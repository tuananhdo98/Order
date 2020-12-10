package com.tuananhdo.controller.admin;

import com.tuananhdo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AdminOrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/admin-order")
    public String adminOrder(Model model) {
        model.addAttribute("userOrder",orderService.listAll());
        return "admin/admin-order";
    }


    @GetMapping("/admin-deleteOrder/{id}")
    public String deleteOrder(@PathVariable("id") long id) {
        orderService.deleteOrder(id);
        return "redirect:/admin-order";
    }



}
