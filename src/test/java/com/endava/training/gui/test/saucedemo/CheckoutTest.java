package com.endava.training.gui.test.saucedemo;

import com.endava.training.gui.dto.UIMessage;
import com.endava.training.gui.dto.User;
import com.endava.training.gui.page.saucedemo.*;
import com.endava.training.gui.utils.ConfigManager;
import com.endava.training.gui.utils.DataReader;
import com.endava.training.gui.utils.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.endava.training.gui.constants.saucedemo.SaucedemoTestDataConstants.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutTest {

    private WebDriver driver;
    private WebDriverManager webDriverManager;
    private final DataReader result = new DataReader(ConfigManager.getProperty("saucedemoTestResult"));
    private final DataReader saucedemoData = new DataReader(ConfigManager.getProperty("saucedemoTestData"));
    private InventoryPage inventoryPage;

    @BeforeEach
    public void setUp() {
        System.out.println("***Starting test setup...");
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        driver.get(ConfigManager.getProperty("saucedemoBaseURL"));
        System.out.println("Initializing user");
        User validUser= saucedemoData.getData(VALID_USER, User.class);
        System.out.println("Login");
        inventoryPage= loginPage.successLoginUser(validUser.getUsername(), validUser.getPassword());
        System.out.println("***Test setup completed");
    }

    @Test
    public void successOneProductCheckout() {
        System.out.println("***Starting successOneProductCheckout execution");
        System.out.println("Initializing test result");
        UIMessage message = result.getData(SUCCESS_CHECKOUT, UIMessage.class);
        System.out.println("Adding First Product To Cart...");
        CartPage cartPage= inventoryPage.addFirstProductToCart(SORT_PRICE_HIGH_LOW);
        System.out.println("Starting checkout process...");
        CheckoutCompletePage checkoutCompletePage = CheckoutUtils.checkoutProcess(cartPage,saucedemoData);

        assertTrue(checkoutCompletePage.getCheckoutCompleteHeader().contains(message.getMainMessage()));
        assertTrue(checkoutCompletePage.getCheckoutCompleteText().contains(message.getSecondaryMessage()));
        System.out.println("***SuccessOneProductCheckout execution completed");
    }

    @AfterEach
    public void tearDown() {
        webDriverManager.quitDriver();
    }
}
