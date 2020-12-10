package com.tuananhdo.service.impl;

import com.tuananhdo.entity.OrderProduct;
import com.tuananhdo.repository.OrderRepository;
import com.tuananhdo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderSerivceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void deleteOrder(long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<OrderProduct> listAll() {
        return orderRepository.findAll();
    }

    @Override
    public OrderProduct save(OrderProduct order) {
       return orderRepository.save(order);
    }
}

