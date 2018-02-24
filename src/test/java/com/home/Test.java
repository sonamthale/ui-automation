package com.home;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {
    // https://www.w3schools.com/xml/xpath_intro.asp
    // driver.findElement(By.id("twotabsearchtextbox"));
    //a[contains(text(),'Home & Living')]
    //header/descendant::a[text()='Men']
    //header/ancestor::a
    //a[text()='Men']/following-sibling::div
    //a/p
    //a[text()='Men']/parent::div
    //p[contains(text(),'USEFUL LINKS')]/parent::div/a[contains(@href,'/tac')]

    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.gecko.driver", "E:\\Automaton-Workspace\\ui-automation\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "E:\\Automaton-Workspace\\ui-automation\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.myntra.com/");
            WebElement searchInputBox = driver.findElement(By.xpath("//input[@placeholder='Search']"));
            searchInputBox.clear();
            searchInputBox.sendKeys("UCB");
            searchInputBox.sendKeys(Keys.ENTER);
            /*WebElement menLink = driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[text()='Men']"));
            Thread.sleep(2000);
            menLink.click();
            WebElement tShirt = driver.findElement(By.xpath("//li[@class='navi-base  navi-light']/a[text()=\"T-Shirts\"]"));
            Thread.sleep(2000);
            tShirt.click();
            WebElement productInfo = driver.findElement(By.xpath("//a[@href='tshirts/roadster/roadster-men-grey-melange-printed-round-neck-t-shirt/1997244/buy']/img[@class='product-thumb']"));
            Thread.sleep(2000);
            productInfo.click();
            String size = "S";
            WebElement selectSize = driver.findElement(By.xpath("//div[@id='sizeButtonsContainer']/descendant::p[contains(text(),'" + size + "')]"));
            Thread.sleep(2000);
            selectSize.click();
            WebElement addToBag = driver.findElement(By.xpath("//button[@class='pdp-add-to-bag pdp-button']"));
            Thread.sleep(2000);
            addToBag.click();
            WebElement goToBag = driver.findElement(By.xpath("//a[@class='pdp-goToCart pdp-add-to-bag pdp-button']"));
            Thread.sleep(2000);
            goToBag.click();
            WebElement placeOrder = driver.findElement(By.xpath("//button[@class=\"btn primary-btn btn-continue green-button clickable\"]"));
            Thread.sleep(2000);
            placeOrder.click();*/
        } finally {
            if (driver != null)
                driver.close();
        }

    }

}
