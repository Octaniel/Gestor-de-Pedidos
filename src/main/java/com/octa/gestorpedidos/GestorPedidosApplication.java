package com.octa.gestorpedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class GestorPedidosApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestorPedidosApplication.class, args);
    }

}
