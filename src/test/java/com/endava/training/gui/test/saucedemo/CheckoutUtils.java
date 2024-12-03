package com.endava.training.gui.test.saucedemo;

import com.endava.training.gui.dto.saucedemo.CheckoutInfo;
import com.endava.training.gui.page.saucedemo.CartPage;
import com.endava.training.gui.page.saucedemo.CheckoutCompletePage;
import com.endava.training.gui.page.saucedemo.CheckoutStepOnePage;
import com.endava.training.gui.page.saucedemo.CheckoutStepTwoPage;
import com.endava.training.gui.utils.DataReader;

import static com.endava.training.gui.constants.saucedemo.SaucedemoTestDataConstants.*;

public class CheckoutUtils {

    public static CheckoutCompletePage checkoutProcess(CartPage cartPage, DataReader saucedemoData){
        System.out.println("Initializing test data");
        CheckoutInfo info = saucedemoData.getData(VALID_CHECKOUT_INFO, CheckoutInfo.class);
        System.out.println("Step one: continue Checkout");
        CheckoutStepOnePage checkoutStepOnePage = cartPage.continueCheckout();
        System.out.println("Step two: continueCheckout");
        CheckoutStepTwoPage checkoutStepTwoPage= checkoutStepOnePage.successContinueCheckout(info.getFirstName(), info.getLastName(), info.getZipCode());
        System.out.println("finish Checkout...");
        return checkoutStepTwoPage.finishCheckout();
    }
}
