package com.tuananhdo.service;

import com.tuananhdo.entity.OrderProduct;

import java.util.List;

public interface OrderService {

    OrderProduct save(OrderProduct order);

    List<OrderProduct> listAll();

    void deleteOrder(long id);
}
