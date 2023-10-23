package com.qa.swaglabs.pages;

import com.microsoft.playwright.Page;

public class CheckoutCompletePage {

    Page page;

    // locators
    private String checkoutCompleteText = "h2[class='complete-header']";
    private String backHomeButton = "button[id='back-to-products']";

    // constructor
    public CheckoutCompletePage(Page page) {
        this.page = page;
    }

    // actions/methods
    public String getCheckoutCompleteText() {
        return page.innerText(checkoutCompleteText);
    }

    public void clickBackHomeButton() {
        System.out.println("Clicking on Back Home button");
        page.click(backHomeButton);
    }

}
