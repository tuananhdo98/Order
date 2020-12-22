package com.tuananhdo.service.impl;

import com.tuananhdo.entity.OrderProduct;
import com.tuananhdo.repository.OrderRepository;
import com.tuananhdo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

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
    public OrderProduct getOrderById(long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public List<OrderProduct> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void saveAll(List<OrderProduct> orderProducts) {
        orderRepository.saveAll(orderProducts);
    }

    @Override
    public List<OrderProduct> listAll(String search) {
        if (search != null) {
            return orderRepository.findAll(search);
        }
        return orderRepository.findAll();
    }

    @Override
    public OrderProduct save(OrderProduct order) {
        return orderRepository.save(order);
    }
}

