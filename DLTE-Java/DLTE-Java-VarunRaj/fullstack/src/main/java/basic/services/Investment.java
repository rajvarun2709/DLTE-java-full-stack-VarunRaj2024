package basic.services;

import java.util.Scanner;

public class Investment {
    public static void main(String[] args) {
        System.out.println("---------Welcome to MyBank---------------------");
        String investmentType="";
        Scanner sc=new Scanner(System.in);
        System.out.println("Let us know how you wish to invest in our bank");
        investmentType=sc.next();
        switch (investmentType)
        {
            case "lumpsum": case "LumpSum":
                System.out.println("Fixed Deposit with average of 7 percent\nMutual funds with high risk");
                break;
            case "systematic": case "rd": case "RD":
                System.out.println("SIP, Recursive Deposit and gold bee's with return upto 11 percent");
                break;
            default:
                System.out.println("No other plans for you");

        }
    }
}
