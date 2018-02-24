package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FacebookSearchPage {
    WebDriver driver;

    public FacebookSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement searchTextBox(){
        return driver.findElement(By.xpath("//input[@class=\"_1frb\"]"));
    }

    private List<WebElement> friendList()
    {
        return driver.findElements(
                By.xpath("//span[text()='People' and @role='heading']/parent::div/following-sibling::div/descendant::a"));
    }

    public void searchFriend(){
        searchTextBox().sendKeys("Daivesh Patil");
        searchTextBox().sendKeys(Keys.ENTER);
        friendList().get(0).click();
    }
}
