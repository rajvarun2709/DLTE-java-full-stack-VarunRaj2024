package com.mybank.dao.insurance;

import com.mybank.dao.insurance.exceptions.InsuranceAvailableException;

import com.mybank.dao.insurance.remotes.InsuranceAvailableDbRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLSyntaxErrorException;

@SpringBootApplication
public class InsurancedaoApplication {

    public static void main(String[] args) throws SQLSyntaxErrorException {
        //SpringApplication.run(InsurancedaoApplication.class, args);
        ConfigurableApplicationContext context = SpringApplication.run(InsurancedaoApplication.class, args);

        InsuranceAvailableDbRepo availableDbRepo = context.getBean(InsuranceAvailableDbRepo.class);
        try {
            System.out.println(availableDbRepo.callAllInsuranceAvailable());
        } catch (InsuranceAvailableException exception) {
            System.out.println(exception);
        }
    }

}

