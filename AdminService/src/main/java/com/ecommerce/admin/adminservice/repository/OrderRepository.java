package com.ecommerce.admin.adminservice.repository;

import com.ecommerce.admin.adminservice.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    // Custom query methods (if needed)
}
