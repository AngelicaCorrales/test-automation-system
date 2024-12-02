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

import static com.endava.training.gui.constants.TestDataConstants.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutTest {

    private WebDriver driver;
    private WebDriverManager webDriverManager;
    private final DataReader result = new DataReader(ConfigManager.getProperty("saucedemoTestResult"));
    private final DataReader saucedemoData = new DataReader(ConfigManager.getProperty("saucedemoTestData"));
    private InventoryPage inventoryPage;

    @BeforeEach
    public void setUp() {
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        driver.get(ConfigManager.getProperty("saucedemoBaseURL"));

        User validUser= saucedemoData.getData(VALID_USER, User.class);
        inventoryPage= loginPage.successLoginUser(validUser.getUsername(), validUser.getPassword());
    }

    @Test
    public void successOneProductCheckout() {
        UIMessage message = result.getData(SUCCESS_CHECKOUT, UIMessage.class);
        CartPage cartPage= inventoryPage.addFirstProductToCart(SORT_PRICE_HIGH_LOW);
        CheckoutCompletePage checkoutCompletePage = CheckoutUtils.checkoutProccess(cartPage,saucedemoData);

        assertTrue(checkoutCompletePage.getCheckoutCompleteHeader().contains(message.getMainMessage()));
        assertTrue(checkoutCompletePage.getCheckoutCompleteText().contains(message.getSecondaryMessage()));

    }

    @AfterEach
    public void tearDown() {
        webDriverManager.quitDriver();
    }
}
