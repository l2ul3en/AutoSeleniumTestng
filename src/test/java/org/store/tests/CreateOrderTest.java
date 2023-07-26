package org.store.tests;

import org.store.util.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateOrderTest extends BaseTest {
    @Test (priority = 0, groups = "Functional")
    public void createNewOrder() throws InterruptedException{
        homePage.goToSignIn();
        //loginPage.signIn("vil_lar_te.0@outlook.com", "P455_1234");
        loginPage.signIn("hui.hessel@hotmail.com","F5WfkGF69Zl");
        homePage.goToSearch("Lando Gym Jacket");
        orderPage.makeOrder();
        Assert.assertTrue(orderPage.verifyOrder().contains("number"));
        System.out.println(orderPage.verifyOrder());
    }
}
