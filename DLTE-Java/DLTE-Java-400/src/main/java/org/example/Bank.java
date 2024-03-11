package org.example;
import java.util.Date;
public interface Bank {
    Loan[] loans = new Loan[10];
    void addLoan(int size);
    void availableLoan();
    void closedLoan();
}
