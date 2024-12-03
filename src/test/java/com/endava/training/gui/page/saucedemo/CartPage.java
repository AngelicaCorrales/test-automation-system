package com.endava.training.gui.page.saucedemo;

import com.endava.training.gui.actions.WebAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    private final WebDriver driver;
    WebAction actor;

    @FindBy(id="checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver){
        this.driver=driver;
        actor= new WebAction(driver);
        PageFactory.initElements(this.driver,this);
    }

    public void clickCheckout(){
        actor.click(checkoutButton);
    }

    public CheckoutStepOnePage continueCheckout(){
        System.out.println("click Checkout");
        clickCheckout();
        return new CheckoutStepOnePage(driver);
    }
}
