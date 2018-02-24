package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FacebookLoginPage {
    WebDriver driver;

    public FacebookLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement emailTextBox(){
        return driver.findElement(By.name("email"));
    }

    private WebElement passwordTextBox(){
        return driver.findElement(By.name("pass"));
    }

    private WebElement loginButton(){
        return driver.findElement(By.xpath("//label[@id='loginbutton']"));
    }

    public void login(){
        emailTextBox().sendKeys("sonam.thale09@gmail.com");
        passwordTextBox().sendKeys("Narendra@143");
        loginButton().click();
    }
}
