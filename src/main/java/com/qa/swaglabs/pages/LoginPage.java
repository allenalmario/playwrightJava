package com.qa.swaglabs.pages;

import com.microsoft.playwright.Page;

import java.util.Properties;

public class LoginPage {

    /* this page reference, we can perform methods on the locators
    *  the page object comes from PlaywrightFactory, which is instantiated from the constructor */
    Page page;
    Properties prop;

    // String locators

    private String usernameField = "input[id='user-name']";
    private String passwordField = "input[id='password']";
    private String loginButton = "input[id='login-button']";

    // page constructor

    public LoginPage(Page page, Properties prop) {
        this.page = page;
        this.prop = prop;
    }

    // page actions/methods

    public void login() {
        System.out.println("Logging into Swag Labs");
        page.fill(usernameField, prop.getProperty("username"));
        page.fill(passwordField, prop.getProperty("password"));
        page.click(loginButton);
    }

    public String getLoginButton() {
        return loginButton;
    }

    // pass page object to HomePage, practicing Page Chaining
    public HomePage getHomePage() {
        return new HomePage(page);
    }

}
