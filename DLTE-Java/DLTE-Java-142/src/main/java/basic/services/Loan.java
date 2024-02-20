package basic.services;

import java.util.Scanner;

public class Loan {
    public static void main(String[] args) {
        String borrowername="", borrowerpan="", borroweraddress="", borroweremail="", borrowerincometype="";
        Long mobilenumber=0L, aadhar=0L, loan=0L;
        int tenure;
        System.out.println("--------------Welcome to MyBank---------------");
        Scanner scanner=new Scanner(System.in);
        System.out.println("Fill your name");
        borrowername=scanner.nextLine();
        System.out.println("Fill your adhar no.");
        aadhar=scanner.nextLong();
        System.out.println("Enter the pan");
        borrowerpan=scanner.next();
        System.out.println("Let us know Income type(salaried/self-employed)");
        scanner.nextLine();
        borrowerincometype=scanner.nextLine();
        System.out.println("Mention the mobile number");
        mobilenumber=scanner.nextLong();
        System.out.println("Enter the email address");
        borroweremail=scanner.next();
        System.out.println(("Enter the Resedential address"));
        scanner.nextLine();
        borroweraddress=scanner.nextLine();
        System.out.println("Enter the loan amount required");
        loan=scanner.nextLong();
        System.out.println("Enter the loan tenure in months");
        tenure=scanner.nextInt();
        System.out.println("Dear "+borrowername+", Thanks for showing interest on taking loan in MyBank, your application is submitted. The further details will be mailed to you at "+borroweremail+" or sms to "+mobilenumber);
    }
}
