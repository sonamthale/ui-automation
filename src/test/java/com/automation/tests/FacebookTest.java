package com.automation.tests;

import com.automation.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by abc on 21-02-2018.
 */
public class FacebookTest {
    public static void main(String[] args) throws InterruptedException {
        //new FacebookTest().getFriendCurrentStatus();
        //new FacebookTest().signUpForNewUser();
        //new FacebookTest().getMyPosts();
        new FacebookTest().myNewPost();
    }

    public void getFriendCurrentStatus() {
        //Creating WebDriver instance
        ChromeOptions chrome_Profile = new ChromeOptions();
        chrome_Profile.addArguments("--disable-notifications");
        File file = new File("chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        WebDriver driver = new ChromeDriver(chrome_Profile);
        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Test
        FacebookLoginPage facebookLoginPage = new FacebookLoginPage(driver);
        facebookLoginPage.login();
        FacebookSearchPage facebookSearchPage = new FacebookSearchPage(driver);
        facebookSearchPage.searchFriend();
        WebElement status = driver.findElement(By.xpath("//div[@class=\"_50f9 _50f3\"]"));
    }

    public void signUpForNewUser() {
        ChromeOptions chrome_Profile = new ChromeOptions();
        chrome_Profile.addArguments("--disable-notifications");
        File file = new File("chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver(chrome_Profile);
        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        FacebookSignUpPage facebookSignUpPage = new FacebookSignUpPage(driver);
        facebookSignUpPage.signUp();
    }

    public void getMyPosts() {
        ChromeOptions chrome_Profile = new ChromeOptions();
        chrome_Profile.addArguments("--disable-notifications");
        File file = new File("chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver(chrome_Profile);
        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        FacebookLoginPage facebookLoginPage = new FacebookLoginPage(driver);
        facebookLoginPage.login();
        FacebookHomePage facebookHomePage = new FacebookHomePage(driver);
        facebookHomePage.getLatestPosts();
    }

    public void myNewPost() throws InterruptedException {
        ChromeOptions chrome_Profile = new ChromeOptions();
        chrome_Profile.addArguments("--disable-notifications");
        File file = new File("chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver(chrome_Profile);
        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        FacebookLoginPage facebookLoginPage = new FacebookLoginPage(driver);
        facebookLoginPage.login();
        FacebookHomePage facebookHomePage = new FacebookHomePage(driver);
        facebookHomePage.postNewStatus();
    }
}
