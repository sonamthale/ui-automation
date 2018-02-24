package com.automation.tests;

import com.automation.common.WebDriverServices;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by abc on 21-02-2018.
 */
public class Myntra {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverServices.getWebDriverInstance();
        try {
            driver.get("https://www.myntra.com");
            WebElement women = driver.findElement(By.xpath("//div[@class='desktop-navContent']//a[@href='/shop/women']"));
            Thread.sleep(2000);
            women.click();
            WebElement biba = driver.findElement(By.xpath("//a[@href='/biba?f=discount%3A30.0']//img[@class='image-image undefined image-hand']"));
            Thread.sleep(2000);
            biba.click();
           /* WebElement filterKurta = driver.findElement(By.xpath("//input[@value='Kurtas']"));
            Thread.sleep(2000);
            filterKurta.click();*/
            WebElement selectKurta = driver.findElement(By.xpath("//a[@href='kurtas/biba/biba-women-blue-printed-high-low-anarkali-kurta/1787525/buy']//img"));
            Thread.sleep(2000);
            selectKurta.click();
            WebElement selectSize = driver.findElement(By.xpath("//button[@class='size-buttons-size-button size-buttons-size-button-default']//p[contains (text(),'M')]"));
            Thread.sleep(2000);
            selectSize.click();
            WebElement addToWishlist = driver.findElement(By.xpath("//button[@class='pdp-add-to-wishlist pdp-button pdp-add-to-wishlist pdp-button']"));
            Thread.sleep(2000);
            addToWishlist.click();
        } finally {
            if (driver != null)
                driver.close();
        }
    }
}
