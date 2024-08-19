package com.kcc.restfulservice.exception;

public class UserNotFoundException extends RuntimeException{

    //2xx -> ok
    //3xx -> redirect
    //4xx -> client
    //500 -> server

    public UserNotFoundException(String message) {
        super(message);
    }
}
