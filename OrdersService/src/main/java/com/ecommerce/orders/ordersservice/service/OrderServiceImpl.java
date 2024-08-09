package com.ecommerce.orders.ordersservice.service;

import com.ecommerce.orders.ordersservice.entity.Orders;
import com.ecommerce.orders.ordersservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Override
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Orders> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Orders saveOrder(Orders order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }
}

