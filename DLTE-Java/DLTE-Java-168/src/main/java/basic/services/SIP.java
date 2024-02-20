package basic.services;

import java.util.Scanner;

public class SIP {
    public static void main(String[] args) {
        long invest;
        double interest;
        int year;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter monthly investment");
        invest=sc.nextLong();
        System.out.println("Enter Expected Interest");
        interest=sc.nextDouble();
        interest/=(12*100);
        System.out.println("Enter Time");
        year=sc.nextInt();
        year*=12;
        System.out.println("Total Return "+(invest*((Math.pow((1+interest),year)-1)/interest)*(1+interest)));
    }
}
