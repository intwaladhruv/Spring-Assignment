package com.ecommerce.admin.adminservice.service;

import com.ecommerce.admin.adminservice.entity.Orders;
import com.ecommerce.admin.adminservice.entity.Product;

import java.util.List;

public interface AdminService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createOrUpdateProduct(Product product);
    void deleteProduct(Long id);

    List<Orders> getAllOrders();
    Orders getOrderById(Long id);
}

