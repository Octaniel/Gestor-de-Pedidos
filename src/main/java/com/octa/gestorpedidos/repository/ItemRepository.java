package com.octa.gestorpedidos.repository;

import com.octa.gestorpedidos.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
