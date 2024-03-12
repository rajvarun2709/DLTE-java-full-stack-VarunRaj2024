package org.example;

import java.util.ResourceBundle;

public class MyBankCreditCardException extends RuntimeException {
    MyBankCreditCardException(String message){
        super(String.valueOf(ResourceBundle.getBundle(message)));
    }
}