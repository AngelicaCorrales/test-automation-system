package com.endava.training.gui.test.mortgagecalculator;

import com.endava.training.gui.dto.mortgagecalculator.SimpleMortgageCalculatorForm;
import com.endava.training.gui.dto.UIMessage;
import com.endava.training.gui.page.mortgagecalculator.FreeToolsPage;
import com.endava.training.gui.page.mortgagecalculator.HomePage;
import com.endava.training.gui.utils.ConfigManager;
import com.endava.training.gui.utils.DataReader;
import com.endava.training.gui.utils.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.endava.training.gui.constants.mortgagecalculator.MortgagecalculatorTestDataConstants.*;
import static org.junit.jupiter.api.Assertions.*;


public class FreeToolsTest {

    private WebDriver driver;
    private WebDriverManager webDriverManager;
    private final DataReader result = new DataReader(ConfigManager.getProperty("mortgagecalculatorTestResult"));
    private final DataReader mortgagecalculatorData = new DataReader(ConfigManager.getProperty("mortgagecalculatorTestData"));
    private FreeToolsPage freeToolsPage;

    @BeforeEach
    public void setUp() {
        System.out.println("***Starting test setup...");
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        HomePage homePage = new HomePage(driver);
        driver.get(ConfigManager.getProperty("mortgagecalculatorBaseURL"));
        System.out.println("Go to Free Tools...");
        freeToolsPage= homePage.goToFreeTools();
        System.out.println("***Test setup completed");
    }
    @Test
    public void successSimpleMortgageCalculation() {
       System.out.println("***Starting successSimpleMortgageCalculation execution");
        System.out.println("Initializing test data");
       SimpleMortgageCalculatorForm simpleMortgageCalculatorForm = mortgagecalculatorData.getData(VALID_SIMPLE_MORTGAGE_CALCULATOR_FORM, SimpleMortgageCalculatorForm.class);
        System.out.println("Initializing test result");
       UIMessage calculationResult = result.getData(SUCCESS_SIMPLE_MORTGAGE_CALCULATION, UIMessage.class);
        System.out.println("Calculating with simple calculator...");
       freeToolsPage.calculateWithSimpleCalculator(simpleMortgageCalculatorForm.getLoanAmountSimpleCalculator(),simpleMortgageCalculatorForm.getInterestRateSimpleCalculator(),simpleMortgageCalculatorForm.getTermLengthSimpleCalculator());

        assertEquals(calculationResult.getMainMessage(),freeToolsPage.getMonthlyPaymentSimpleCalculator());
        System.out.println("***SuccessSimpleMortgageCalculation execution completed");
    }

    @AfterEach
    public void tearDown() {
        webDriverManager.quitDriver();
    }
}
