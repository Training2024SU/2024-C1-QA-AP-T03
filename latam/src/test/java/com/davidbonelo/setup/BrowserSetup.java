package com.davidbonelo.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class BrowserSetup {
    public static WebDriver getBrowserDriver(BrowserType browserType) {
        switch (browserType) {
            case CHROME -> {
                ChromeOptions co = new ChromeOptions();
                co.addArguments("--remote-allow-origins=*");
                co.addArguments("--incognito");
                co.addArguments("--disable-notifications");
//                co.addArguments("--window-size=1280,720");
//                co.addArguments("--headless");
                return new ChromeDriver(co);
            }
            case FIREFOX -> {
                var fo = new FirefoxOptions();
//                fo.addArguments("--width=1280");
//                fo.addArguments("--height=720");
                fo.addArguments("-private");
                fo.addPreference("extensions.allowPrivateBrowsingByDefault", true);
                var fp = new FirefoxProfile();
                fp.setPreference("browser.privatebrowsing.autostart", true);
                fo.setProfile(fp);
//                fo.addArguments("-headless");
                return new FirefoxDriver(fo);
            }
            default -> throw new IllegalArgumentException("Incorrect browser type");
        }
    }

    public enum BrowserType {
        CHROME, FIREFOX
    }
}
