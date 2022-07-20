package com.octa.gestorpedidos.repository;

import com.octa.gestorpedidos.models.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockMovementRepository extends JpaRepository<StockMovement, Long> {
}
