package com.octa.gestorpedidos.repository;

import com.octa.gestorpedidos.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
