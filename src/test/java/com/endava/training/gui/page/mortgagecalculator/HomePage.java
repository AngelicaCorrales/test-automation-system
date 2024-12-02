package com.endava.training.gui.page.mortgagecalculator;

import com.endava.training.gui.actions.WebAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private final WebDriver driver;
    WebAction actor;

    @FindBy(xpath="//a[text()=\"Financial Calcs\"]")
    private WebElement financialCalcsNavOption;

    @FindBy(xpath="//a[text()=\"Personal Loans\"]")
    private WebElement personalLoansOption;

    @FindBy(xpath="//a[text()=\"Widgets\"]")
    private WebElement widgetsNavOption;

    @FindBy(xpath="//a[text()=\"Sidebar Calculators\"]")
    private WebElement sidebarCalculatorsOption;

    public  HomePage(WebDriver driver){
        this.driver=driver;
        actor= new WebAction(driver);
        PageFactory.initElements(this.driver,this);
    }

    public void clickPersonalLoans(){
        actor.click(personalLoansOption);
    }

    public void hoverFinancialCalcs(){
        actor.moveToElement(financialCalcsNavOption);
    }

    public LoanCalculatorPage goToLoanCalculator(){
        hoverFinancialCalcs();
        clickPersonalLoans();
        return new LoanCalculatorPage(driver);
    }

    public void clickSidebarCalculators(){
        actor.click(sidebarCalculatorsOption);
    }

    public void hoverWidgets(){
        actor.moveToElement(widgetsNavOption);
    }

    public FreeToolsPage goToFreeTools(){
        hoverWidgets();
        clickSidebarCalculators();
        return new FreeToolsPage(driver);
    }
}
