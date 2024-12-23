package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // Locators
    By emailField = By.name("email_id");
    By passwordField = By.name("pwd");
    By loginButton = By.tagName("button");
    By signupLink = By.linkText("Not a member? Signup");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void clickSignup() {
        driver.findElement(signupLink).click();
    }
}