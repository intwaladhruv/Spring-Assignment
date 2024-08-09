package com.ecommerce.admin.adminservice.controller;

import com.ecommerce.admin.adminservice.entity.Orders;
import com.ecommerce.admin.adminservice.entity.Product;
import com.ecommerce.admin.adminservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // Product management endpoints

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return adminService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = adminService.getProductById(id);
        return product != null ? ResponseEntity.ok(product) : ResponseEntity.notFound().build();
    }

    @PostMapping("/products")
    public Product createOrUpdateProduct(@RequestBody Product product) {
        return adminService.createOrUpdateProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        adminService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    // Order management endpoints

    @GetMapping("/orders")
    public List<Orders> getAllOrders() {
        return adminService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long id) {
        Orders order = adminService.getOrderById(id);
        return order != null ? ResponseEntity.ok(order) : ResponseEntity.notFound().build();
    }
}

