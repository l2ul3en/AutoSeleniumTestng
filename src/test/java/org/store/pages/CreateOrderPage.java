package org.store.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.store.util.BasePage;

public class CreateOrderPage extends BasePage {
    By size_m = By.id("option-label-size-143-item-168");
    By color_blue = By.id("option-label-color-93-item-50");
    By btn_addCart = By.id("product-addtocart-button");
    By lbl_cart = By.xpath("//div[@class='minicart-wrapper']/a");
    By btn_checkout = By.id("top-cart-btn-checkout");
    By verify_custom = By.xpath("//div[@class='opc-block-summary']/span");
    By btn_NextShippingAddress = By.xpath("//button[@data-role='opc-continue']");
    By btn_PlaceOrder = By.xpath("//button[@title='Place Order']");
    By verify_order = By.xpath("//div[@class='checkout-success']/p[1]");
    By item_searched = By.xpath("//div[@class='columns']/div[1]/div[2]/div[2]/ol/li[1]");
    By btn_search = By.xpath("//button[@title='Search']");
    public CreateOrderPage(WebDriver driver){
        super(driver);
    }
    public void makeOrder() throws InterruptedException {
        click(item_searched);
        click(size_m);
        click(color_blue);
        submit(btn_addCart);
        Thread.sleep(2000);
        click(lbl_cart);
        Thread.sleep(3000);
        isDisplayed(btn_checkout);
        click(btn_checkout);
        Thread.sleep(4000);
        isDisplayed(btn_NextShippingAddress);
        submit(btn_NextShippingAddress);
        Thread.sleep(5000);
        isDisplayed(btn_PlaceOrder);
        click(btn_PlaceOrder);
    }

    public String verifyOrder(){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(verify_order));
        return element.getText();
    }

}
