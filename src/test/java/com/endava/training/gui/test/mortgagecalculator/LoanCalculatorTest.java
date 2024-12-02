package com.endava.training.gui.test.mortgagecalculator;

import com.endava.training.gui.dto.LoanForm;
import com.endava.training.gui.dto.LoanResults;
import com.endava.training.gui.page.mortgagecalculator.HomePage;
import com.endava.training.gui.page.mortgagecalculator.LoanCalculatorPage;
import com.endava.training.gui.utils.ConfigManager;
import com.endava.training.gui.utils.DataReader;
import com.endava.training.gui.utils.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static com.endava.training.gui.constants.TestDataConstants.*;
import static org.junit.jupiter.api.Assertions.*;

public class LoanCalculatorTest {

    private WebDriver driver;
    private WebDriverManager webDriverManager;
    private final DataReader result = new DataReader(ConfigManager.getProperty("mortgagecalculatorTestResult"));
    private final DataReader mortgagecalculatorData = new DataReader(ConfigManager.getProperty("mortgagecalculatorTestData"));
    private LoanCalculatorPage loanCalculatorPage;

    @BeforeEach
    public void setUp() {
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        HomePage homePage = new HomePage(driver);
        driver.get(ConfigManager.getProperty("mortgagecalculatorBaseURL"));

        loanCalculatorPage= homePage.goToLoanCalculator();
    }

    @Test
    public void successLoanCalculation() {
        LoanForm loanForm= mortgagecalculatorData.getData(VALID_LOAN_FORM, LoanForm.class);
        LoanResults loanResults = result.getData(SUCCESS_LOAN_CALCULATION, LoanResults.class);

        loanCalculatorPage.calculateLoan(loanForm.getPurchasePrice(),loanForm.getSalesTax(),loanForm.getFinanceApplicationFees(),loanForm.getDownpayment(),loanForm.getLoanAmount(),loanForm.getLoanTermOption(),loanForm.getLoanTermInput(),loanForm.getInterestRate(),loanForm.getPaymentsFrequency());
        assertAll(
                "Grouped Assertions of Loan Calculation Result",
                ()->assertEquals(loanCalculatorPage.getPaymentAmount(),loanResults.getPaymentAmount()),
                ()->assertTrue(loanCalculatorPage.getAmountFinanced().contains(loanResults.getAmountFinanced())),
                ()->assertTrue(loanCalculatorPage.getTotalInterestYouWillPay().contains(loanResults.getTotalInterestYouWillPay())),
                ()->assertTrue(loanCalculatorPage.getSalesTaxResult().contains(loanResults.getSalesTaxResult())),
                ()->assertTrue(loanCalculatorPage.getNumberPaymentsUntilRepaid().contains(loanResults.getNumberPaymentsUntilRepaid())),
                ()->assertTrue(loanCalculatorPage.getTotalCostPurchase().contains(loanResults.getTotalCostPurchase()))
        );
    }

    @AfterEach
    public void tearDown() {
        webDriverManager.quitDriver();
    }
}
