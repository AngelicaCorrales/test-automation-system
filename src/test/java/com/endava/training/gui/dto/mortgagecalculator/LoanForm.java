package com.endava.training.gui.dto.mortgagecalculator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanForm {
    private String purchasePrice;
    private String salesTax;
    private String financeApplicationFees;
    private String downpayment;
    private String loanAmount;
    private String loanTermOption;
    private String loanTermInput;
    private String interestRate;
    private String paymentsFrequency;
}
