package basic.services;

import java.util.Scanner;

public class Tax {
    public static void main(String[] args) {
        System.out.println("Enter the salary");
        long salary;
        salary=new Scanner(System.in).nextLong();
        int sc=salgroup(salary);
        switch(sc) {
            case 1:
                System.out.println("You Are exempt from any taxon both regime");
                break;
            case 2:
                System.out.println("Old regime:" + (salary * 0.05) + "New Regime: " + (salary * 0.05));
                break;
            case 3:
                System.out.println("Old regime: " + (salary * 0.20) + "New Regime: " + (salary * 0.10));
                break;
            case 4:
                System.out.println("Old regime: " + (salary * 0.20) + "New Regime: " + (salary * 0.15));
                break;
            case 5:
                System.out.println("Old regime: " + (salary * 0.30) + "New Regime: " + (salary * 0.20));
                break;
            case 6:
                System.out.println("Old regime: " + (salary * 0.30) + "New Regime: " + (salary * 0.25));
                break;
            case 7:
                System.out.println("Old regime: " + (salary * 0.30) + "New Regime: " + (salary * 0.30));
                break;
        }
        }
        static int salgroup(long salary) {
        if(salary>=0 && salary<250000)
            return 1;
        else if(salary>=250000 && salary<500000)
            return 2;
        else if(salary>=500000 && salary<750000)
            return 3;
        else if(salary>=750000 && salary<1000000)
            return 4;
        else if(salary>=1000000 && salary<1250000)
            return 5;
        else if(salary>=1250000 && salary<1500000)
            return 6;
        else return 7;


        }
    }



