package com.endava.training.gui.page.timeanddate;

import com.endava.training.gui.actions.WebAction;
import com.endava.training.gui.page.saucedemo.CheckoutCompletePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private final WebDriver driver;
    WebAction actor;

    @FindBy(xpath="//a[text()=\"Date to Date Calculator (duration)\"]")
    private WebElement dateToDateCalculatorOption;

    @FindBy(xpath="//a[text()=\"Calculators\" and @class=\"site-nav__title\"]")
    private WebElement calculatorsNavOption;

    public  HomePage(WebDriver driver){
        this.driver=driver;
        actor= new WebAction(driver);
        PageFactory.initElements(this.driver,this);
    }

    public void clickDateToDateCalculator(){
        actor.click(dateToDateCalculatorOption);
    }

    public void hoverCalculators(){
        actor.moveToElement(calculatorsNavOption);
    }

    public DaysCalculatorPage goToDateToDateCalculator(){
        hoverCalculators();
        clickDateToDateCalculator();
        return new DaysCalculatorPage(driver);
    }
}
