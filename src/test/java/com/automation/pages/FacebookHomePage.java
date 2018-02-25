package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;

public class FacebookHomePage {
    WebDriver driver;

    public FacebookHomePage(WebDriver driver) {
        this.driver = driver;
    }

    private List<WebElement> latestPosts()
    {
        return driver.findElements(
                By.xpath("//div[@class='_1dwg _1w_m _q7o']"));
    }

    private WebElement postGrid() {
        return driver.findElement(By.xpath("//div[@aria-label=\"Create a post\"]"));
    }

    private WebElement newPost() {
        return driver.findElement(
                By.xpath("//div[@data-testid='status-attachment-mentions-input']"));
    }

    private WebElement postButton() {
        return driver.findElement(
                By.xpath("//span[text()='Post']/ancestor::button[@type='submit']"));
    }

    public void postNewStatus(String status) throws InterruptedException {
        Thread.sleep(2000);
        postGrid().click();
        Thread.sleep(2000);
        newPost().sendKeys(status);
        postButton().sendKeys(Keys.ENTER);
    }

    public void getLatestPosts(){
       List<WebElement> latestPosts = latestPosts();
        for (WebElement webElement : latestPosts) {
            webElement.getText();
        }
    }
}
