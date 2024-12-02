package com.endava.training.gui.test.saucedemo;

import com.endava.training.gui.dto.saucedemo.CheckoutInfo;
import com.endava.training.gui.page.saucedemo.CartPage;
import com.endava.training.gui.page.saucedemo.CheckoutCompletePage;
import com.endava.training.gui.page.saucedemo.CheckoutStepOnePage;
import com.endava.training.gui.page.saucedemo.CheckoutStepTwoPage;
import com.endava.training.gui.utils.DataReader;

import static com.endava.training.gui.constants.saucedemo.SaucedemoTestDataConstants.*;

public class CheckoutUtils {

    public static CheckoutCompletePage checkoutProccess(CartPage cartPage, DataReader saucedemoData){
        CheckoutInfo info = saucedemoData.getData(VALID_CHECKOUT_INFO, CheckoutInfo.class);
        CheckoutStepOnePage checkoutStepOnePage = cartPage.continueCheckout();
        CheckoutStepTwoPage checkoutStepTwoPage= checkoutStepOnePage.successContinueCheckout(info.getFirstName(), info.getLastName(), info.getZipCode());
        return checkoutStepTwoPage.finishCheckout();
    }
}
