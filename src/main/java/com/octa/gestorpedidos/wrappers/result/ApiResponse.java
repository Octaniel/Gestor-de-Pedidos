package com.octa.gestorpedidos.wrappers.result;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ApiResponse<T> implements Serializable {

    private HttpStatus status = HttpStatus.OK;
    private String message;
    private List<String> messages = new ArrayList<>();
    private T data;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ApiResponse(@JsonProperty("status") HttpStatus status,
                       @JsonProperty("message") String message,
                       @JsonProperty("messages") ArrayList<String> messages ,
                       @JsonProperty("data") T data) {
        this.status = status;
        this.message = message;
        this.messages = messages;
        this.data = data;
    }

    public ApiResponse(T data) {
        this.messages = new ArrayList<>();
        this.message = "Operation performed successfully.";
        this.data = data;
    }

    public ApiResponse(T data, String message) {
        this.messages = new ArrayList<>();
        this.message = message;
        this.data = data;
    }

    public ApiResponse(HttpStatus status, T data){
        this.status = status;
        this.messages = new ArrayList<>();
        this.message = "Operation performed successfully.";
        this.data = data;
    }

    public ApiResponse(ArrayList<String> messages) {
        this.status = HttpStatus.BAD_REQUEST;
        this.messages = messages;
        this.message = "";
        this.data = null;
    }

    public ApiResponse(String message, ArrayList<String> messages) {
        this.status = HttpStatus.BAD_REQUEST;
        this.messages = messages;
        this.message = message;
        this.data = null;
    }

    public ApiResponse(BindingResult bindingResult) {
        this.status = HttpStatus.BAD_REQUEST;
        this.data = null;
        List<String> errors = bindingResult.getAllErrors().stream().
                map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        this.messages.addAll(errors);
        this.message = "";
    }

    public ApiResponse(HttpStatus status, T data, ArrayList<String> messages) {
        this.status = status;
        this.messages = messages;
        this.data = data;
        this.message = "Operation performed successfully.";
    }

    public ApiResponse(HttpStatus status) {
        this.status = status;
        this.messages = new ArrayList<>();
        this.data = null;
        this.message = "";
    }

    public ApiResponse(HttpStatus status, String message) {
        this.status = status;
        this.messages = new ArrayList<>();
        this.data = null;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
