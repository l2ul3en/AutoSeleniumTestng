package org.store.tests;

import org.store.util.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {
    @Test
    public void goToLogin(){
        homePage.goToSignIn();
        Assert.assertEquals(homePage.verifyHomePage(), "Customer Login");
        System.out.println(homePage.verifyHomePage());
    }
    @Test
    public void goToCreateNewAccount(){
        homePage.goToCreateAccount();
        Assert.assertEquals(homePage.verifyHomePage(), "Create New Customer Account");
        System.out.println(homePage.verifyHomePage());
    }
}
