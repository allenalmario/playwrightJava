package com.qa.swaglabs.pages;

import com.microsoft.playwright.Page;

public class HomePage {

    Page page;

    // locators

    private String productsTitle = "span[class='title']";
    private String hamburgerMenu = "button[id='react-burger-menu-btn']";
    private String logoutLink = "a[id='logout_sidebar_link']";
    private String bacpackLink = "a[id='item_4_title_link']";

    // constructor

    public HomePage(Page page) {
        this.page = page;
    }

    public String getProductsTitle() {
        return page.innerText(productsTitle);
    }

    public void clickHamburgerMenu() {
        System.out.println("Clicking on the hamburger menu");
        page.click(hamburgerMenu);
    }

    public void clickLogoutLink() {
        System.out.println("Clicking on the logout link");
        page.click(logoutLink);
    }

    public void clickBackpackLink() {
        System.out.println("Clicking on Backpack link");
        page.click(bacpackLink);
    }

    public ItemPage getItemPage() {
        return new ItemPage(page);
    }

}
