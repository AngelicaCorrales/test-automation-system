package com.endava.training.gui.page.mortgagecalculator;

import com.endava.training.gui.actions.WebAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BestHomeLoanCalculatorPage {

    private final WebDriver driver;
    WebAction actor;

    @FindBy(id="HomeValue")
    private WebElement homePriceLoan1Input;

    @FindBy(id="Down")
    private WebElement downPaymentLoan1Input;

    @FindBy(id="Amount")
    private WebElement loanAmountLoan1Input;

    @FindBy(css="input[name=\"Length\"]")
    private WebElement mortgageTermLoan1Input;

    @FindBy(css="input[name=\"Interest\"]")
    private WebElement interestRateLoan1Input;

    @FindBy(css="input[name=\"Points\"]")
    private WebElement discountPointsLoan1Input;

    @FindBy(css="input[name=\"Origination\"]")
    private WebElement loanOriginationFeesLoan1Input;

    @FindBy(css="input[name=\"Closing\"]")
    private WebElement otherClosingCostsLoan1Input;

    @FindBy(css="input[name=\"calculate\"]")
    private WebElement calculateButton;

    @FindBy(xpath="//td[text()=\"Amount Financed:\"]/following-sibling::td[1]")
    private WebElement amountFinancedLoan1Td;

    @FindBy(xpath="//td[text()=\"Amount Financed:\"]/following-sibling::td[2]")
    private WebElement amountFinancedLoan2Td;

    @FindBy(xpath="//td[text()=\"Loan Term:\"]/following-sibling::td[1]")
    private WebElement loanTermLoan1Td;

    @FindBy(xpath="//td[text()=\"Loan Term:\"]/following-sibling::td[2]")
    private WebElement loanTermLoan2Td;

    @FindBy(xpath="//td[text()=\" Monthly Principal & Interest Payment: \"]/following-sibling::td[1]")
    private WebElement monthlyPrincipalInterestPaymentLoan1Td;

    @FindBy(xpath="//td[text()=\" Monthly Principal & Interest Payment: \"]/following-sibling::td[2]")
    private WebElement monthlyPrincipalInterestPaymentLoan2Td;

    @FindBy(xpath="//td[text()=\" Cost of Discount Points:\"]/following-sibling::td[1]")
    private WebElement costDiscountPointsLoan1Td;

    @FindBy(xpath="//td[text()=\" Cost of Discount Points:\"]/following-sibling::td[2]")
    private WebElement costDiscountPointsLoan2Td;

    @FindBy(xpath="//td[text()=\"Loan Origination Fees:\"]/following-sibling::td[1]")
    private WebElement loanOriginationFeesLoan1Td;

    @FindBy(xpath="//td[text()=\"Loan Origination Fees:\"]/following-sibling::td[2]")
    private WebElement loanOriginationFeesLoan2Td;

    @FindBy(xpath="//td[text()=\"Other Closing Costs:\"]/following-sibling::td[1]")
    private WebElement otherClosingCostsLoan1Td;

    @FindBy(xpath="//td[text()=\"Other Closing Costs:\"]/following-sibling::td[2]")
    private WebElement otherClosingCostsLoan2Td;

    @FindBy(xpath="//*[text()=\"Total Closing Costs:\"]/ancestor::td/following-sibling::td[1]")
    private WebElement totalClosingCostsLoan1Td;

    @FindBy(xpath="//*[text()=\"Total Closing Costs:\"]/ancestor::td/following-sibling::td[2]")
    private WebElement totalClosingCostsLoan2Td;

    @FindBy(xpath="//td[text()=\"Total Monthly Payments: \"]/following-sibling::td[1]")
    private WebElement totalMonthlyPaymentsLoan1Td;

    @FindBy(xpath="//td[text()=\"Total Monthly Payments: \"]/following-sibling::td[2]")
    private WebElement totalMonthlyPaymentsLoan2Td;

    @FindBy(xpath="//td[text()=\"Payment Savings: \"]/following-sibling::td[1]")
    private WebElement paymentsSavingsLoan1Td;

    @FindBy(xpath="//td[text()=\"Payment Savings: \"]/following-sibling::td[2]")
    private WebElement paymentsSavingsLoan2Td;

    @FindBy(xpath="//td[text()=\"Total Interest Expense: \"]/following-sibling::td[1]")
    private WebElement totalInterestExpenseLoan1Td;

    @FindBy(xpath="//td[text()=\"Total Interest Expense: \"]/following-sibling::td[2]")
    private WebElement totalInterestExpenseLoan2Td;

    @FindBy(xpath="//td[text()=\"Total Interest Savings: \"]/following-sibling::td[1]")
    private WebElement totalInterestSavingsLoan1Td;

    @FindBy(xpath="//td[text()=\"Total Interest Savings: \"]/following-sibling::td[2]")
    private WebElement totalInterestSavingsLoan2Td;

    public BestHomeLoanCalculatorPage(WebDriver driver){
        this.driver=driver;
        actor= new WebAction(driver);
        PageFactory.initElements(this.driver,this);
    }

    public void enterHomePriceLoan1(String homePrice) {
        actor.sendKeys(homePrice, homePriceLoan1Input);
    }

    public void enterDownPaymentLoan1(String downPayment) {
        actor.sendKeys(downPayment, downPaymentLoan1Input);
    }

    public void enterLoanAmountLoan1(String loanAmount) {
        actor.sendKeys(loanAmount, loanAmountLoan1Input);
    }

    public void enterMortgageTermLoan1(String mortgageTerm) {
        actor.sendKeys(mortgageTerm, mortgageTermLoan1Input);
    }

    public void enterInterestRateLoan1(String interestRate) {
        actor.sendKeys(interestRate, interestRateLoan1Input);
    }

    public void enterDiscountPoints(String discountPoints) {
        actor.sendKeys(discountPoints, discountPointsLoan1Input);
    }

    public void enterLoanOriginationFeesLoan1(String loanOriginationFees) {
        actor.sendKeys(loanOriginationFees, loanOriginationFeesLoan1Input);
    }

    public void enterOtherClosingCostsLoan1(String otherClosingCosts) {
        actor.sendKeys(otherClosingCosts, otherClosingCostsLoan1Input);
    }

    public void clickCalculate(){
        actor.click(calculateButton);
    }

    public void setHomeLoan1Fields(String homePrice,String downPayment,String loanAmount,String mortgageTerm, String interestRate, String discountPoints, String loanOriginationFees,String otherClosingCosts){
        enterHomePriceLoan1(homePrice);
        enterDownPaymentLoan1(downPayment);
        enterLoanAmountLoan1(loanAmount);
        enterMortgageTermLoan1(mortgageTerm);
        enterInterestRateLoan1(interestRate);
        enterDiscountPoints(discountPoints);
        enterLoanOriginationFeesLoan1(loanOriginationFees);
        enterOtherClosingCostsLoan1(otherClosingCosts);
    }

    public void calculateHomeLoan1(String homePrice1, String downPayment1, String loanAmount1, String mortgageTerm1, String interestRate1, String discountPoints1, String loanOriginationFees1, String otherClosingCosts1){
        setHomeLoan1Fields(homePrice1,downPayment1,loanAmount1,mortgageTerm1,interestRate1,discountPoints1,loanOriginationFees1,otherClosingCosts1);
        clickCalculate();
    }

    public String getAmountFinancedLoan1(){
        return actor.getText(amountFinancedLoan1Td);
    }

    public String getAmountFinancedLoan2(){
        return actor.getText(amountFinancedLoan2Td);
    }

    public String getLoanTermLoan1(){
        return actor.getText(loanTermLoan1Td);
    }

    public String getLoanTermLoan2(){
        return actor.getText(loanTermLoan2Td);
    }

    public String getMonthlyPrincipalInterestPaymentLoan1(){
        return actor.getText(monthlyPrincipalInterestPaymentLoan1Td);
    }

    public String getMonthlyPrincipalInterestPaymentLoan2(){
        return actor.getText(monthlyPrincipalInterestPaymentLoan2Td);
    }

    public String getCostDiscountPointsLoan1(){
        return actor.getText(costDiscountPointsLoan1Td);
    }

    public String getCostDiscountPointsLoan2(){
        return actor.getText(costDiscountPointsLoan2Td);
    }

    public String getLoanOriginationFeesLoan1(){
        return actor.getText(loanOriginationFeesLoan1Td);
    }

    public String getLoanOriginationFeesLoan2(){
        return actor.getText(loanOriginationFeesLoan2Td);
    }

    public String getOtherClosingCostsLoan1(){
        return actor.getText(otherClosingCostsLoan1Td);
    }

    public String getOtherClosingCostsLoan2(){
        return actor.getText(otherClosingCostsLoan2Td);
    }

    public String getTotalClosingCostsLoan1(){
        return actor.getText(totalClosingCostsLoan1Td);
    }

    public String getTotalClosingCostsLoan2(){
        return actor.getText(totalClosingCostsLoan2Td);
    }

    public String getTotalMonthlyPaymentsLoan1(){
        return actor.getText(totalMonthlyPaymentsLoan1Td);
    }

    public String getTotalMonthlyPaymentsLoan2(){
        return actor.getText(totalMonthlyPaymentsLoan2Td);
    }

    public String getPaymentsSavingsLoan1(){
        return actor.getText(paymentsSavingsLoan1Td);
    }

    public String getPaymentsSavingsLoan2(){
        return actor.getText(paymentsSavingsLoan2Td);
    }

    public String getTotalInterestExpenseLoan1(){
        return actor.getText(totalInterestExpenseLoan1Td);
    }

    public String getTotalInterestExpenseLoan2(){
        return actor.getText(totalInterestExpenseLoan2Td);
    }

    public String getTotalInterestSavingsLoan1(){
        return actor.getText(totalInterestSavingsLoan1Td);
    }

    public String getTotalInterestSavingsLoan2(){
        return actor.getText(totalInterestSavingsLoan2Td);
    }

}
