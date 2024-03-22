package com.example.taskone;


import java.util.ArrayList;
import java.util.List;

public interface LoansInterface {
    default List<Loans> initializeMyLoans() {
        List<Loans> myLoans = new ArrayList<>();
        myLoans.add(new Loans(12341324L, 13244.0, "13/02/2024", "personal Loan", "vijay", 12341324L));
        myLoans.add(new Loans(12351324L, 1324324.0, "11/03/2024", "home loan", "kiran", 12341324L));
        myLoans.add(new Loans(1841324L, 132432524.0, "18/04/2024", "personal loan", "neema", 12432324L));
        myLoans.add(new Loans(14571324L, 13233334.0, "14/05/2024", "home loan", "saritha", 121341324L));
        return myLoans;
    }
    List<Loans> findAllLoans();
}