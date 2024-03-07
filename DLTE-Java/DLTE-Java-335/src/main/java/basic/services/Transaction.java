package basic.services;
import lombok.*;
import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private Date transactionDate;
    private Double transactionAmount;
    private String transactionTo;
    private String remarks;


}
