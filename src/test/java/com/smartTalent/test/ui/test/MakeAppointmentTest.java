package com.smartTalent.test.ui.test;

import com.smartTalent.test.ui.pages.AppointmentConfirmationPage;
import com.smartTalent.test.ui.pages.HomePage;
import com.smartTalent.test.ui.pages.LoginPage;
import com.smartTalent.test.ui.pages.MakeAppointmentPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.text.ParseException;

public class MakeAppointmentTest {

    private WebDriver driver;

    @Before
    public void setDriver(){
        this.driver = new FirefoxDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
    }

    @Test
    public void getPage() throws ParseException {

        HomePage homePage = new HomePage(driver);
        homePage.clickMakeButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillUsernameField();
        loginPage.fillPasswordField();
        loginPage.clickLoginButton();

        MakeAppointmentPage makeAppointmentPage = new MakeAppointmentPage(driver);
        makeAppointmentPage.selectFacilityList();
        makeAppointmentPage.clickApplyCheckbox();
        makeAppointmentPage.selectMedicaidRadioButton();
        makeAppointmentPage.selectVisitDate();
        makeAppointmentPage.fillCommentField();
        makeAppointmentPage.clickBookAppointmentButton();

        AppointmentConfirmationPage appointmentConfirmationPage = new AppointmentConfirmationPage(driver);
        appointmentConfirmationPage.clickGoToHomepageButton();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
