package basic.services;
import java.util.Scanner;
public class Sip {
    public static void main(String[] args) {
        long invest;
        double interest;
        int year;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter monthly investment");
        invest=scanner.nextLong();
        System.out.println("Enter Expected Interest");
        interest=scanner.nextDouble();
        interest/=(12*100);
        System.out.println("Enter Time");
        year=scanner.nextInt();
        year*=12;
        System.out.println("Total Return "+(invest*((Math.pow((1+interest),year)-1)/interest)*(1+interest)));
    }
}
