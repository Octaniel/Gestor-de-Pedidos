package com.octa.gestorpedidos.exceptions;

import com.octa.gestorpedidos.wrappers.result.ApiResponse;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {
    Logger logger = LoggerFactory.getLogger(CustomRestExceptionHandler.class);

    @ExceptionHandler({RestException.class})
    public ResponseEntity<Object> handleRestException(RestException ex, WebRequest request) {
        ApiResponse<String> apiResponse = new ApiResponse<>(HttpStatus.BAD_REQUEST);
        apiResponse.setMessage(ex.getMessage());
        logger.error(ex.getMessage());
        List<ApiResponse<String>> erros = Collections.singletonList(apiResponse);
        return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}