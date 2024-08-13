package com.ecommerce.products.productsservice.service;

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
}
