package com.ecommerce.orders.ordersservice.service;

import com.ecommerce.orders.ordersservice.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderPlacedEvent {
    private Long orderId;
    private List<Long> productIds;
    private List<Integer> quantities;
    private float totalPrice;
    private String orderDate;

    public OrderPlacedEvent(Orders order) {
        this.orderId = order.getId();
        this.productIds = order.getProductIds();
        this.quantities = order.getQuantities();
        this.totalPrice = order.getTotalPrice();
        this.orderDate = order.getOrderDate().toString();
    }

}
