package org.store.tests;

import org.store.util.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RegisterTest extends BaseTest {
    @Test (priority = 0, groups = "Functional")
    public void doCreateAccount(){
        homePage.goToCreateAccount();
        //registerPage.createAccount("Manfred","Villarte","vil_lar_te.0@outlook.com","P455_1234");
        registerPage.createAccountFake();
        Assert.assertEquals(registerPage.verifyRegisterMessage(),"Thank you for registering with Main Website Store.");
    }
}
