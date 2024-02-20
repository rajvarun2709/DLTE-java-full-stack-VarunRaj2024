package basic.services;

import java.util.Scanner;

public class Minimumbalance {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the number of customer");
        int numCustomers=input.nextInt();
        double[] customerBalances=new double[numCustomers];
        for(int i=0;i<numCustomers;i++) {
            System.out.println("Enter balance for customer" + (i + 1) + ":");
            customerBalances[i] = input.nextDouble();
        }
            updateBalances(customerBalances);
            System.out.println("Updated Customer Balances:");
            for(int i=0;i<customerBalances.length;i++){
                System.out.println("Customer"+(i+1)+":"+customerBalances[i]);
            }
            input.close();

        }
        static void updateBalances(double[] balances){
            for (int i=0;i<balances.length;i++){
                if(balances[i]<10000){
                    if(balances[i]>=5000&&balances[i]<9999){
                        balances[i]-=balances[i]*0.03;

                    }
                    else if(balances[i]>=1000&&balances[i]<5000){
                        balances[i]-=balances[i]*0.05;
                    }
                }
            }
        }

    }

