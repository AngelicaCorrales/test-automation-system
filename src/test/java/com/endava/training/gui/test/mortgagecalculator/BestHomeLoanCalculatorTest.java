package com.endava.training.gui.test.mortgagecalculator;

import com.endava.training.gui.dto.HomeLoanForm;
import com.endava.training.gui.dto.HomeLoanResults;
import com.endava.training.gui.dto.LoanForm;
import com.endava.training.gui.dto.LoanResults;
import com.endava.training.gui.page.mortgagecalculator.BestHomeLoanCalculatorPage;
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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BestHomeLoanCalculatorTest {
    private WebDriver driver;
    private WebDriverManager webDriverManager;
    private final DataReader result = new DataReader(ConfigManager.getProperty("mortgagecalculatorTestResult"));
    private final DataReader mortgagecalculatorData = new DataReader(ConfigManager.getProperty("mortgagecalculatorTestData"));
    private BestHomeLoanCalculatorPage bestHomeLoanCalculatorPage;

    @BeforeEach
    public void setUp() {
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        HomePage homePage = new HomePage(driver);
        driver.get(ConfigManager.getProperty("mortgagecalculatorBaseURL"));

        LoanCalculatorPage loanCalculatorPage= homePage.goToLoanCalculator();
        bestHomeLoanCalculatorPage= loanCalculatorPage.goToBestHomeLoanCalculator();
    }

    @Test
    public void successBestHomeLoanCalculation() {
        HomeLoanForm homeLoanForm= mortgagecalculatorData.getData(VALID_HOME_LOAN1_FORM, HomeLoanForm.class);
        HomeLoanResults homeLoanResults = result.getData(SUCCESS_HOME_LOAN_CALCULATION, HomeLoanResults.class);

        bestHomeLoanCalculatorPage.calculateHomeLoan1(homeLoanForm.getHomePrice(),homeLoanForm.getDownPayment(),homeLoanForm.getLoanAmount(),homeLoanForm.getMortgageTerm(),homeLoanForm.getInterestRate(),homeLoanForm.getDiscountPoints(),homeLoanForm.getLoanOriginationFees(),homeLoanForm.getOtherClosingCosts());
        assertAll(
                "Grouped Assertions of Home Loan Calculation Result",
                ()->assertEquals(homeLoanResults.getAmountFinancedLoan1(),bestHomeLoanCalculatorPage.getAmountFinancedLoan1()),
                ()->assertEquals(homeLoanResults.getAmountFinancedLoan2(),bestHomeLoanCalculatorPage.getAmountFinancedLoan2()),
                ()->assertEquals(homeLoanResults.getLoanTermLoan1(),bestHomeLoanCalculatorPage.getLoanTermLoan1()),
                ()->assertEquals(homeLoanResults.getLoanTermLoan2(),bestHomeLoanCalculatorPage.getLoanTermLoan2()),
                ()->assertEquals(homeLoanResults.getMonthlyPrincipalInterestPaymentLoan1(),bestHomeLoanCalculatorPage.getMonthlyPrincipalInterestPaymentLoan1()),
                ()->assertEquals(homeLoanResults.getMonthlyPrincipalInterestPaymentLoan2(),bestHomeLoanCalculatorPage.getMonthlyPrincipalInterestPaymentLoan2()),
                ()->assertEquals(homeLoanResults.getCostDiscountPointsLoan1(),bestHomeLoanCalculatorPage.getCostDiscountPointsLoan1()),
                ()->assertEquals(homeLoanResults.getCostDiscountPointsLoan2(),bestHomeLoanCalculatorPage.getCostDiscountPointsLoan2()),
                ()->assertEquals(homeLoanResults.getLoanOriginationFeesLoan1(),bestHomeLoanCalculatorPage.getLoanOriginationFeesLoan1()),
                ()->assertEquals(homeLoanResults.getLoanOriginationFeesLoan2(),bestHomeLoanCalculatorPage.getLoanOriginationFeesLoan2()),
                ()->assertEquals(homeLoanResults.getOtherClosingCostsLoan1(),bestHomeLoanCalculatorPage.getOtherClosingCostsLoan1()),
                ()->assertEquals(homeLoanResults.getOtherClosingCostsLoan2(),bestHomeLoanCalculatorPage.getOtherClosingCostsLoan2()),
                ()->assertEquals(homeLoanResults.getTotalClosingCostsLoan1(),bestHomeLoanCalculatorPage.getTotalClosingCostsLoan1()),
                ()->assertEquals(homeLoanResults.getTotalClosingCostsLoan2(),bestHomeLoanCalculatorPage.getTotalClosingCostsLoan2()),
                ()->assertEquals(homeLoanResults.getTotalMonthlyPaymentsLoan1(),bestHomeLoanCalculatorPage.getTotalMonthlyPaymentsLoan1()),
                ()->assertEquals(homeLoanResults.getTotalMonthlyPaymentsLoan2(),bestHomeLoanCalculatorPage.getTotalMonthlyPaymentsLoan2()),
                ()->assertEquals(homeLoanResults.getPaymentsSavingsLoan1(),bestHomeLoanCalculatorPage.getPaymentsSavingsLoan1()),
                ()->assertEquals(homeLoanResults.getPaymentsSavingsLoan2(),bestHomeLoanCalculatorPage.getPaymentsSavingsLoan2()),
                ()->assertEquals(homeLoanResults.getTotalInterestExpenseLoan1(),bestHomeLoanCalculatorPage.getTotalInterestExpenseLoan1()),
                ()->assertEquals(homeLoanResults.getTotalInterestExpenseLoan2(),bestHomeLoanCalculatorPage.getTotalInterestExpenseLoan2()),
                ()->assertEquals(homeLoanResults.getTotalInterestSavingsLoan1(),bestHomeLoanCalculatorPage.getTotalInterestSavingsLoan1()),
                ()->assertEquals(homeLoanResults.getTotalInterestSavingsLoan2(),bestHomeLoanCalculatorPage.getTotalInterestSavingsLoan2())
                );
    }

    @AfterEach
    public void tearDown() {
        webDriverManager.quitDriver();
    }

}
