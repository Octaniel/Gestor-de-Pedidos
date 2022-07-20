package com.octa.gestorpedidos.repository;

import com.octa.gestorpedidos.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
