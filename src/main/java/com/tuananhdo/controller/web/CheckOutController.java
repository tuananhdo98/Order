package com.tuananhdo.controller.web;

import com.tuananhdo.entity.OrderDetails;
import com.tuananhdo.entity.OrderProduct;
import com.tuananhdo.entity.Product;
import com.tuananhdo.model.OrderDTO;
import com.tuananhdo.model.OrderItemDTO;
import com.tuananhdo.model.OrderStatus;
import com.tuananhdo.service.OrderDetailsService;
import com.tuananhdo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        map.put("totalOrder", totalItemOrder(session));
        map.addAttribute("orderStatus", OrderStatus.values());
        if (authentication == null) {
            return "web/login-checkout";
        } else {
            OrderProduct orderProduct = new OrderProduct();
            map.addAttribute("orderProduct", orderProduct);
            return "web/checkout";
        }

    }


    @PostMapping(value = "/checkoutPost")
    public String checkoutPost(HttpSession session, @Valid OrderProduct orderProductSession, BindingResult bindingResult, ModelMap map, Product product) {
        if (bindingResult.hasErrors()) {
            map.put("VAT", VAT(session));
            map.put("shiping", Shiping());
            map.put("totalOrder", totalItemOrder(session));
            return "web/checkout";
        } else {
            if (session.getAttribute("cart") != null) {
                OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
                List<OrderItemDTO> orderItemDTOS = orderDTO.getItemDTOS();
                for (OrderItemDTO orderItemDTO : orderItemDTOS) {
                    orderProductSession.setId(orderItemDTO.getProductDTO().getId());
                    orderProductSession.setDateOrder(new Timestamp(System.currentTimeMillis()));
                    orderProductSession.setNameOrder(orderItemDTO.getProductDTO().getName());
                    orderProductSession.setOrderStatus(OrderStatus.DANG_XU_LY);
                    orderProductSession.setIntoMoney((int) (orderItemDTO.getNumber() * orderItemDTO.getProductDTO().getPrice()));
                    orderProductSession.setGetImg(orderItemDTO.getProductDTO().getImageUrl());
                    orderProductSession.setTotalOrder((int) ((int) CartController.totalItem(session) + VAT(session) + Shiping()));
                    orderProductSession.setOrderNumber(orderItemDTO.getNumber());
                    orderProductSession.setVat((int) VAT(session));
                    orderProductSession.setShiping((int) Shiping());
                    orderProductSession.setTotalNumberOrder((int) TotalNumber(session));
                    List<OrderProduct> orderProducts = new ArrayList<>();
                    orderService.saveAll(orderProducts);
                    OrderDetails orderDetails = new OrderDetails();
                    orderDetails.setId(orderItemDTO.getProductDTO().getId());
                    orderDetails.setOrderProduct(orderProductSession);
                    orderDetails.setProduct(orderItemDTO.getProductDTO());
                    orderDetailsService.save(orderDetails);

                }
                session.removeAttribute("cart");
            }
            return "web/checksuccess";
        }
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

    public static long TotalNumber(HttpSession session) {
        OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
        List<OrderItemDTO> orderItemDTOS = orderDTO.getItemDTOS();
        long TotalNumber = 0;
        for (OrderItemDTO orderItemDTO : orderItemDTOS) {
            TotalNumber += orderItemDTO.getNumber();
        }
        return TotalNumber;
    }

    public static long Shiping() {
        return 40000;
    }

    public static long totalItemOrder(HttpSession session) {
        OrderDTO orderDTO = (OrderDTO) session.getAttribute("cart");
        List<OrderItemDTO> orderItemDTOS = orderDTO.getItemDTOS();
        long totalItem = 0;
        for (OrderItemDTO orderItemDTO : orderItemDTOS) {
            totalItem += orderItemDTO.getNumber() * orderItemDTO.getProductDTO().getPrice() + Shiping() + VAT(session);
        }
        return totalItem;
    }

}
