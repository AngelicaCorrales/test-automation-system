package com.endava.training.gui.page.mortgagecalculator;

import com.endava.training.gui.actions.WebAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BestHomeLoanCalculatorPage {

    private final WebDriver driver;
    WebAction actor;

    public  BestHomeLoanCalculatorPage(WebDriver driver){
        this.driver=driver;
        actor= new WebAction(driver);
        PageFactory.initElements(this.driver,this);
    }

}
