package com.tuananhdo.controller.admin;

import com.tuananhdo.entity.OrderProduct;
import com.tuananhdo.model.OrderStatus;
import com.tuananhdo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminOrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/admin-order")
    public String adminOrder(Model model, @RequestParam(value = "search", required = false) String search) {
        model.addAttribute("userOrder", orderService.listAll(search));
        model.addAttribute("search", search);
        model.addAttribute("orderStatus", OrderStatus.values());
        return "admin/admin-order";
    }


    @GetMapping("/admin-deleteOrder/{id}")
    public String deleteOrder(@PathVariable("id") long id) {
        orderService.deleteOrder(id);
        return "redirect:/admin-order";
    }

    @GetMapping("/editOrder/{id}")
    public String editOrder(@PathVariable("id") long id, ModelMap map) {
        map.addAttribute("editOrder", orderService.getOrderById(id));
        map.addAttribute("orderStatus", OrderStatus.values());
        return "admin/admin-edit-order";
    }

    @PostMapping("/editOrder")
    public String editOrder(ModelMap map, @ModelAttribute("editOrder") OrderProduct orderProduct) {
        map.addAttribute("editOrder", orderService.save(orderProduct));
        return "redirect:/admin-order";
    }


    @GetMapping("/admin-order-details/{id}")
    public String orderDetails(@PathVariable("id") long id, Model model) {
        model.addAttribute("orderDetails", orderService.getOrderById(id));
        model.addAttribute("products", orderService.findAll());
        return "admin/admin-order-detail";
    }

}
