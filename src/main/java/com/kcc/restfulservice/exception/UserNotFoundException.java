package com.kcc.restfulservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{

    //2xx -> ok
    //3xx -> redirect
    //4xx -> client
    //500 -> server
    public UserNotFoundException(String message) {
        super(message);
    }
}
