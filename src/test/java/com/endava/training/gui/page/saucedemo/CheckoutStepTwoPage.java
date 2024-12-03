package com.endava.training.gui.page.saucedemo;

import com.endava.training.gui.actions.WebAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepTwoPage {
    private final WebDriver driver;
    WebAction actor;

    @FindBy(id="finish")
    private WebElement finishButton;

    public CheckoutStepTwoPage(WebDriver driver){
        this.driver=driver;
        actor= new WebAction(driver);
        PageFactory.initElements(this.driver,this);
    }

    public void clickFinish(){
        actor.click(finishButton);
    }

    public CheckoutCompletePage finishCheckout(){
        System.out.println("click Finish");
        clickFinish();
        return new CheckoutCompletePage(driver);
    }


}
