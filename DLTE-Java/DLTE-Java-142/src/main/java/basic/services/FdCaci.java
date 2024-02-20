package basic.services;

import java.util.Scanner;

public class FdCaci {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter principal amount:");
        long principle=sc.nextLong();
        System.out.print("Enter interest rate:");
        double  annualInterest=sc.nextDouble();
        System.out.print("Enter number of years:");
        int years=sc.nextInt();
        double rate=annualInterest/100;
        double maturity=principle+(principle*years*rate);
        System.out.println("Amount gained after "+years+" is "+maturity);


    }
}
