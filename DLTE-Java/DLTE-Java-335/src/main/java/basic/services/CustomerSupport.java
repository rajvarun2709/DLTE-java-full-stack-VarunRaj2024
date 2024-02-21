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
        System.out.println("------Welcome to MyBank---------\n1. Filter transactions based on date\n2. Least amount transferred\n 3. Maximum amount Transferred\n4. Number of transactions made to particular beneficiary\n4. Number of transactions made to particular beneficiary\n5. Filter based on particular remarks\n6. Sort the Beneficiary name in descending order\n7. Sort the amount based in ascending order\n");
        int choice;
        choice = scanner.nextInt();

        System.out.println("------Welcome to MyBank---------\n1. Filter transactions based on date\n2. Least amount transferred\n 3. Maximum amount Transferred\n4. Number of transactions made to particular beneficiary\n4. Number of transactions made to particular beneficiary\n5. Filter based on particular remarks\n6. Sort the Beneficiary name in descending order\n7. Sort the amount based in ascending order\n");

        choice=scanner.nextInt();

            switch (choice){
                case 1: customer.Date(myBank);
                    break;
                case 2: customer.MinimumAmount(myBank);
                    break;
                case 3: customer.MaximumAmount(myBank);
                    break;
                case 4: System.out.println("enter the number name of the beneficiary");
                        String name=scanner.next();
                        customer.totalTransactions(myBank,name);
                        break;
                case 5:
                    System.out.println("entre the name of remark");
                    String remark=scanner.next();
                    customer.FilterRemarks(myBank,remark);
                    break;
                case 6:
                    customer.SortBenificiary(myBank);
                    break;
                case 7:
                    customer.SortAmount(myBank);
                    break;
                default:exit(0);
            }


    }


    private static void SortAmount(Transaction[] myBank) {
        boolean swapped;
        int n = myBank.length;

        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (myBank[i].getTransactionamount().compareTo(myBank[i + 1].getTransactionamount()) > 0) {
                    Transaction temp = myBank[i];
                    transactionsDetails[i] = transactionsDetails[i + 1];
                    transactionsDetails[i + 1] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);


        System.out.println("Sorted transactions by beneficiary name in descending order:");
        for (Transaction card : myBank) {
            System.out.println(card);
        }

    }

    public static void SortBenificiary(Transaction[] myBank) {

        boolean swapped;
        int n = myBank.length;

        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (myBank[i].getTransactionto().compareTo(myBank[i + 1].getTransactionto()) < 0) {
                    Transaction temp = myBank[i];
                    myBank[i] = myBank[i + 1];
                    myBank[i + 1] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);


        System.out.println("Sorted transactions by beneficiary name in descending order:");
        for (Transaction card : myBank{
            System.out.println(card);
        }
    }

    private static void FilterRemarks(Transaction[] myBank, String remark) {

        double total=0;
        for (Transaction each: myBank){
            if(each.getRemarks().equals(remark)){
                total+=each.getTransactionamount();
            }
        }
        System.out.println("Total amount transacted toward the remark"+remark+"  is "+total);
    }

    private static void totalTransactions(Transaction[] myBank, String name) {
        int count=0;
        String Name="";
        for (Transaction each: myBank){
            if(each.getTransactionto().equals(name)){

                count++;
                Name=each.getTransactionto();
            }
        }
        System.out.println("Number of times the transactions has done to"+Name+"  is "+count);
    }

    private static void MaximumAmount(Transaction[] myBank) {
        String name="";
        double temp=0.0;
        for(Transaction each: myBank){


            if(each.getTransactionamount()>temp){
                temp=each.getTransactionamount();
                name=each.getTransactionto();
            }
        }
        System.out.println("maximun amount transferred to "+name+"is:"+temp);
    }

    private static void MinimumAmount(Transaction[] myBank) {
        String name="";
        double temporary=999999;
        for(Transaction each: myBank){
            if(each.getTransactionamount()<temporary){
                temporary=each.getTransactionamount();
                name=each.getTransactionto();
            }
        }
        System.out.println("The minimum amount transferred is"+name+"is:"+temporary);
    }

    public static void Date(Transaction[] myBank) {
        for(Transaction each: myBank){
            if (each.getTransactiondate().after(new Date(2024,1,1)) && each.getTransactiondate().before(new Date(2024,1,31)))
            {
                System.out.println("Date:"+each.getTransactiondate())+ " ,Transacted amount:"+each.getTransactiondate()+ " ,Recepiant:"+each.getTransactionto()+ "\nRemarks:"+each.getRemarks()+ "\n-----------------------");
            }
        }
    }
}


