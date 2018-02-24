package com.automation.tests;

import com.automation.pages.FacebookHomePage;
import com.automation.pages.FacebookLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by abc on 21-02-2018.
 */
public class FacebookTest
{
    public static void main(String [] args) throws InterruptedException {
        new FacebookTest().getFriendCurrentStatus();
    }

    public void getFriendCurrentStatus(){
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
        FacebookHomePage facebookHomePage = new FacebookHomePage(driver);
        facebookHomePage.searchFriend();
        WebElement status = driver.findElement(By.xpath("//div[@class=\"_50f9 _50f3\"]"));
    }

    public void getMyPosts(){
        ChromeOptions chrome_Profile = new ChromeOptions();
        /*chrome_Profile.addArguments("chrome.switches","--disable-extensions");
        chrome_Profile.addArguments("--disable-save-password");
        chrome_Profile.addArguments("disable-infobars");*/
        chrome_Profile.addArguments("--disable-notifications");
        File file = new File("chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver driver = new ChromeDriver(chrome_Profile);
        //WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("sonam.thale09@gmail.com");

        WebElement pass = driver.findElement(By.name("pass"));
        pass.sendKeys("Narendra@143");

        WebElement login = driver.findElement(By.xpath("//label[@id='loginbutton']"));
        login.click();
        String content = driver.findElement(By.tagName("body")).getText();
        //String content = driver.getPageSource();
        System.out.println(content);

        List<WebElement> list= driver.findElements(By.xpath("//div[@class=\"_1dwg _1w_m _q7o\"]"));
        System.out.println("Total selected rows are " + list.size());

//        List<WebElement> list = driver.findElements(By.xpath("//div[@class=\"_5pcr userContentWrapper\"]"));
//        System.out.println("Total selected rows are " + list.size());

        for (int i=1; i<=list.size(); i++)
        {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            System.out.println(i);
        }

        Iterator<WebElement> itr = list.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next().getText());
        }
    }
}
