package com.endava.training.gui.page.saucedemo;

import com.endava.training.gui.actions.WebAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOnePage {
    private final WebDriver driver;
    WebAction actor;

    @FindBy(id="first-name")
    private WebElement firstNameInput;

    @FindBy(id="last-name")
    private WebElement lastNameInput;

    @FindBy(id="postal-code")
    private WebElement zipCodeInput;

    @FindBy(id="continue")
    private WebElement continueButton;

    public CheckoutStepOnePage(WebDriver driver){
        this.driver=driver;
        actor= new WebAction(driver);
        PageFactory.initElements(this.driver,this);
    }

    public void enterFirstName(String firstName) {
        actor.sendKeys(firstName, firstNameInput);
    }

    public void enterLastName(String lastName) {
        actor.sendKeys(lastName, lastNameInput);
    }
    public void enterZipCode(String zipCode) {
        actor.sendKeys(zipCode, zipCodeInput);
    }

    public void clickContinue(){
        actor.click(continueButton);
    }

    public void continueCheckout(String firstName, String lastName, String zipCode){
        enterFirstName(firstName);
        enterLastName(lastName);
        enterZipCode(zipCode);
        clickContinue();
    }

    public CheckoutStepTwoPage successContinueCheckout(String firstName, String lastName, String zipCode){
        continueCheckout(firstName,lastName,zipCode);
        return new CheckoutStepTwoPage(driver);
    }

}
