package basic.services;

import java.util.Scanner;

public class Flexipay {
    public static void main(String[] args) {
        System.out.println("-------------Welcome to Flexi Pay---------------");
        Integer principlespent=0, tenure=0;
        Double rateOfInterest=21.5, processing=0.0, repaymentAmt=0.0, emi=0.0;
        System.out.println("Let us know your spent to convert as EMI");
        Scanner sc=new Scanner(System.in);
        principlespent=sc.nextInt();
        System.out.println("Let us know the tenure");
        tenure=sc.nextInt();
        processing=principlespent*0.01;
        System.out.println("Processing charges is "+processing);
        processing+=processing*0.180;
        System.out.println("Processing fee with gst "+processing);
        //rateOfInterest options
        if(tenure>=3&&tenure<=6){
            rateOfInterest=20.25;
        }
        else if(tenure>6&&tenure<=10){
            rateOfInterest=21.25;

        }
        else if(tenure>10&&tenure<=18){
            rateOfInterest=21.50;
        }
        else if(tenure>18&&tenure<=24){
            rateOfInterest=22.2;
        }
        else {
            rateOfInterest=22.5;
        }
        repaymentAmt=principlespent*rateOfInterest/100;
        System.out.println("Repayment inclues amt of "+repaymentAmt+" of "+rateOfInterest+" percent");
        repaymentAmt+=principlespent;
        emi=repaymentAmt/tenure;
        System.out.println("The total interest amount is "+repaymentAmt+ "with the processing charges of "+processing+"With monthly emi"+emi);
        System.out.println("The first emi is "+(emi+processing));

    }
}
