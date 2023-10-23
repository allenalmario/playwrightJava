package com.qa.swaglabs.tests;

import com.qa.swaglabs.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckOutTests extends BaseTest {

    @Test
    public void checkoutOneItemTest() {
        itemPage = homePage.getItemPage();
        System.out.println("Testing the checkout functionality");
        homePage.clickBackpackLink();
        Assert.assertEquals(itemPage.getItemName(), "Sauce Labs Backpack");
        itemPage.clickAddToCartButton();
        itemPage.clickOnShoppingCartLink();
        cartPage = itemPage.getCartPage();
        Assert.assertEquals(cartPage.getItemName(), "Sauce Labs Backpack");
        cartPage.clickCheckoutButton();
        checkoutInfoPage = cartPage.getCheckoutInfoPage();
        checkoutInfoPage.fillFirstNameField();
        checkoutInfoPage.fillLastNameField();
        checkoutInfoPage.fillPostalField();
        checkoutInfoPage.clickContinueButton();
        checkoutOverviewPage = checkoutInfoPage.getCheckoutOverviewPage();
        Assert.assertEquals(checkoutOverviewPage.getItemName(), "Sauce Labs Backpack");
        checkoutOverviewPage.clickOnFinishButton();
        checkoutCompletePage = checkoutOverviewPage.getCheckoutCompletePage();
        Assert.assertEquals(checkoutCompletePage.getCheckoutCompleteText(), "Thank you for your order!");
        checkoutCompletePage.clickBackHomeButton();
    }

}
