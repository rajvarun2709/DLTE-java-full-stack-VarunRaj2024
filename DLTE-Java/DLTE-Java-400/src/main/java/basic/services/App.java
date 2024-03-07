package basic.services;

public class App {
    public static void main(String[] args) {
        Gpay gPayAccount = new Gpay(123456L, 100000.00, "annapoorna", "123-456-789", "9482");
        double withdrawAmount = 5000.0;
        System.out.println("Amount to be withdrawn: " + withdrawAmount);
        if (gPayAccount.approveWithdraw(withdrawAmount)) {
            System.out.println("Withdraw approved, your balance is " + (gPayAccount.getAccountBalance() - withdrawAmount));
        } else
            System.out.println("Insufficient balance, withdraw denied.");
        String billerName = "Phone company";
        double billedAmount = 700;
        String billerType = "Phone Bill";
        String upiPin = "9482";
        gPayAccount.payBill(billerName, billedAmount, billerType, upiPin);
    }
}