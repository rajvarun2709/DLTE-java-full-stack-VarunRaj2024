package com.mybank.dao.insurance.exceptions;

public class CustomerException extends RuntimeException {
    public CustomerException(String message){
        super(message);
    }
}
