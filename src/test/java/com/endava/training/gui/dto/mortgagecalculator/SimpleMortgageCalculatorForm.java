package com.endava.training.gui.dto.mortgagecalculator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SimpleMortgageCalculatorForm {

    private String loanAmountSimpleCalculator;
    private String interestRateSimpleCalculator;
    private String termLengthSimpleCalculator;

}
