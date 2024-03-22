package com.example.taskone;


import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component("HomeLoanOperation")
public class HomeLoanImplementation implements LoansInterface {
    @Override
    public List<Loans> findAllLoans() {
        List<Loans> allLoans = initializeMyLoans();

        List<Loans> homeLoans = allLoans.stream()
                .filter(loan -> "home loan".equalsIgnoreCase(loan.getLoanStatus()))
                .collect(Collectors.toList());

        return homeLoans;
    }
}