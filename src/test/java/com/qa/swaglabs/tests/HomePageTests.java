package com.qa.swaglabs.tests;

import com.qa.swaglabs.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    @Test
    public void homePageTitleTest() {
        homePage = loginPage.getHomePage();
        System.out.println("Testing if on the Home Page of Swag Labs");
        String actualTitle = homePage.getProductsTitle();
        Assert.assertEquals(actualTitle, "Products");
    }

    @Test
    public void logoutTest() {
        homePage = loginPage.getHomePage();
        System.out.println("Testing if logging out works");
        homePage.clickHamburgerMenu();
        homePage.clickLogoutLink();
        Assert.assertTrue(page.isVisible(loginPage.getLoginButton()));
        System.out.println("Logged out of Swag Labs");
    }

}
