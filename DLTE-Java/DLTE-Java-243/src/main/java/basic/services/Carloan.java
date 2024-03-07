package basic.services;

import java.util.Scanner;

public class Carloan {
    public static void main(String[] args) {
        String name, aadhar, pan, address, mobile, email, incomeType;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter name");
        name=sc.nextLine();
        System.out.println("Enter aadhar");
        aadhar=sc.next();
        System.out.println("Enter the pan");
        pan=sc.next();
        System.out.println("Enter the mobile");
        mobile=sc.next();
        System.out.println("Enter the email");
        email=sc.next();
        if (validateName(name) && validateAaddhar(aadhar) && validatePan(pan) && validateMoile(mobile) && validateemail(email)) {
            System.out.println("All the data is valid");
        } else {
            System.out.println("Invalid data");
        }
    }

    private static boolean validateName(String name) {
        String regex = "^[a-zA-Z\\s]+";
        return name.matches(regex);
    }

    private static boolean validateAaddhar(String aadhar) {
        String regex = "^\\d{4}-\\d{4}-\\d{4}$";
        return aadhar.matches(regex);
    }

    private static boolean validatePan(String pan) {
        String regex = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$";
        return pan.matches(regex);
    }

    private static boolean validateMoile(String mobile) {
        String regex = "^[0-9]{10}$";
        return mobile.matches(regex);
    }

    private static boolean validateemail(String email) {
        String regex = "^[a-zA-Z0-9]@(?:[a-zA-Z]{3})+[a-zA-Z]{2,7}$";
        return email.matches(regex);
    }


}
