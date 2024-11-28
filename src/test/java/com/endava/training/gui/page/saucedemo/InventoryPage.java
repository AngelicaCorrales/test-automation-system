package com.endava.training.gui.page.saucedemo;

import com.endava.training.gui.actions.WebAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

    private final WebDriver driver;
    WebAction actor;

    @FindBy()
    private WebElement sortDropdown;

    @FindBy()
    private WebElement addFirstToCartButton;

    @FindBy()
    private WebElement cartButton;

    public InventoryPage(WebDriver driver){
        this.driver=driver;
        actor= new WebAction(driver);
        PageFactory.initElements(this.driver,this);
    }

    public void sortProducts(String text){
        actor.sendKeys(text,sortDropdown);
    }

    public void clickAddToCart(WebElement addToCartButton){
        actor.click(addToCartButton);
    }

    public void clickCart(){
        actor.click(cartButton);
    }

    public CartPage addFirstProductToCart(String sort){
        sortProducts(sort);
        clickAddToCart(addFirstToCartButton);
        clickCart();
        return new CartPage(driver);
    }

}
