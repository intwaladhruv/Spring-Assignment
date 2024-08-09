package com.ecommerce.products.productsservice.repository;


import com.ecommerce.products.productsservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
