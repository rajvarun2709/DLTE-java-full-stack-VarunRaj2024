package basic.services;

import java.util.Scanner;

public class EmployeeDetailsApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Employee Details:");

        Address permanentAddress = readAddress(scanner);
        Address officeAddress = readAddress(scanner);
        EmployeeDetails employeeDetails = readEmployeeDetails(scanner, permanentAddress, officeAddress);

        // Print Employee Details
        employeeDetails.displayEmployeeDetails();

        scanner.close();
    }

    private static Address readAddress(Scanner scanner) {
        System.out.print("State: ");
        String state = scanner.nextLine();
        System.out.print("House Name: ");
        String houseName = scanner.nextLine();
        System.out.print("City: ");
        String city = scanner.nextLine();
        System.out.print("Pincode: ");
        int pincode = scanner.nextInt();
        // Consume the newline character
        scanner.nextLine();
        System.out.print("Street: ");
        String street = scanner.nextLine();

        return new Address(state, houseName, city, pincode, street);
    }

    private static EmployeeDetails readEmployeeDetails(Scanner scanner, Address permanentAddress, Address officeAddress) {
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Second Name: ");
        String secondName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Employee ID: ");
        int employeeId = scanner.nextInt();
        System.out.print("Employee Phone Number: ");
        long phoneNumber = scanner.nextLong();

        return new EmployeeDetails(firstName, secondName, lastName, employeeId, phoneNumber, permanentAddress, officeAddress);
    }
}
