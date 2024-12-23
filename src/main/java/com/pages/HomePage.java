package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    // Locators
    By homeLink = By.linkText("Home");
    By loginLink = By.linkText("Login/Signup");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void clickHome() {
        driver.findElement(homeLink).click();
    }

    public void clickLogin() {
        driver.findElement(loginLink).click();
    }
}