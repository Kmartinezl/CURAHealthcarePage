package com.smartTalent.test.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AppointmentConfirmationPage extends Page {

    private By goToHomepageButton = By.cssSelector(".btn.btn-default");
    public AppointmentConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public void clickGoToHomepageButton(){
        driver.findElement(goToHomepageButton).click();
    }
}
