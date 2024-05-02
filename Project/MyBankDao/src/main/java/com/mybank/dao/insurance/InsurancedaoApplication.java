package com.mybank.dao.insurance;

import com.mybank.dao.insurance.entity.InsuranceAvailable;
import com.mybank.dao.insurance.exceptions.InsuranceAvailableException;

import com.mybank.dao.insurance.remotes.InsuranceAvailableDbRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.Optional;

@SpringBootApplication
public class InsurancedaoApplication {

//    public static void main(String[] args) throws SQLSyntaxErrorException {
//        //SpringApplication.run(InsurancedaoApplication.class, args);
//        ConfigurableApplicationContext context = SpringApplication.run(InsurancedaoApplication.class, args);
//
//        InsuranceAvailableDbRepo availableDbRepo = context.getBean(InsuranceAvailableDbRepo.class);
//        try {
//            System.out.println(availableDbRepo.callAllInsuranceAvailable());
//            // Assuming insurance ID to be printed is 101
//        } catch (InsuranceAvailableException exception) {
//            System.out.println(exception);
//        }
//
//    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(InsurancedaoApplication.class, args);

        InsuranceAvailableDbRepo availableDbRepo = context.getBean(InsuranceAvailableDbRepo.class);
        try {
            int insuranceId = 101;
            Optional<InsuranceAvailable> insurance = availableDbRepo.apiFindById(insuranceId);

                System.out.println("Insurance found:");
                System.out.println(insurance.get());

        } catch (InsuranceAvailableException | SQLException exception) {
            System.out.println(exception);
        } finally {
            context.close();
        }
    }


}

