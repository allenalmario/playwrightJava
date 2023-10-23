package com.qa.swaglabs.base;

// All precondtions and after test cases, what to do
// every testNG test case will execute the startup and tearDown method

import com.microsoft.playwright.Page;
import com.qa.swaglabs.factory.PlaywrightFactory;
import com.qa.swaglabs.pages.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    PlaywrightFactory pf;
    protected Page page;
    Properties prop;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected ItemPage itemPage;
    protected CartPage cartPage;
    protected CheckoutInfoPage checkoutInfoPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected CheckoutCompletePage checkoutCompletePage;


    @BeforeTest
    public void setup() throws IOException {
        System.out.println("Initialized browser");
        pf = new PlaywrightFactory();
        prop = pf.init_prop();
        page = pf.initBrowser(prop);
        loginPage = new LoginPage(page, prop);
        homePage = new HomePage(page);
        loginPage.login();
    }

    @AfterTest
    public void tearDown() {
        System.out.println("Tearing down browser");
        page.context().browser().close();
    }

}
