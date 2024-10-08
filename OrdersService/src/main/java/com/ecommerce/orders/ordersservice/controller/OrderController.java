package com.ecommerce.orders.ordersservice.controller;

import com.ecommerce.orders.ordersservice.entity.Orders;
import com.ecommerce.orders.ordersservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Orders> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long id) {
        Optional<Orders> order = orderService.getOrderById(id);
        return order.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrderById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/place")
    public ResponseEntity<Orders> placeOrder(@RequestBody Orders order) {
        Orders savedOrder = orderService.placeOrder(order);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }
}

