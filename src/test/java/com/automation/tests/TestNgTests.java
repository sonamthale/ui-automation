package com.automation.tests;

import com.automation.common.FluentWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class TestNgTests {

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        System.out.println("Before Method");
    } //4

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        System.out.println("Before Test");
    } //1

    @DataProvider(name = "provideLoginData")
    public Object[][] dataProvider() {
        return new Object[][]{{"Cedric", "pass"}, {"Anne", "pass"}};
    }

    @Test(groups = {"demo", "login"}, priority = 1, dataProvider = "provideLoginData")
    public void login(String userName, String password) {
        FluentWait.explicitWait(3);
        System.out.println("Login " + userName + " " + password);
    }

    @DataProvider(name = "provideLogin2Data")
    public Iterator<Object[]> dataProvider2() {
        ArrayList<Object[]> objects = new ArrayList<Object[]>();
        objects.add(new Object[]{new Login("Sanit", "password")});
        objects.add(new Object[]{new Login("Sonam", "password2")});
        return objects.iterator();
    }

    @Test(groups = {"demo", "login2"}, priority = 3, dataProvider = "provideLogin2Data")
    public void test2(Login login) {
        FluentWait.explicitWait(2);
        System.out.println("Test 2" + login.toString());
        //throw new Exception("fail the test case");
        Assert.assertFalse(
                login.getUserName().equalsIgnoreCase("Sanit"));
    }

    @Test(groups = "demo", priority = 0)
    public void test3() {
        FluentWait.explicitWait(2);
        System.out.println("Test 3");
    }

    @Test(groups = "demo", priority = 4)
    public void test4() {
        FluentWait.explicitWait(2);
        System.out.println("Test 4");
    }
}
