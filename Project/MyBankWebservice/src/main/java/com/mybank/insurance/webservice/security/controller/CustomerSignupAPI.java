package com.mybank.insurance.webservice.security.controller;
import com.mybank.dao.insurance.entity.Customer;
import com.mybank.dao.insurance.remotes.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ResourceBundle;

@RestController
@RequestMapping("/profile")
@ComponentScan("com.mybank.dao.insurance")
public class CustomerSignupAPI {
    @Autowired
    CustomerRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    Logger logger= LoggerFactory.getLogger(CustomerSignupAPI.class);
    ResourceBundle resourceBundle = ResourceBundle.getBundle("app");

    @PostMapping("/register")
    public Customer save(@RequestBody Customer customer){
        logger.debug(resourceBundle.getString("security.password"));
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return repository.signingUp(customer);
    }
}
