package basic.services;
import lombok.*;
import java.util.Date;

@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {
    private Long creditCardNumber;
    private String creditCardHolder;
    private Date creditCardExpiry;
    private Integer creditCardCvv;
    private Integer creditCardLimit;
    private Date dateOfBillGeneration;
    private Date dateOfBillPayment;
    private Integer creditCardPin;
}