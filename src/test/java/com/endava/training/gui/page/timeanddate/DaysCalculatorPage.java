package com.endava.training.gui.page.timeanddate;

import com.endava.training.gui.actions.WebAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DaysCalculatorPage {

    private final WebDriver driver;
    WebAction actor;

    public DaysCalculatorPage(WebDriver driver){
        this.driver=driver;
        actor= new WebAction(driver);
        PageFactory.initElements(this.driver,this);
    }
}
