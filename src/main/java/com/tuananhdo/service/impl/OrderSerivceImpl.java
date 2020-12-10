package com.tuananhdo.service.impl;

import com.tuananhdo.entity.OrderProduct;
import com.tuananhdo.repository.OrderRepository;
import com.tuananhdo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderSerivceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderProduct save(OrderProduct order) {
       return orderRepository.save(order);
    }
}
