package com.tuananhdo.controller.web;

import com.tuananhdo.entity.OrderDetails;
import com.tuananhdo.entity.Product;
import com.tuananhdo.entity.OrderProduct;
import com.tuananhdo.entity.User;
import com.tuananhdo.model.OrderDTO;
import com.tuananhdo.model.OrderItemDTO;
import com.tuananhdo.service.OrderService;
import com.tuananhdo.service.OrderDetailsService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CheckOutController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailsService orderDetailsService;

    @GetMapping(value = "/checkout")
    public String cart(Authentication authentication, Model model) {
//        if (authentication == null) {
//            return "web/login";
//        } else {
        model.addAttribute("orderProduct", new OrderProduct());
        return "web/checkout";
//        }
    }


    @PostMapping(value = "/checkoutPost")
    public String checkoutPost(HttpSession session, OrderProduct orderProduct) {
        if (session.getAttribute("cart") != null) {
            OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
            OrderDetails orderDetails = new OrderDetails();
            List<OrderItemDTO> orderItemDTOS = orderDTO.getItemDTOS();
            for (OrderItemDTO orderItemDTO : orderItemDTOS) {
                orderProduct.setId(orderItemDTO.getProductDTO().getId());
                orderProduct.setName(orderItemDTO.getProductDTO().getName());
                orderProduct.setStatus(true);
                orderService.save(orderProduct);
                orderDetails.setId(orderItemDTO.getProductDTO().getId());
                orderDetails.setProduct(orderItemDTO.getProductDTO());
                orderDetails.setNumberOrder(orderItemDTO.getNumber());
                orderDetails.setPriceOrder(orderItemDTO.getProductDTO().getPrice());
                orderDetailsService.save(orderDetails);
            }
            session.removeAttribute("cart");
        }
        return "web/checksuccess";
    }


}
