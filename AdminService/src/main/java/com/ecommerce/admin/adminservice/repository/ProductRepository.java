package com.ecommerce.admin.adminservice.repository;


import com.ecommerce.admin.adminservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
