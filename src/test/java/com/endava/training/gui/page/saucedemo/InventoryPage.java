package com.endava.training.gui.page.saucedemo;

import com.endava.training.gui.actions.WebAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {

    private final WebDriver driver;
    WebAction actor;

    @FindBy(css=".product_sort_container")
    private WebElement sortDropdown;

    @FindBy(css="div.inventory_list > div:first-of-type > div.inventory_item_description > div.pricebar > button")
    private WebElement addFirstToCartButton;

    @FindBy(id="shopping_cart_container")
    private WebElement cartButton;

    public InventoryPage(WebDriver driver){
        this.driver=driver;
        actor= new WebAction(driver);
        PageFactory.initElements(this.driver,this);
    }

    public void sortProducts(String text){
        actor.selectElement(text,sortDropdown);
    }

    public void clickAddToCart(WebElement addToCartButton){
        actor.click(addToCartButton);
    }

    public void clickCart(){
        actor.click(cartButton);
    }

    public CartPage addFirstProductToCart(String sort){
        System.out.println("sort Products");
        sortProducts(sort);
        System.out.println("click Add To Cart");
        clickAddToCart(addFirstToCartButton);
        System.out.println("click Cart");
        clickCart();
        return new CartPage(driver);
    }

}
