package com.ecommerce.orders.ordersservice.service;

import com.ecommerce.orders.ordersservice.entity.Orders;
import com.ecommerce.orders.ordersservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    private final StreamBridge streamBridge;

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

    @Override
    public Orders placeOrder(Orders order) {
        order.setOrderDate(LocalDateTime.now());
        orderRepository.save(order);
        System.out.println("Order saved");

        OrderPlacedEvent event = new OrderPlacedEvent(order);
        streamBridge.send("orderPlaced-out-0", event);
        System.out.println("Order placed");

        return order;
    }
}

