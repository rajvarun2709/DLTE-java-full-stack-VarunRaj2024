package basic.services;

import java.util.Date;

public class CustomerSupport {
    public static void main(String[] args) {
//        CreditCard[] myBank=new CreditCard[10];

        CreditCard[] myBank={
                new CreditCard(8765678765678L,"Razak Mohamed S",new Date(2034,12,30),555,100000,new Date(2024,3,11),new Date(2024,03,30),1111),
                new CreditCard(2343234345445L,"Shreyas",new Date(2029,1,4),134,50000,new Date(2024,3,2),new Date(2024,03,22),9999),
                new CreditCard(8765678764545L,"Sanath",new Date(2031,5,15),955,100000,new Date(2024,3,10),new Date(2024,03,11),9864),
                new CreditCard(1234565456767L,"Akash",new Date(2028,8,11),767,100000,new Date(2024,3,18),new Date(2024,03,29),1945),
        };

        CustomerSupport support=new CustomerSupport();

        support.findBillDate(myBank,new Date(2024,3,5),new Date(2024,3,18));
        support.list(myBank);
        support.sortingCustomers(myBank);
        support.list(myBank);
    }



    public void findBillDate(CreditCard[] customers, Date start, Date end){
        System.out.println("Customers those having bill dates between "+start.getDate()+" and "+end.getDate());
        for(CreditCard each:customers){
            if(each.getDateOfBillGeneration().getDate()>=start.getDate()&&each.getDateOfBillGeneration().getDate()<=end.getDate()){
                System.out.println(each.getCreditCardHolder()+" "+each.getDateOfBillGeneration().getDate());
            }
        }
    }

    public void list(CreditCard[] customers){
        System.out.println("Available customers");
        for(CreditCard each:customers){
            System.out.println(each);
        }
    }

    public void sortingCustomers(CreditCard[] customers){
        CreditCard backup=null;
        for(int select=0;select<customers.length;select++){
            for(int next=select+1;next<customers.length;next++){
                if(customers[select].getCreditCardHolder().compareTo(customers[next].getCreditCardHolder())>0){
                    backup=customers[select];
                    customers[select]=customers[next];
                    customers[next]=backup;
                }
            }
        }
    }
}