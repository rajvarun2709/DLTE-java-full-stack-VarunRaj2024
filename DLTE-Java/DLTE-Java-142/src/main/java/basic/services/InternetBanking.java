package basic.services;

import java.util.Scanner;

public class InternetBanking {
            public static void main(String[] args) {
                String name, Typeofaccount, email, pan, password;
                Long Accountnumber, mobilenumber,aadhar;
                System.out.println("------------WELCOME TO INTERNET BANKING----------");
                System.out.println("Enter the name");
                Scanner scanner=new Scanner(System.in);
                name=scanner.nextLine();
                System.out.println("Enter the mobile number");
                mobilenumber=scanner.nextLong();
                System.out.println("Enter the type of account");
                scanner.nextLine();
                Typeofaccount=scanner.nextLine();
                System.out.println("Enter the account number");
                Accountnumber=scanner.nextLong();
                Typeofaccount=scanner.nextLine();
                System.out.println("Enter the adhaar number");
                aadhar=scanner.nextLong();
                System.out.println("Enter the email");
                scanner.nextLine();
                email=scanner.nextLine();
                System.out.println("Enter the password");
                password=scanner.next();
                System.out.println("Enter the pan number");
                pan=scanner.next();
                System.out.println("Dear user you have sucesfully registered for the Internet Banking, you will be mailed to "+email+" or sms to "+mobilenumber+" ,Thank you");


            }
}
