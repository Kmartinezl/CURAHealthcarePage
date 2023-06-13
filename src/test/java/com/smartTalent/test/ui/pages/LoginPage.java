package com.smartTalent.test.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Page {
    public By usernameField = By.id("txt-username");
    public By passwordField = By.id("txt-password");
    public By loginButton = By.id("btn-login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillUsernameField(){
        driver.findElement(usernameField).sendKeys("John Doe");
    }
    public void fillPasswordField(){
        driver.findElement(passwordField).sendKeys("ThisIsNotAPassword");
    }
    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
