package com.octa.gestorpedidos.exceptions;

public class RestException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RestException(String mensagem) {
        super(mensagem);
    }
}
