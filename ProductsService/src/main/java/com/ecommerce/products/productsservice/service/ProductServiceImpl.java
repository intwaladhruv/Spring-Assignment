package com.ecommerce.products.productsservice.service;

import com.ecommerce.products.productsservice.entity.Product;
import com.ecommerce.products.productsservice.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Bean
    public Consumer<OrderPlacedEvent> orderPlacedEventConsumer() {
        return event -> {
            System.out.println("Received OrderPlacedEvent: " + event);
//            updateProductStock(event);
        };
    }
}

