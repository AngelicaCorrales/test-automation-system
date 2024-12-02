package com.endava.training.gui.test.timeanddate;

import com.endava.training.gui.dto.UIMessage;
import com.endava.training.gui.page.timeanddate.DaysCalculatorPage;
import com.endava.training.gui.page.timeanddate.HomePage;
import com.endava.training.gui.utils.ConfigManager;
import com.endava.training.gui.utils.DataReader;
import com.endava.training.gui.utils.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.endava.training.gui.constants.timeanddate.TimeanddateTestDataConstants.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DaysCalculatorTest {

    private WebDriver driver;
    private WebDriverManager webDriverManager;
    private final DataReader result = new DataReader(ConfigManager.getProperty("timeanddateTestResult"));
    private final DataReader timeanddateData = new DataReader(ConfigManager.getProperty("timeanddateTestData"));
    private DaysCalculatorPage daysCalculatorPage;

    @BeforeEach
    public void setUp() {
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        HomePage homePage = new HomePage(driver);
        driver.get(ConfigManager.getProperty("timeanddateBaseURL"));

        daysCalculatorPage= homePage.goToDateToDateCalculator();
    }

    @Test
    public void successDateToDateCalculation() {
        UIMessage message = result.getData(SUCCESS_DATE_TO_DATE_CALCULATION, UIMessage.class);
        daysCalculatorPage.calculateDuration();
        System.out.println(daysCalculatorPage.getResult());
        assertTrue(daysCalculatorPage.getResult().contains(message.getMainMessage()));
    }

    @AfterEach
    public void tearDown() {
        webDriverManager.quitDriver();
    }

}
