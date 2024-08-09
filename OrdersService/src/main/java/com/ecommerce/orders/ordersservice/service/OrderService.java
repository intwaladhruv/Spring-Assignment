package com.ecommerce.orders.ordersservice.service;

import com.ecommerce.orders.ordersservice.entity.Orders;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Orders> getAllOrders();
    Optional<Orders> getOrderById(Long id);
    Orders saveOrder(Orders order);
    void deleteOrderById(Long id);
}

