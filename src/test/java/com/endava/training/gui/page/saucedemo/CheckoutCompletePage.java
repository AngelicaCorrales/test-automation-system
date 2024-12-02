package com.endava.training.gui.page.saucedemo;

import com.endava.training.gui.actions.WebAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {
    private final WebDriver driver;
    WebAction actor;

    @FindBy(css=".complete-header")
    private WebElement completeHeader;

    @FindBy(css=".complete-text")
    private WebElement completeText;

    public  CheckoutCompletePage(WebDriver driver){
        this.driver=driver;
        actor= new WebAction(driver);
        PageFactory.initElements(this.driver,this);
    }

    public String getCheckoutCompleteHeader(){
        return actor.getText(completeHeader);
    }

    public String getCheckoutCompleteText(){
        return actor.getText(completeText);
    }

}
