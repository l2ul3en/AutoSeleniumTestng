package org.store.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.store.pages.HomePage;
import org.store.pages.LoginPage;
import org.store.util.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest extends BaseTest {
    @Test (priority = 1, groups = "Functional")
    public void doLogin(){
        homePage.goToSignIn();
        loginPage.signIn("vil_lar_te.0@outlook.com", "P455_1234");
        Assert.assertFalse(loginPage.verifyLogin().contains("Customer Login"));
        System.out.println(loginPage.verifyLogin());
    }
    @Test (priority = 2)
    public void doLoginFail(){
        homePage.goToSignIn();
        loginPage.LoginInvalidUser();
        Assert.assertFalse(loginPage.verifyFailLogin().contains("sign-in was incorrect"));
        System.out.println(loginPage.verifyFailLogin());
    }
    @Test (priority = 3)
    public void doLoginFailPassword(){
        homePage.goToSignIn();
        loginPage.LoginInvalidPassword();
        Assert.assertFalse(loginPage.verifyFailLogin().contains("sign-in was incorrect"));
        System.out.println(loginPage.verifyFailLogin());
    }
}
