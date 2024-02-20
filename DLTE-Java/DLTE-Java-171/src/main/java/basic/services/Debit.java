package basic.services;

import java.util.Scanner;

public class Debit {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double temp=0;
        int debit=0;
        System.out.println("Enter the transaction amount 1:");
        temp=scanner.nextDouble();
        for(int i=1;i<10;i++){
            System.out.println("Enter transaction amount"+i+" : ");
            double amount=scanner.nextDouble();
            if(temp>amount){
                debit+=1;
            }
            temp=amount;
        }
        System.out.println("Total debits:"+debit);
    }
}
