package basic.services;

public class BankBond {
    public static void main(String[] args) {

        Bonds[] myBonds = {
                new Bonds(4651651.0, 0.42, false, "janay", 11,"goverment"),
                new Bonds(1654615.0, 0.36, true, "sujay", 10,"government supported"),
                new Bonds(8465461.0, 0.15, false, "keerthan", 17, "government"),
                new Bonds(1541561.0, 0.32, true, "jina", 17, "bank"),
                new Bonds(9857412.0, 0.42, true, "seetha", 15,"bank"),
        };

        int n = myBonds.length;
        Bonds temporary=null;
        for(int index=0;index<n;index++){
            for (int select=0;select<n-index-1;select++){
                if(myBonds[select].getInterestRate().compareTo(myBonds[select+1].getInterestRate())<0){
                    temporary=myBonds[select];
                    myBonds[select]=myBonds[select+1];
                    myBonds[select+1]=temporary;
                }
            }
        }
        System.out.println("The highesh interest bond is");
        for(Bonds each:myBonds){
            System.out.println(each);
        }
    }
}