package com.automation.tests;

import com.automation.common.WebDriverServices;
import com.automation.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by abc on 21-02-2018.
 */

public class FacebookTest {

    //TODO: Console Log Starting timestamp of suite
    //TODO: Console Log ending timestamp of suite Hint Before and After Class
    //TODO: Create Separate Smoke and Regression Suite Test Ng Xml
    @Test(groups = {"smoke"})
    public void getFriendCurrentStatus() {
        //Creating WebDriver instance
        WebDriver driver = WebDriverServices.getWebDriverInstance();
        driver.get("https://www.facebook.com");
        FacebookLoginPage facebookLoginPage = new FacebookLoginPage(driver);
        facebookLoginPage.login();
        FacebookSearchPage facebookSearchPage = new FacebookSearchPage(driver);
        facebookSearchPage.searchFriend();
        WebElement status = driver.findElement(By.xpath("//div[@class=\"_50f9 _50f3\"]"));
        //TODO: Assert Status
    }

    @Test(groups = {"smoke"})
    public void signUpForNewUser() {
        WebDriver driver = WebDriverServices.getWebDriverInstance();
        driver.get("https://www.facebook.com");

        FacebookSignUpPage facebookSignUpPage = new FacebookSignUpPage(driver);
        facebookSignUpPage.signUp();
        //TODO: Assert Profile Details
    }

    @Test(groups = {"smoke"})
    public void getMyPosts() {
        WebDriver driver = WebDriverServices.getWebDriverInstance();
        driver.get("https://www.facebook.com");

        FacebookLoginPage facebookLoginPage = new FacebookLoginPage(driver);
        facebookLoginPage.login();
        FacebookHomePage facebookHomePage = new FacebookHomePage(driver);
        facebookHomePage.getLatestPosts();
        //TODO: Assert Number of post more than 3
    }

    //TODO:  Iterate this test 3 times posting new status every time
    @Test(groups = {"smoke"})
    public void myNewPost() throws InterruptedException {
        WebDriver driver = WebDriverServices.getWebDriverInstance();
        driver.get("https://www.facebook.com");

        FacebookLoginPage facebookLoginPage = new FacebookLoginPage(driver);
        facebookLoginPage.login();
        FacebookHomePage facebookHomePage = new FacebookHomePage(driver);
        facebookHomePage.postNewStatus();
        //TODO:  Assert newly posted status
    }
}
