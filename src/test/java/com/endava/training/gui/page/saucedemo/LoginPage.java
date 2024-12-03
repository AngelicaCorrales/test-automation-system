package com.endava.training.gui.page.saucedemo;

import com.endava.training.gui.actions.WebAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final WebDriver driver;
    WebAction actor;

    @FindBy(id="user-name")
    private WebElement usernameInput;

    @FindBy(id="password")
    private WebElement passwordInput;

    @FindBy(id="login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        actor= new WebAction(driver);
        PageFactory.initElements(this.driver,this);
    }

    public void enterUsername(String username) {
        actor.sendKeys(username, usernameInput);
    }

    public void enterPassword(String password) {
        actor.sendKeys(password, passwordInput);
    }

    public void clickLogin() {
        actor.click(loginButton);
    }

    public void loginUser(String username, String password) {
        System.out.println("enter Username");
        enterUsername(username);
        System.out.println("enter Password");
        enterPassword(password);
        System.out.println("click Login");
        clickLogin();
    }

    public InventoryPage successLoginUser(String username, String password) {
        loginUser(username, password);
        return new InventoryPage(driver);
    }

    public void failureLoginUser(String username, String password){
        loginUser(username, password);
    }

}
