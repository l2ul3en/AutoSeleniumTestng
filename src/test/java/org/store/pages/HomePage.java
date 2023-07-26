package org.store.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.store.util.BasePage;

public class HomePage extends BasePage {
    By link_register = By.linkText("Create an Account");
    By link_signin = By.linkText("Sign In");
    By input_search = By.id("search");
    By btn_link = By.xpath("//header[@class='page-header']/div/div/ul//li[2]/span/button");
    By myAccount_link = By.linkText("My Account");
    By address_link = By.linkText("Address Book");
    By btn_search = By.xpath("//button[@title='Search']");
    By head_h1 = By.tagName("h1");
    String URL = "https://magento.softwaretestingboard.com/";
    public HomePage(WebDriver driver){
        super(driver);
        loadUrl(URL);
    }

    public void goToSignIn(){click(link_signin);}
    public void goToCreateAccount(){click(link_register);}
    public void goToNewAddresses(){
        click(btn_link);
        click(myAccount_link);
        click(address_link);
    }
    public void goToSearch(String item){
        type(input_search, item);
        click(btn_search);
    }
    public String verifyHomePage(){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(head_h1));
        return element.getText();
    }
}
