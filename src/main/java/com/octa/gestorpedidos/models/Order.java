package com.octa.gestorpedidos.models;

import com.octa.gestorpedidos.wrappers.dto.OrderDto;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tb_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime creationDate;
    @OneToOne
    private Item item;
    @OneToOne
    private User user;
}
