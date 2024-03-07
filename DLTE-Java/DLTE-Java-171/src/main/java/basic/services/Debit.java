package basic.services;
import java.util.Scanner;
public class Debit {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double temporary=0;
        int debit=0;
        System.out.println("Enter the transaction amount 1:");
        temporary=scanner.nextDouble();
        for(int i=1;i<10;i++){
            System.out.println("Enter transaction amount"+i+":");
            double amount=scanner.nextDouble();
            if(temporary>amount){
                debit+=1;
            }
            temporary=amount;
        }
        System.out.println("Total debits:"+debit);
    }
}
