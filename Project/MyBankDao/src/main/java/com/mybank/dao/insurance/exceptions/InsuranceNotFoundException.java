package com.mybank.dao.insurance.exceptions;

public class InsuranceNotFoundException extends RuntimeException {
    public InsuranceNotFoundException(String message){
        super(message);
    }
}
