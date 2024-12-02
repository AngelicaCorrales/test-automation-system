package com.endava.training.gui.test.mortgagecalculator;

import com.endava.training.gui.dto.mortgagecalculator.HomeLoanForm;
import com.endava.training.gui.dto.mortgagecalculator.HomeLoanResults;
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

import static com.endava.training.gui.constants.mortgagecalculator.MortgagecalculatorTestDataConstants.*;
import static org.junit.jupiter.api.Assertions.*;

public class BestHomeLoanCalculatorTest {
    private WebDriver driver;
    private WebDriverManager webDriverManager;
    private final DataReader result = new DataReader(ConfigManager.getProperty("mortgagecalculatorTestResult"));
    private final DataReader mortgagecalculatorData = new DataReader(ConfigManager.getProperty("mortgagecalculatorTestData"));
    private BestHomeLoanCalculatorPage bestHomeLoanCalculatorPage;

    @BeforeEach
    public void setUp() {
        System.out.println("***Starting test setup...");
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        HomePage homePage = new HomePage(driver);
        driver.get(ConfigManager.getProperty("mortgagecalculatorBaseURL"));

        System.out.println("Go to loan calculator...");
        LoanCalculatorPage loanCalculatorPage= homePage.goToLoanCalculator();
        System.out.println("Go to best home loan calculator...");
        bestHomeLoanCalculatorPage= loanCalculatorPage.goToBestHomeLoanCalculator();
        System.out.println("***Test setup completed");
    }

    @Test
    public void successBestHomeLoanCalculation() {
        System.out.println("***Starting successBestHomeLoanCalculation execution");
        System.out.println("Initializing test data");
        HomeLoanForm homeLoanForm= mortgagecalculatorData.getData(VALID_HOME_LOAN1_FORM, HomeLoanForm.class);
        System.out.println("Initializing test result");
        HomeLoanResults homeLoanResults = result.getData(SUCCESS_HOME_LOAN_CALCULATION, HomeLoanResults.class);
        System.out.println("Calculating Home Loan 1...");
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
        System.out.println("***SuccessBestHomeLoanCalculation execution completed");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Closing window");
        webDriverManager.quitDriver();
    }

}
