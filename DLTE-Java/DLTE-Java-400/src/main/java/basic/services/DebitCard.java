package basic.services;
public class DebitCard extends Account{
    private String cardNumber;
    private String cardPin;

    public DebitCard(Long accountNumber, Double accountBalance, String accountHolder, String cardNumber, String cardPin) {
        super(accountNumber, accountBalance, accountHolder);
        this.cardNumber = cardNumber;
        this.cardPin = cardPin;
    }

    public boolean validatePin(String enteredPin){
        return cardPin.equals(enteredPin);
    }
}
