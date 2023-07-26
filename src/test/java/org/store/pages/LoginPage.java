package org.store.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.store.util.BasePage;

public class LoginPage extends BasePage {
    WebDriver driver;
    By input_email = By.id("email");
    By input_password = By.id("pass");
    By btn_sign_in = By.xpath("//button[@class='action login primary']");
    By verify_login = By.xpath("//span[@class='base']");
    By verify_invalidLogin = By.xpath("//div[@class='message-error error message']/div");
    public LoginPage(WebDriver driver){super(driver);}
    public LoginPage(WebDriver driver, int timeoutSec){
        this(driver);
        setTimeoutSec(timeoutSec);
    }
    public void signIn(String email, String password){
        type(input_email, email);
        type(input_password, password);
        click(btn_sign_in);
    }
    public void LoginInvalidUser() {
        type(input_email, "unknown@gmail.com");
        type(input_password, "P455_1234");
        click(btn_sign_in);
    }
    public void LoginInvalidPassword() {
        type(input_email, "vil_lar_te.0@outlook.com");
        type(input_password, "FakePassword143");
        click(btn_sign_in);
    }
    public String verifyLogin() {
        WebElement message = wait.until(ExpectedConditions.presenceOfElementLocated(verify_login));
        return message.getText();
    }
    public String verifyFailLogin(){
        WebElement message = wait.until(ExpectedConditions.presenceOfElementLocated(verify_invalidLogin));
        return message.getText();
    }
}
