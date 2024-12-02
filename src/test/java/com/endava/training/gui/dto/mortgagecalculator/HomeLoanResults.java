package com.endava.training.gui.dto.mortgagecalculator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HomeLoanResults {
    private String amountFinancedLoan1;
    private String amountFinancedLoan2;
    private String loanTermLoan1;
    private String loanTermLoan2;
    private String monthlyPrincipalInterestPaymentLoan1;
    private String monthlyPrincipalInterestPaymentLoan2;
    private String costDiscountPointsLoan1;
    private String costDiscountPointsLoan2;
    private String loanOriginationFeesLoan1;
    private String loanOriginationFeesLoan2;
    private String otherClosingCostsLoan1;
    private String otherClosingCostsLoan2;
    private String totalClosingCostsLoan1;
    private String totalClosingCostsLoan2;
    private String totalMonthlyPaymentsLoan1;
    private String totalMonthlyPaymentsLoan2;
    private String paymentsSavingsLoan1;
    private String paymentsSavingsLoan2;
    private String totalInterestExpenseLoan1;
    private String totalInterestExpenseLoan2;
    private String totalInterestSavingsLoan1;
    private String totalInterestSavingsLoan2;
}
