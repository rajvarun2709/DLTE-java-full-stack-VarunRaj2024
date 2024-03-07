package org.example;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;

public interface MyBank {

        ArrayList<Loan> filterLoans(Date startDate, Date endDate);
    }