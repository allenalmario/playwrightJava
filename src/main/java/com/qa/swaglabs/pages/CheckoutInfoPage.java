package com.qa.swaglabs.pages;

import com.microsoft.playwright.Page;

public class CheckoutInfoPage {

    Page page;

    // locators
    private String firstNameField = "input[id='first-name']";
    private String lastNameField = "input[id='last-name']";
    private String postalCodeField = "input[id='postal-code']";
    private String continueButton = "input[id='continue']";

    // constructor
    public CheckoutInfoPage(Page page) {
        this.page = page;
    }

    // actions/methods
    public void fillFirstNameField() {
        page.fill(firstNameField, "Test");
    }

    public void fillLastNameField() {
        page.fill(lastNameField,"Automation");
    }

    public void fillPostalField() {
        page.fill(postalCodeField, "12345");
    }

    public void clickContinueButton() {
        System.out.println("Clicking on continue button");
        page.click(continueButton);
    }

    public CheckoutOverviewPage getCheckoutOverviewPage() {
        return new CheckoutOverviewPage(page);
    }

    public CheckoutCompletePage getCheckoutCompletePage() {
        return new CheckoutCompletePage(page);
    }

}
