package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FacebookSignUpPage {
    WebDriver driver;

    public FacebookSignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement firstNameTextBox(){
        return driver.findElement(By.xpath("//input[@name='firstname']"));
    }

    private WebElement lastNameTextBox(){
        return driver.findElement(By.name("lastname"));
    }

    private WebElement registeredEmailTextBox(){
        return driver.findElement(By.name("reg_email__"));
    }

    private WebElement confirmRegisteredEmailTextBox(){
        return driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
    }

    private WebElement registeredPasswordTextBox(){
        return driver.findElement(By.name("reg_passwd__"));
    }

    private WebElement birthDayDropDown(){
        return driver.findElement(By.name("birthday_day"));
    }

    private WebElement birthMonthDropDown(){
        return driver.findElement(By.name("birthday_month"));
    }

    private WebElement birthYearDropDown(){
        return driver.findElement(By.name("birthday_year"));
    }

    private WebElement selectGenderRadioButton(){
        return driver.findElement(By.id("u_0_b"));
    }

    private WebElement submitButton(){
        return driver.findElement(By.name("websubmit"));
    }

    public void signUp(){
        firstNameTextBox().sendKeys("Sonam");
        lastNameTextBox().sendKeys("Patil");
        registeredEmailTextBox().sendKeys("sonam.patil@gmail.com");
        confirmRegisteredEmailTextBox().sendKeys("sonam.patil@gmail.com");
        registeredPasswordTextBox().sendKeys("pass@123");
        Select dropDay= new Select(birthDayDropDown());
        dropDay.selectByVisibleText("5");

        Select dropMonth= new Select(birthMonthDropDown());
        dropMonth.selectByVisibleText("Dec");

        Select dropYear= new Select(birthYearDropDown());
        dropYear.selectByVisibleText("1990");

        selectGenderRadioButton().click();
        submitButton().click();
    }
}
