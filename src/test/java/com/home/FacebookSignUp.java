package com.home;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


/**
 * Created by abc on 21-02-2018.
 */
public class FacebookSignUp {
    public static void main(String [] args)throws InterruptedException {
        {
            WebDriver driver = new ChromeDriver();
            try {
                System.setProperty("webdriver.chrome.driver", "E:\\Automaton-Workspace\\ui-automation\\chromedriver.exe");
                driver.get("https://www.facebook.com/");
                driver.manage().window().maximize();

                WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
                Thread.sleep(2000);
                firstName.click();
                firstName.clear();
                firstName.sendKeys("Sonam");
                firstName.sendKeys(Keys.ENTER);

                WebElement lastName = driver.findElement(By.name("lastname"));
                Thread.sleep(2000);
                lastName.sendKeys("Thale");
                lastName.sendKeys(Keys.ENTER);

                WebElement regEmail = driver.findElement(By.name("reg_email__"));
                Thread.sleep(2000);
                regEmail.sendKeys("sonam.thale09@gmail.com");
                regEmail.sendKeys(Keys.ENTER);

                WebElement reenterEmail = driver.findElement(By.name("reg_email_confirmation__"));
                Thread.sleep(2000);
                reenterEmail.sendKeys("sonam.thale09@gmail.com");
                reenterEmail.sendKeys(Keys.ENTER);

                WebElement regPass = driver.findElement(By.name("reg_passwd__"));
                Thread.sleep(2000);
                regPass.sendKeys("werscouse");
                regPass.sendKeys(Keys.ENTER);

                WebElement birthDay = driver.findElement(By.name("birthday_day"));
                Select dropDay= new Select(birthDay);
                dropDay.selectByVisibleText("5");

                WebElement birthMonth = driver.findElement(By.name("birthday_month"));
                Select dropMonth= new Select(birthMonth);
                dropMonth.selectByVisibleText("Dec");

                WebElement birthYear = driver.findElement(By.name("birthday_year"));
                Select dropYear= new Select(birthYear);
                dropYear.selectByVisibleText("1990");

                WebElement selectGender = driver.findElement(By.id("u_0_b"));
                Thread.sleep(2000);
                selectGender.click();

                WebElement createAccount = driver.findElement(By.name("websubmit"));
                Thread.sleep(2000);
                createAccount.click();

            } finally {
                if (driver != null)
                    driver.close();
            }
        }

}

}
