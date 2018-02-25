package com.automation.tests;

import com.automation.common.FluentWait;
import com.automation.common.WebDriverServices;
import com.automation.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by abc on 21-02-2018.
 */

public class FacebookTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(){
        System.out.println("Start Time" +
                new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z").format(new Date().getTime()));
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        System.out.println("End Time"+
                new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z").format(new Date().getTime()));
    }

    @Test(groups = {"Smoke", "regression", "debug"})
    public void getFriendCurrentStatus() {
        WebDriver driver = WebDriverServices.getWebDriverInstance();
        driver.get("https://www.facebook.com");
        FacebookLoginPage facebookLoginPage = new FacebookLoginPage(driver);
        facebookLoginPage.login("sonam.thale09@gmail.com", "Narendra@143");
        FacebookSearchPage facebookSearchPage = new FacebookSearchPage(driver);
        facebookSearchPage.searchFriend();
        WebElement status = driver.findElement(By.xpath("//div[@class=\"_50f9 _50f3\"]"));
        Assert.assertEquals(status.getText(),"Don’t cheat...\n" +
                "If you’re not happy just leave...");
    }

    @DataProvider(name = "provideLoginData")
    public Object[][] dataProvider1() {
        return new Object[][]{{"sonam.thale09@gmail.com", "Narendra@143"}};
    }

    @Test(groups = {"smoke", "regression"}, dataProvider = "provideLoginData")
    public void facebookLogin(String userName, String password) throws InterruptedException {
        WebDriver driver = WebDriverServices.getWebDriverInstance();
        driver.get("https://www.facebook.com");
        FacebookLoginPage facebookLoginPage = new FacebookLoginPage(driver);
        facebookLoginPage.login(userName, password);
        //TODO: Assert Home Button is displayed
    }

    @Test(groups = {"Smoke"}, priority = 1)
    public void signUpForNewUser() {
        WebDriver driver = WebDriverServices.getWebDriverInstance();
        driver.get("https://www.facebook.com");
        FacebookSignUpPage facebookSignUpPage = new FacebookSignUpPage(driver);
        facebookSignUpPage.signUp();
        //TODO: Assert Profile Details
    }

    @DataProvider(name = "provideStatusData")
    public Object[][] dataProvider() {
        return new Object[][]{{"good morning"}, {"good afternoon"}, {"good night"}};
    }

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

    @Test(groups = {"smoke", "regression", "notCompleted"})
    public void getMyPosts() {
        WebDriver driver = WebDriverServices.getWebDriverInstance();
        driver.get("https://www.facebook.com");
        FacebookLoginPage facebookLoginPage = new FacebookLoginPage(driver);
        facebookLoginPage.login("sonam.thale09@gmail.com", "Narendra@143");
        FacebookHomePage facebookHomePage = new FacebookHomePage(driver);
        facebookHomePage.getLatestPosts();
    }


}
