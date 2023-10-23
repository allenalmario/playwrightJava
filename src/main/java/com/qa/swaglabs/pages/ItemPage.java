package com.qa.swaglabs.pages;

import com.microsoft.playwright.Page;

public class ItemPage {

    Page page;

    // locators
    private String itemName = "div[class='inventory_details_name large_size']";
    private String addtoCartButton = "button[class='btn btn_primary btn_small btn_inventory']";
    private String shoppingCartLink = "a[class='shopping_cart_link']";

    // constructor
    public ItemPage(Page page) {
        this.page = page;
    }

    // actions/methods
    public String getItemName() {
        return page.innerText(itemName);
    }

    public void clickAddToCartButton() {
        System.out.println("Clicking on Add to Cart button");
        page.click(addtoCartButton);
    }

    public void clickOnShoppingCartLink() {
        System.out.println("Clicking on shopping cart link");
        page.click(shoppingCartLink);
    }

    public CartPage getCartPage() {
        return new CartPage(page);
    }

}
