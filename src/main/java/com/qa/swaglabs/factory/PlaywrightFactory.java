package com.qa.swaglabs.factory;

/* The purpose of this class is */

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    Properties prop;

//    the purpose of this method is to initialize playwright
    public Page initBrowser(Properties prop) {

        String browserName = prop.getProperty("browser").trim();

        System.out.println("Browser name is: " + browserName);

        // this returns a playwright object reference
        // it can then be used in any method in this class
        playwright = Playwright.create();

        // cross browser logic
        switch (browserName.toLowerCase().trim()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "safari":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            default:
                System.out.println("Please pass the right browser name...");
                break;
        }

        // this will give a fresh browser context;
        browserContext = browser.newContext();

        // this will give a fresh page
        page = browserContext.newPage();

        // navigates to given url;
        page.navigate(prop.getProperty("url").trim());

        return page;

    }

    /**
     * This method is used to initialize the properties from config file
     * */
    public Properties init_prop() throws IOException {

        // this will make connection to config.properties and will load all the properties in the form of key and value pairs format
        // all the properties will be given to the prop object reference
        FileInputStream ip = new FileInputStream("./src/main/resources/config/config.properties");
        // Properties class is used to load the properties from the fileinputstream object
        prop = new Properties();
        prop.load(ip);

        return prop;

    }

}
