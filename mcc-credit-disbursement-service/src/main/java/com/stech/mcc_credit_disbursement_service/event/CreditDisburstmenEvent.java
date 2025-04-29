package com.stech.mcc_credit_disbursement_service.event;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditDisburstmenEvent {

    private String accountNumber;
    private String customerCu;
    private BigDecimal amount;
    private String email;

}
