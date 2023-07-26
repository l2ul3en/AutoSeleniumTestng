package org.store.tests;

import org.store.util.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewAddressTest extends BaseTest {
    @Test (priority = 0, groups = "Functional")
    public void createNewAddresses() throws InterruptedException{
        homePage.goToSignIn();
        loginPage.signIn("casimira.gutmann@yahoo.com","9HaMV1wqW0l");
        Thread.sleep(2000);
        homePage.goToNewAddresses();
        newAddressPage.fillOutFormAddress("Armando","Paredes","B/ Catalunia C/5","Santa Cruz de la Sierra","0088","2342235");
        Assert.assertTrue(newAddressPage.verifyNewAddresses());
        System.out.println(newAddressPage.verifyNewAddresses());
    }
}
