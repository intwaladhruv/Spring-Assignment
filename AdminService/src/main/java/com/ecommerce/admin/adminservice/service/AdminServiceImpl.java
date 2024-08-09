package com.ecommerce.admin.adminservice.service;

import com.ecommerce.admin.adminservice.entity.Orders;
import com.ecommerce.admin.adminservice.entity.Product;
import com.ecommerce.admin.adminservice.repository.OrderRepository;
import com.ecommerce.admin.adminservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    private ProductRepository productRepository;

    private OrderRepository orderRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createOrUpdateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Orders> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Orders getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}

