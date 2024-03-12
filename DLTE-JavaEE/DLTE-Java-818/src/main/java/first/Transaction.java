package first;

import java.util.Date;

public class Transaction{
    private Date date;
    private Double amount;
    private String to ;
    private String remarks;

    public Transaction(Date date, Double amount, String to, String remarks) {
        this.date = date;
        this.amount = amount;
        this.to = to;
        this.remarks = remarks;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date" + date +
                ", amount" + amount +
                ", to='" + to + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
