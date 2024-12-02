package com.endava.training.gui.page.mortgagecalculator;

import com.endava.training.gui.actions.WebAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FreeToolsPage {

    private final WebDriver driver;
    WebAction actor;

    @FindBy(xpath="//*[contains(text(),\"Simple\")]/following-sibling::div[1]//iframe")
    private WebElement simpleCalculatorIFrame;

    @FindBy(id="p")
    private WebElement loanAmountSimpleCalculatorInput;

    @FindBy(name="i")
    private WebElement interestRateSimpleCalculatorInput;

    @FindBy(name="noy")
    private WebElement termLengthSimpleCalculatorInput;

    @FindBy(name="button")
    private WebElement calculateSimpleCalculatorButton;

    @FindBy(xpath="//*[@id=\"status\"]/child::span[8]")
    private WebElement monthlyPaymentSimpleCalculatorSpan;

    public FreeToolsPage(WebDriver driver){
        this.driver=driver;
        actor= new WebAction(driver);
        PageFactory.initElements(this.driver,this);
    }

    public void enterLoanAmountSimpleCalculator(String loanAmountSimpleCalculator) {
        actor.sendKeys(loanAmountSimpleCalculator, loanAmountSimpleCalculatorInput);
    }

    public void enterInterestRateSimpleCalculator(String interestRateSimpleCalculator) {
        actor.sendKeys(interestRateSimpleCalculator, interestRateSimpleCalculatorInput);
    }

    public void enterTermLengthSimpleCalculator(String termLengthSimpleCalculator) {
        actor.sendKeys(termLengthSimpleCalculator, termLengthSimpleCalculatorInput);
    }

    public void clickCalculateSimpleCalculator(){
        actor.click(calculateSimpleCalculatorButton);
    }

    public void switchToFrame(WebElement element){
        actor.switchToFrame(element);
    }

    public void calculateWithSimpleCalculator(String loanAmountSimpleCalculator, String interestRateSimpleCalculator, String termLengthSimpleCalculator){
        System.out.println("switch To iFrame");
        switchToFrame(simpleCalculatorIFrame);
        System.out.println("enter Loan Amount Simple Calculator");
        enterLoanAmountSimpleCalculator(loanAmountSimpleCalculator);
        System.out.println("enter Interest Rate Simple Calculator");
        enterInterestRateSimpleCalculator(interestRateSimpleCalculator);
        System.out.println("enter Term Length Simple Calculator");
        enterTermLengthSimpleCalculator(termLengthSimpleCalculator);
        System.out.println("click Calculate SimpleCalculator");
        clickCalculateSimpleCalculator();
    }

    public String getMonthlyPaymentSimpleCalculator(){
        return actor.getText(monthlyPaymentSimpleCalculatorSpan);
    }

}
