package com.qa.swaglabs.pages;

import com.microsoft.playwright.Page;

public class CheckoutOverviewPage {

    Page page;

    // locators
    private String itemName = "div[class='inventory_item_name']";
    private String finishButton = "button[id='finish']";

    // constructor
    public CheckoutOverviewPage(Page page) {
        this.page = page;
    }

    // actions/methods
    public String getItemName() {
        return page.innerText(itemName);
    }

    public void clickOnFinishButton() {
        System.out.println("clicking on finish button");
        page.click(finishButton);
    }

    public CheckoutCompletePage getCheckoutCompletePage() {
        return new CheckoutCompletePage(page);
    }

}
