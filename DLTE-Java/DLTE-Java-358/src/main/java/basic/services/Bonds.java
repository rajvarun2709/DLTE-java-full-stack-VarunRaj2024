package basic.services;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bonds {

    private Double maturity;
    private Double interestRate;
    private Boolean taxStatus;
    private String bondHolder;
    private Integer period;
    private String bondissuer;

}