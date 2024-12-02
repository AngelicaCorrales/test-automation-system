package com.endava.training.gui.page.mortgagecalculator;

import com.endava.training.gui.actions.WebAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoanCalculatorPage {

    private final WebDriver driver;
    WebAction actor;

    @FindBy(css="input[name=\"price\"]")
    private WebElement purchasePriceInput;

    @FindBy(css="input[name=\"salestax\"]")
    private WebElement salesTaxInput;

    @FindBy(css="input[name=\"financefees\"]")
    private WebElement financeApplicationFeesInput;

    @FindBy(css="input[name=\"down\"]")
    private WebElement downpaymentInput;

    @FindBy(css="input[name=\"loanamount\"]")
    private WebElement loanAmountInput;

    @FindBy(css="select[name=\"termdiv\"]")
    private WebElement loanTermDropdown;

    @FindBy(css="input[name=\"months\"]")
    private WebElement loanTermInput;

    @FindBy(css="input[name=\"rate\"]")
    private WebElement interestRateInput;

    @FindBy(css="select[name=\"interval\"]")
    private WebElement paymentsFrequencyDropdown;

    @FindBy(css="input[value=\"Calculate\"]")
    private WebElement calculateButton;

    @FindBy(css="input[name=\"payment\"]")
    private WebElement paymentAmountInput;

    @FindBy(css="input[name=\"principal\"]")
    private WebElement amountFinancedInput;

    @FindBy(css="input[name=\"stax\"]")
    private WebElement salesTaxResultInput;

    @FindBy(css="input[name=\"total_interest\"]")
    private WebElement totalInterestYouWillPayInput;

    @FindBy(css="input[name=\"numberofpayments\"]")
    private WebElement numberPaymentsUntilRepaidInput;

    @FindBy(css="input[name=\"total_purchase\"]")
    private WebElement totalCostPurchaseInput;

    @FindBy(xpath="//*[text()=\"Best Home Loan\"]")
    private WebElement bestHomeLoanListItem;

    public LoanCalculatorPage(WebDriver driver){
        this.driver=driver;
        actor= new WebAction(driver);
        PageFactory.initElements(this.driver,this);
    }

    public void enterPurchasePrice(String purchasePrice) {
        actor.sendKeys(purchasePrice, purchasePriceInput);
    }

    public void enterSalesTax(String salesTax) {
        actor.sendKeys(salesTax, salesTaxInput);
    }

    public void enterFinanceApplicationFees(String financeApplicationFees) {
        actor.sendKeys(financeApplicationFees, financeApplicationFeesInput);
    }

    public void enterDownpayment(String downpayment) {
        actor.sendKeys(downpayment, downpaymentInput);
    }

    public void enterLoanAmount(String loanAmount) {
        actor.sendKeys(loanAmount, loanAmountInput);
    }

    public void selectLoanTerm(String loanTerm) {
        actor.selectElement(loanTerm,loanTermDropdown);
    }

    public void enterLoanTerm(String loanTerm) {
        actor.sendKeys(loanTerm, loanTermInput);
    }

    public void enterInterestRate(String interestRate) {
        actor.sendKeys(interestRate, interestRateInput);
    }

    public void selectPaymentsFrequency(String paymentsFrequency) {
        actor.selectElement(paymentsFrequency,paymentsFrequencyDropdown);
    }

    public void clickCalculate(){
        actor.click(calculateButton);
    }

    public void calculateLoan(String purchasePrice, String salesTax, String financeApplicationFees, String downpayment, String loanAmount,String loanTermOption, String loanTermInput, String interestRate,  String paymentsFrequency){
        System.out.println("enter Purchase Price");
        enterPurchasePrice(purchasePrice);
        System.out.println("enter Sales Tax");
        enterSalesTax(salesTax);
        System.out.println("enter Finance Application Fees");
        enterFinanceApplicationFees(financeApplicationFees);
        System.out.println("enter Downpayment");
        enterDownpayment(downpayment);
        System.out.println("enter Loan Amount");
        enterLoanAmount(loanAmount);
        System.out.println("select Loan Term");
        selectLoanTerm(loanTermOption);
        System.out.println("enter Loan Term");
        enterLoanTerm(loanTermInput);
        System.out.println("enter Interest Rate");
        enterInterestRate(interestRate);
        System.out.println("select Payments Frequency");
        selectPaymentsFrequency(paymentsFrequency);
        System.out.println("click Calculate");
        clickCalculate();
    }

    public String getPaymentAmount(){
        return actor.getValue(paymentAmountInput);
    }

    public String getAmountFinanced(){
        return actor.getValue(amountFinancedInput);
    }

    public String getSalesTaxResult(){
        return actor.getValue(salesTaxResultInput);
    }

    public String getTotalInterestYouWillPay(){
        return actor.getValue(totalInterestYouWillPayInput);
    }

    public String getNumberPaymentsUntilRepaid(){
        return actor.getValue(numberPaymentsUntilRepaidInput);
    }

    public String getTotalCostPurchase(){
        return actor.getValue(totalCostPurchaseInput);
    }

    public void clickBestHomeLoanCalculator(){
        actor.click(bestHomeLoanListItem);
    }

    public BestHomeLoanCalculatorPage goToBestHomeLoanCalculator(){
        clickBestHomeLoanCalculator();
        return new BestHomeLoanCalculatorPage(driver);
    }
}
