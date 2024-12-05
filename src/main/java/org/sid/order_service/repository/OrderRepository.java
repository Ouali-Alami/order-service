package org.sid.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<ProductItem, Long> {
    
}
