package com.endava.training.gui.test.saucedemo;

import com.endava.training.gui.page.saucedemo.CartPage;
import com.endava.training.gui.page.saucedemo.CheckoutCompletePage;
import com.endava.training.gui.page.saucedemo.CheckoutStepOnePage;
import com.endava.training.gui.page.saucedemo.CheckoutStepTwoPage;

public class CheckoutUtils {

    public static CheckoutCompletePage checkoutProccess(CartPage cartPage){
        //TODO JSON
        CheckoutStepOnePage checkoutStepOnePage = cartPage.continueCheckout();
        CheckoutStepTwoPage checkoutStepTwoPage= checkoutStepOnePage.successContinueCheckout("John","Doe","70000");
        return checkoutStepTwoPage.finishCheckout();
    }
}
