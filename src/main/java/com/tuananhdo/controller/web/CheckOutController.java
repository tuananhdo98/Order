package com.tuananhdo.controller.web;

import com.tuananhdo.entity.OrderDetails;
import com.tuananhdo.entity.OrderProduct;
import com.tuananhdo.model.OrderDTO;
import com.tuananhdo.model.OrderItemDTO;
import com.tuananhdo.service.OrderDetailsService;
import com.tuananhdo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class CheckOutController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailsService orderDetailsService;

    @GetMapping(value = "/checkout")
    public String cart(Authentication authentication, ModelMap map, HttpSession session) {
        map.put("VAT", VAT(session));
        map.put("totalItem", CartController.totalItem(session));
        map.put("shiping", Shiping());
        map.put("totalOrder",totalItemOrder(session));
        if (authentication == null) {
            return "web/login-checkout";
        }
        else {
            map.addAttribute("orderProduct", new OrderProduct());
            return "web/checkout";
        }
    }


    @PostMapping(value = "/checkoutPost")
    public String checkoutPost(HttpSession session, OrderProduct orderProduct, ModelMap map) {
        if (session.getAttribute("cart") != null) {
            OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
            List<OrderItemDTO> orderItemDTOS = orderDTO.getItemDTOS();
            for (OrderItemDTO orderItemDTO : orderItemDTOS) {
                orderProduct.setId(orderItemDTO.getProductDTO().getId());
                orderProduct.setDateOrder(new Timestamp(System.currentTimeMillis()));
                orderProduct.setNameOrder(orderItemDTO.getProductDTO().getName());
                orderProduct.setStatus(true);
                orderProduct.setIntoMoney((int) (orderItemDTO.getNumber() * orderItemDTO.getProductDTO().getPrice()));
                orderProduct.setGetImg(orderItemDTO.getProductDTO().getImageUrl());
                orderProduct.setTotalOrder((int) CartController.totalItem(session));
                orderProduct.setTotalNumber(orderItemDTO.getNumber());
                orderService.save(orderProduct);
                OrderDetails orderDetails = new OrderDetails();
                orderDetails.setId(orderItemDTO.getProductDTO().getId());
//                orderDetails.setNumberDetails(orderItemDTO.getNumber());
                orderDetailsService.save(orderDetails);
            }
            session.removeAttribute("cart");
        }
        return "web/checksuccess";
    }


    public static long VAT(HttpSession session) {
        OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
        List<OrderItemDTO> orderItemDTOS = orderDTO.getItemDTOS();
        long VAT = 0;
        for (OrderItemDTO orderItemDTO : orderItemDTOS) {
            VAT += orderItemDTO.getNumber() * orderItemDTO.getProductDTO().getPrice() / 10;
        }
        return VAT;
    }

    public static long Shiping() {
        return 40000;
    }

    public static long totalItemOrder(HttpSession session) {
        OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
        List<OrderItemDTO> orderItemDTOS = orderDTO.getItemDTOS();
        long totalItem = 0;
        for (OrderItemDTO orderItemDTO : orderItemDTOS){
            totalItem += orderItemDTO.getNumber() * orderItemDTO.getProductDTO().getPrice() + Shiping() + VAT(session);
        }
        return totalItem;
    }

}
