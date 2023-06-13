package com.smartTalent.test.ui.pages;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MakeAppointmentPage extends Page {
    private By facilityDropdownList = By.id("combo_facility");
    private By applyCheckbox = By.id("chk_hospotal_readmission");
    private By medicareRadioButton = By.id("radio_program_medicare");
    private By medicaidRadioButton = By.id("radio_program_medicaid");
    private By noneRadioButton = By.id("radio_program_none");
    private By visitDateCalendar = By.id("txt_visit_date");

    public MakeAppointmentPage(WebDriver driver) {
        super(driver);
    }
    public void selectFacilityList(){

        Select objSelect = new Select(driver.findElement(facilityDropdownList));
        objSelect.selectByVisibleText("Seoul CURA Healthcare Center");
    }

    public void clickApplyCheckbox(){
        driver.findElement(applyCheckbox).click();
    }

    public void selectMedicareRadioButton(){
        driver.findElement(medicareRadioButton).click();
    }

    public void selectMedicaidRadioButton(){
        driver.findElement(medicaidRadioButton).click();
    }

    public void selectNoneRadioButton(){
        driver.findElement(noneRadioButton).click();
    }

    public void selectVisitDate() throws ParseException {

        By nextArrow = By.cssSelector(".datepicker-days .next");
        By monthPicker = By.cssSelector(".datepicker-days .datepicker-switch");

        driver.findElement(visitDateCalendar).click();

        String d = "15/12/2023"; //dd/mm/yyyy
        String [] months = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};

        //Extract day, month, year. Converting date format into the date object here
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        //Date retrieving here after parsing through parse method
        Date mydate = df.parse(d);

        //Create a calendar instance
        java.util.Calendar cal = java.util.Calendar.getInstance();

        //Set day in calendar
        cal.setTime(mydate);

        //Getting day, month and year
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);

        System.out.println(day);
        System.out.println(months[month]);
        System.out.println(year);

        String visitDateMonth = months[month] + " " + year;
        System.out.println(visitDateMonth);

        //Next Arrow Clicker
        while (!driver.findElement(monthPicker).getText().equals(visitDateMonth)){
            driver.findElement(nextArrow).click();
        }

        //Select desired day
        //By dayPicker = By.xpath("//tbody/tr/td[contains(text(), '15')]");
        By dayPicker = By.xpath("//tbody/tr/td[contains(text(), '" + day + "')]");
        driver.findElement(dayPicker).click();


        // ----------------- SHORT IMPLEMENTATION -----------------------
        String mOnth = "December 2023";
        String dAy = "15";

        driver.findElement(visitDateCalendar).click();

        while (true){
            String text = driver.findElement(monthPicker).getText();
            if (text.equals(mOnth)){
                break;
            }
            else {
                driver.findElement(nextArrow).click();
            }
        }
        driver.findElement(By.xpath("//tbody/tr/td[contains(text(), " + dAy + ")]")).click();
    }
}
