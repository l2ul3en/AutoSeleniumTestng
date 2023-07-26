package org.store.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.store.util.BasePage;

public class NewAddressPage extends BasePage {
    By input_name = By.id("firstname");
    By input_lastname = By.id("lastname");
    By input_city = By.id("city");
    By input_postal_code = By.id("zip");
    By input_telephone = By.id("telephone");
    By input_address = By.id("street_1");
    By select_country = By.id("country");
    By  btn_save= By.xpath("//button[@title='Save Address']");
    By verify_newaddress = By.xpath("//button[@title='Add New Address']");
    By head_message = By.tagName("h1");

    public NewAddressPage(WebDriver driver){
        super(driver);
    }
    public void fillOutFormAddress(String name, String lastname, String address, String city, String postalCode, String telephone ) throws InterruptedException{
        WebElement head_h1 = find(head_message);
        System.out.println(head_h1.getText());
        if (!head_h1.getText().contains("New")) {
            Thread.sleep(1000);
            click(verify_newaddress);
        }
        Select selectContry = new Select(find(select_country));
        selectContry.selectByValue("BO");
        find(input_name).clear();
        find(input_lastname).clear();
        type(input_name, name);
        type(input_lastname, lastname);
        type(input_telephone, telephone);
        type(input_address, address);
        type(input_postal_code, postalCode);
        type(input_city, city);
        submit(btn_save);
    }
    public Boolean verifyNewAddresses(){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(verify_newaddress));
        return element.isDisplayed();
    }
}
