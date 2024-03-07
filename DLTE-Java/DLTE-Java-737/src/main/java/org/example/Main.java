package org.example;
import org.example.Loan;
import org.example.MyBank;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Loan> loans = new ArrayList<>();
        loans.add(new Loan(1, 1000.0, new Date(2023, 1, 1), "Open", "Keerthan", "1234567890"));
        loans.add(new Loan(2, 2000.0, new Date(2023, 2, 15), "Closed", "Anarga", "9876543210"));
        loans.add(new Loan(3, 3000.0, new Date(2023, 3, 20), "Open", "deepak", "5678901234"));
        loans.add(new Loan(4, 4000.0, new Date(2023, 4, 10), "Closed", "George", "3456789012"));

        MyBank myBank = (startDate, endDate) -> {
            ArrayList<Loan> filteredLoans = new ArrayList<>();
            for (Loan loan : loans) {
                if (isWithinRange(loan.getLoanDate(), startDate, endDate)) {
                    filteredLoans.add(loan);
                }
            }
            return filteredLoans;
        };
        System.out.println("Enter the starting year, month and date");
        Scanner input=new Scanner(System.in);
        int startYear=input.nextInt();
        int startMonth=input.nextInt();
        int startDates=input.nextInt();
        System.out.println("Enter the end year, month and date");
        int endYear=input.nextInt();
        int endMonth=input.nextInt();
        int endDates=input.nextInt();
        Date startDate = new Date(startYear, startMonth, startDates);
        Date endDate = new Date(endYear, endMonth, endDates);

        ArrayList<Loan> filteredLoans = myBank.filterLoans(startDate, endDate);

        System.out.println("Filtered Loans:");
        for (Loan loan : filteredLoans) {
            System.out.println("Loan Number: " + loan.getLoanNumber() +
                    ", Amount: " + loan.getLoanAmount() +
                    ", Date: " + loan.getLoanDate() +
                    ", Status: " + loan.getLoanStatus() +
                    ", Borrower: " + loan.getBorrowerName() +
                    ", Contact: " + loan.getBorrowerContact());
        }
    }
        private static boolean isWithinRange(Date testDate, Date startDate, Date endDate) {
        return testDate.after(startDate) && testDate.before(endDate);
    }
}