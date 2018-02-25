package com.automation.tests;

import com.automation.common.FluentWait;
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

    long startTime = System.currentTimeMillis();

    long endTime = System.currentTimeMillis();

    long executionTime = endTime - startTime;

    //TODO: Console Log Starting timestamp of suite
    //TODO: Console Log ending timestamp of suite Hint Before and After Class
    //TODO: Create Separate Smoke and Regression Suite Test Ng Xml
    @Test(groups = {"Smoke", "Regression"})
    public void getFriendCurrentStatus() {
        System.out.println(java.util.concurrent.TimeUnit.MILLISECONDS.toMinutes(executionTime));

        WebDriver driver = WebDriverServices.getWebDriverInstance();
        driver.get("https://www.facebook.com");
        FacebookLoginPage facebookLoginPage = new FacebookLoginPage(driver);
        facebookLoginPage.login("","");
        FacebookSearchPage facebookSearchPage = new FacebookSearchPage(driver);
        facebookSearchPage.searchFriend();
        WebElement status = driver.findElement(By.xpath("//div[@class=\"_50f9 _50f3\"]"));
        //TODO: Assert Status
    }

    @Test(groups = {"Smoke"}, priority = 1)
    public void signUpForNewUser() {
        WebDriver driver = WebDriverServices.getWebDriverInstance();
        driver.get("https://www.facebook.com");

        FacebookSignUpPage facebookSignUpPage = new FacebookSignUpPage(driver);
        facebookSignUpPage.signUp();
        //TODO: Assert Profile Details
    }

    @Test(groups = {"smoke", "regression"})
    public void getMyPosts() {
        WebDriver driver = WebDriverServices.getWebDriverInstance();
        driver.get("https://www.facebook.com");

        FacebookLoginPage facebookLoginPage = new FacebookLoginPage(driver);
        facebookLoginPage.login("sonam.thale09@gmail.com", "Narendra@143");
        FacebookHomePage facebookHomePage = new FacebookHomePage(driver);
        facebookHomePage.getLatestPosts();
        //TODO: Assert Number of post more than 3
    }

    @DataProvider(name = "provideStatusData")
    public Object[][] dataProvider() {
        return new Object[][]{{"good morning"}, {"good afternoon"}, {"good night"}};
    }

    //TODO:  Iterate this test 3 times posting new status every time
    @Test(groups = {"smoke", "regression"}, dataProvider = "provideStatusData")
    public void myNewPost(String status) throws InterruptedException {
        WebDriver driver = WebDriverServices.getWebDriverInstance();
        driver.get("https://www.facebook.com");

        FacebookLoginPage facebookLoginPage = new FacebookLoginPage(driver);
        facebookLoginPage.login("sonam.thale09@gmail.com", "Narendra@143");
        FacebookHomePage facebookHomePage = new FacebookHomePage(driver);
        facebookHomePage.postNewStatus(status);
        //TODO:  Assert newly posted status
    }

    @DataProvider(name = "provideLoginData")
    public Object[][] dataProvider1() {
        return new Object[][]{{"sonam.thale09@gmail.com", "Narendra@143"}, {"UserName1", "Password1"}};
    }

    @Test(groups = {"smoke", "regression"}, dataProvider = "provideLoginData")
    public void facebookLogin(String userName, String password) throws InterruptedException {
        WebDriver driver = WebDriverServices.getWebDriverInstance();
        driver.get("https://www.facebook.com");

        FacebookLoginPage facebookLoginPage = new FacebookLoginPage(driver);
        facebookLoginPage.login(userName, password);
    }
}
