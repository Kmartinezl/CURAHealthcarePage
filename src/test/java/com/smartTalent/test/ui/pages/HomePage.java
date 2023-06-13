package com.smartTalent.test.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class HomePage extends Page {

    private By makeButton = By.id("btn-make-appointment");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickMakeButton(){
        driver.findElement(makeButton).click();
    }
}
