package org.store.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.store.util.BasePage;

import java.util.Locale;

public class RegisterPage extends BasePage {
    By input_firstname = By.id("firstname");
    By input_lastname = By.id("lastname");
    By input_email = By.id("email_address");
    By input_password = By.id("password");
    By input_confirm_password = By.xpath("//fieldset[@class='fieldset create account']/div[@class='field confirmation required']/div/input");
    By btn_create = By.xpath("//button[@title='Create an Account']");
    By label_verifyRegister = By.xpath("//div[@data-ui-id='message-success']/div");

    public RegisterPage(WebDriver driver){
        super(driver);
    }
    public void createAccount(String name, String lastname, String email, String password){
        type(input_firstname, name);
        type(input_lastname, lastname);
        type(input_email, email);
        type(input_password, password);
        type(input_confirm_password, password);
        submit(btn_create);
    }
    public String verifyRegisterMessage() {
        WebElement message = wait.until(ExpectedConditions.presenceOfElementLocated(label_verifyRegister));
        return message.getText();
    }
    public void createAccountFake() {
        Faker faker = new Faker(new Locale("en-US"));
        String email = faker.internet().emailAddress();
        String password = faker.internet().password(8,12,true,false,true);

        type(input_firstname, faker.name().firstName());
        type(input_lastname, faker.name().lastName());
        type(input_email, email);
        type(input_password, password);
        type(input_confirm_password, password);
        submit(btn_create);
        System.out.println("Email is: " + email +" " + "Password is: "+ password);
    }
}
