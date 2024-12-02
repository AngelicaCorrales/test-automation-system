package com.endava.training.gui.dto.mortgagecalculator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HomeLoanForm {
    private String homePrice;
    private String downPayment;
    private String loanAmount;
    private String mortgageTerm;
    private String interestRate;
    private String discountPoints;
    private String loanOriginationFees;
    private String otherClosingCosts;
}
