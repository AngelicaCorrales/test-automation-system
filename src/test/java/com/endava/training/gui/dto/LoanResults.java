package com.endava.training.gui.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanResults {
    private String paymentAmount;
    private String amountFinanced;
    private String salesTaxResult;
    private String totalInterestYouWillPay;
    private String numberPaymentsUntilRepaid;
    private String totalCostPurchase;
}
