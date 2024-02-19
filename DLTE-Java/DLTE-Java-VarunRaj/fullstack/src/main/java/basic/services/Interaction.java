package basic.services;

import java.util.Scanner;

//command line interactions: Car loan
/*
Personal details: name, aadhaar, pan, address, mobile, email
Income: salarid, sel-employed: ITR
 */
public class Interaction {
    public static void main(String[] args) {
        String borrowername="", borrowerpan="", borroweraddress="", borroweremail="", borrowerincometype="";
        Long mobilenumber=0L, aadhar=0L;
        System.out.println("--------------Welcome to MyBank---------------");
        Scanner scanner=new Scanner(System.in);
        System.out.println("Fill your name");
        borrowername=scanner.nextLine();
        System.out.println("Fill your adhar no.");
        aadhar=scanner.nextLong();
        System.out.println("Enter the pan");
        borrowerpan=scanner.next();
        System.out.println("Let us know Incom type(salaried/self-employed");
        scanner.nextLine();
        borrowerincometype=scanner.nextLine();
        System.out.println("Mention the mobile number");
        mobilenumber=scanner.nextLong();
        System.out.println("Enter the email address");
        borroweremail=scanner.next();

        System.out.println("Dear "+borrowername+", Thanks for showing interest on taking car loan in MyBank, your application is submitted. The further details will be mailed to you at "+borroweremail+" or sms to "+mobilenumber);
    }
}
