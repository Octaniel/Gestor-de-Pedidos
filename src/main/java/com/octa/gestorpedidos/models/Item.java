package com.octa.gestorpedidos.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tb_item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
