package basic.services;
import java.util.Scanner;
import java.util.Date;

import static java.lang.System.exit;

public class CustomerSupport {
    public static void main(String[] args) {
        Transaction[] myBank = {
                new Transaction(new Date(2024, 9, 23), 9000.0, "rakesh", "Family"),
                new Transaction(new Date(2024, 10, 23), 4000.0, "suma", "Education"),
                new Transaction(new Date(2024, 11, 29), 7000.0, "fathima", "Emergency"),
                new Transaction(new Date(2024, 12, 13), 3000.0, "seetha", "Friend")

        };
        CustomerSupport customer = new CustomerSupport();
        Scanner scanner = new Scanner(System.in);
        System.out.println("------Welcome to MyBank---------\n1. Filter transactions based on date\n2. Least amount transferred\n3. Maximum amount Transferred\n4. Number of transactions made to particular beneficiary\n4. Number of transactions made to particular beneficiary\n5. Filter based on particular remarks\n6. Sort the Beneficiary name in descending order\n7. Sort the amount based in ascending order\n");
        int choice;
        choice = scanner.nextInt();

            switch (choice){
                case 1: customer.date(myBank);
                    break;
                case 2: customer.leastAmount(myBank);
                    break;
                case 3: customer.maximumAmount(myBank);
                    break;
                case 4: System.out.println("enter the number name of the beneficiary");
                        String name=scanner.next();
                        customer.noofTransactions(myBank,name);
                        break;
                case 5:
                    System.out.println("entre the name of remark");
                    String remark=scanner.next();
                    customer.remarks(myBank,remark);
                    break;
                case 6:
                    customer.descendingBenificiary(myBank);
                    break;
                case 7:
                    customer.ascendingAmount(myBank);
                    break;
                default:exit(0);
            }


    }

    public static void date(Transaction[] myBank) {
        for(Transaction each: myBank){
            if (each.getTransactionDate().after(new Date(2024,9,23))&&each.getTransactionDate().before(new Date(2024,11,29)))
            {
                System.out.println("Date:"+each.getTransactionDate()+ " ,Transacted amount:"+each.getTransactionAmount()+ ", Transacted to:"+each.getTransactionTo()+ " ,Remark:"+each.getRemarks());
            }
        }
    }

    private static void leastAmount(Transaction[] myBank) {
        double temporary=99999;
        String name="";
        for(Transaction each: myBank){
            if(each.getTransactionAmount()<temporary){
                temporary=each.getTransactionAmount();
                name=each.getTransactionTo();
            }
        }
        System.out.println("The least amount transferred is"+name+"is:"+temporary);
    }

    private static void maximumAmount(Transaction[] myBank) {
        double temporary=0.0;
        String name="";
        for(Transaction each: myBank){

            if(each.getTransactionAmount()>temporary){
                name=each.getTransactionTo();
                temporary=each.getTransactionAmount();

            }
        }
        System.out.println("maximum amount transferred to "+name+" is: "+temporary);
    }

    private static void noofTransactions(Transaction[] myBank, String name) {
        String Name="";
        int count=0;
        for (Transaction each: myBank){
            if(each.getTransactionTo().equals(name)){
                count++;
                Name=each.getTransactionTo();
            }
        }
        System.out.println("Number of transaction made to "+Name+" is "+count);
    }

    private static void remarks(Transaction[] myBank, String remark) {
        double number=0;
        for (Transaction each: myBank){
            if(each.getRemarks().equals(remark)){
                number+=each.getTransactionAmount();
            }
        }
        System.out.println("Amount transferred for the remark "+remark+" is "+number);
    }

    private static void ascendingAmount(Transaction[] myBank) {

        int length = myBank.length;
        boolean swap;

        do {
            swap = false;
            for (int index = 0; index < length - 1; index++) {
                if (myBank[index].getTransactionAmount().compareTo(myBank[index + 1].getTransactionAmount()) > 0) {
                    Transaction temp = myBank[index];
                    myBank[index] = myBank[index + 1];
                    myBank[index + 1] = temp;
                    swap= true;
                }
            }
            length--;
        } while (swap);


        System.out.println("Ascending Amount:");
        for (Transaction info : myBank) {
            System.out.println(info);
        }

    }

    public static void descendingBenificiary(Transaction[] myBank) {

        boolean swapped;
        int length = myBank.length;

        do {
            swapped = false;
            for (int index = 0; index < length - 1; index++) {
                if (myBank[index].getTransactionTo().compareTo(myBank[index + 1].getTransactionTo()) < 0) {
                    Transaction temp = myBank[index];
                    myBank[index] = myBank[index + 1];
                    myBank[index + 1] = temp;
                    swapped = true;
                }
            }
            length--;
        } while (swapped);


        System.out.println("Desecnding Beneficiary:");
        for (Transaction info : myBank){
            System.out.println(info);
        }
    }










}


