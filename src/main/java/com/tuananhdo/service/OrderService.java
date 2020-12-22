package com.tuananhdo.service;

import com.tuananhdo.entity.OrderProduct;

import java.util.List;
import java.util.Set;

public interface OrderService {

    OrderProduct save(OrderProduct order);

    List<OrderProduct> listAll(String search);

    void deleteOrder(long id);

    void saveAll(List<OrderProduct> orderProducts);

    OrderProduct getOrderById(long id);

    List<OrderProduct> findAll();
}
