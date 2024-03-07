package basic.services;
import java.util.Scanner;
public class Minimumbalance {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the number of customer");
        int numberofCustomers=input.nextInt();
        double[] customerBalances=new double[numberofCustomers];
        for(int i=0;i<numberofCustomers;i++) {
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
            for (int index=0;index<balances.length;index++){
                if(balances[index]<10000){
                    if(balances[index]>=5000&&balances[index]<9999){
                        balances[index]-=balances[index]*0.03;
                    }
                    else if(balances[index]>=1000&&balances[index]<5000){
                        balances[index]-=balances[index]*0.05;
                    }
                }
            }
        }

    }

