package basic.services;

public class Gpay extends DebitCard{
    protected Integer upiPIN;
    protected String userName;


    public Gpay(Integer upiPIN, String userName) {
        this.upiPIN = upiPIN;
        this.userName = userName;
    }

    public Gpay(Long debitCardNumber, Integer cardPIN, Integer upiPIN, String userName) {
        super(debitCardNumber, cardPIN);
        this.upiPIN = upiPIN;
        this.userName = userName;
    }

    public Gpay(Long accountNumber, Integer accountBalance, String accountName, Long debitCardNumber, Integer cardPIN, Integer upiPIN, String userName) {
        super(accountNumber, accountBalance, accountName, debitCardNumber, cardPIN);
        this.upiPIN = upiPIN;
        this.userName = userName;
    }
    public void payBill(String name,Integer amount,String type,Integer pin){
        if(pin.equals(upiPIN)){
            System.out.println(name+" your "+type+" bill of amount "+amount+" Rs. is paid. ");
        }else{
            System.out.println("Bill cannot be paid as PIN is wrong");
        }
    }
}
