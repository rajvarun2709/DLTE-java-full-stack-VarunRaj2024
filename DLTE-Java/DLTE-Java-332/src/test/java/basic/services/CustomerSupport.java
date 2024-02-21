package basic.services;
import java.util.Date;
import java.util.Scanner;

public class CustomerSupport {
    public static void main(String[] args) {

        CreditCard[] myBank={
                new CreditCard(1235678765678L,"Ram",new Date(2034,12,30),555,100000,new Date(2024,3,11),new Date(2024,03,30),2361),
                new CreditCard(8531234345445L,"Shivam",new Date(2029,1,4),134,50000,new Date(2024,3,2),new Date(2024,03,22),5479),
                new CreditCard(8632441264545L,"dhaval",new Date(2031,5,15),955,600000,new Date(2024,3,10),new Date(2024,03,11),7424),
                new CreditCard(1289631456767L,"netra",new Date(2028,8,11),767,200000,new Date(2024,3,5),new Date(2024,03,29),3655),
        };
        CustomerSupport customer=new CustomerSupport();
        System.out.println("Enter the choice\n1)Filter based on given limit\n2)Filter based of date of bill payment\n3)Update specific pin of customer\n4)Update the limit of customers those date of bill generation is 05th\n");
        Scanner scanner=new Scanner(System.in);
        int choice=scanner.nextInt();

        switch (choice) {
            case 1:
            System.out.println("enter limit of the card");
            int limit = scanner.nextInt();
            customer.filterlimit(myBank, limit);
            break;
            case 2:
            System.out.println("enter date of payment of bill");
            int day = scanner.nextInt();
            customer.filterdate(myBank, day);
            break;
            case 3:
            System.out.println("enter the correct pin if pin updation is required");
            Integer pins = scanner.nextInt();
            customer.pin(myBank, pins);
            break;
            case 4:
            customer.billgeneration(myBank);
            break;
        }

    }
    public void pin(CreditCard[] customer, Integer pins) {
        for (CreditCard each: customer){
            if(pins.equals(each.getCreditCardPin())) {
                System.out.println("Enter new pin");
                Scanner input = new Scanner(System.in);
                int newPincode = input.nextInt();
                each.setCreditCardPin(newPincode);
                System.out.println("Update succesfully");
                break;
            }

        }
        System.out.println("wrong pin");
    }
    public void filterdate(CreditCard[] customer, int day) {
        for (CreditCard each: customer){
            if (each.getDateOfBillPayment().getDate()<=day){
                System.out.println("customer with bill payment day before "+day+" is"+each.getCreditCardHolder());
            }
        }
    }
    public void filterlimit(CreditCard[] customer, int limit) {
        for (CreditCard each: customer){
            if (each.getCreditCardLimit()<=limit){
                System.out.println("The user with limit "+limit+" is"+each.getCreditCardHolder());
            }
        }
    }
    public void billgeneration(CreditCard[] myBank) {
        for (CreditCard each: myBank){
            if (each.getDateOfBillGeneration().getDate()==5){
                double limit=(each.getCreditCardLimit())*0.50;
                System.out.println("Dear "+each.getCreditCardHolder()+" your credit card limit is updated to "+(limit+each.getCreditCardLimit())+" from "+each.getCreditCardLimit());
            }
        }
    }




}