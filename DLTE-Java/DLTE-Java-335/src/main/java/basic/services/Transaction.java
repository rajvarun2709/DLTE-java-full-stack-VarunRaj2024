package basic.services;
import lombok.*;
import java.util.Date;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private Date transactiondate;
    private Double transactionamount;
    private String transactionto;
    private String remarks;


}
