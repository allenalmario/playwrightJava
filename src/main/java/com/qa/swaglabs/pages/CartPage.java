package com.qa.swaglabs.pages;

import com.microsoft.playwright.Page;

public class CartPage {

    Page page;

    // locators
    private String cartItemName = "div[class='inventory_item_name']";
    private String checkOutButton = "button[class='btn btn_action btn_medium checkout_button ']";

    // constructor
    public CartPage(Page page) {
        this.page = page;
    }

    // actions/methods
    public String getItemName() {
        return page.innerText(cartItemName);
    }

    public void clickCheckoutButton() {
        System.out.println("Clicking on checkout button");
        page.click(checkOutButton);
    }

    public CheckoutInfoPage getCheckoutInfoPage() {
        return new CheckoutInfoPage(page);
    }

}
