package com.ecommerce.products.productsservice.service;


import com.ecommerce.products.productsservice.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public interface ProductService {
    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    Product saveProduct(Product product);
    void deleteProductById(Long id);
    Consumer<OrderPlacedEvent> orderPlacedEventConsumer();
}

