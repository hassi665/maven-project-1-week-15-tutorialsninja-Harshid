package com.demo.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.demo.tutorialsninja.customlisteners.CustomListeners;
import com.demo.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/h1")
    WebElement shoppingCartText;

    @CacheLookup
    @FindBy(xpath = "//div[@class='table-responsive']/table/tbody/tr/td[2]/a")
    WebElement productName;

    @CacheLookup
    @FindBy(xpath = "//div[@class='table-responsive']/table/tbody/tr/td[2]/small[1]")
    WebElement deliveryDate;

    @CacheLookup
    @FindBy(xpath = "//div[@class='table-responsive']/table/tbody/tr/td[3]")
    WebElement model;

    @CacheLookup
    @FindBy(xpath = "//div[@class='table-responsive']/table/tbody/tr/td[6]")
    WebElement total;

    @CacheLookup
    @FindBy(xpath = "//input[contains(@name, 'quantity')]")
    WebElement qtyField;

    @CacheLookup
    @FindBy(xpath = "//button[contains(@data-original-title, 'Update')]")
    WebElement qtyUpdateBtn;

    @CacheLookup
    @FindBy(xpath = "//div[@id='checkout-cart']/div[1]")
    WebElement successModifiedMessage;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    WebElement checkOutLink;

    public String getShoppingCartText() {
        Reporter.log("Shopping Cart Text : " + shoppingCartText.toString());
        CustomListeners.test.log(Status.PASS, "Shopping Cart Text : " + shoppingCartText.getText());
        return getTextFromElement(shoppingCartText);
    }

    public String getProductName() {
        Reporter.log("Product name in Cart : " + productName.toString());
        CustomListeners.test.log(Status.PASS, "Product name in Cart : " + productName.getText());
        return getTextFromElement(productName);
    }

    //This method will get delivery date
    public String getDeliveryDate() {
        Reporter.log("Delivery Date : " + deliveryDate.toString());
        CustomListeners.test.log(Status.PASS, "Delivery Date : " + deliveryDate.getText());
        return getTextFromElement(deliveryDate);
    }

    public String getModelName() {
        Reporter.log("Model Name : " + model.toString());
        CustomListeners.test.log(Status.PASS, "Model Name : " + model.getText());
        return getTextFromElement(model);
    }

    public String getTotalPrice() {
        Reporter.log("Total Price : " + total.toString());
        CustomListeners.test.log(Status.PASS, "Total Price : " + total.getText());
        return getTextFromElement(total);
    }

    public void quantityUpdate(String quantity) {
        Reporter.log("Current Quantity : " + qtyField.toString());
        clearTextFromField(qtyField);
        sendTextToElement(qtyField, quantity);
        clickOnElement(qtyUpdateBtn);
        CustomListeners.test.log(Status.PASS, "Current Quantity : " + quantity);

    }

    public String getMessageForShoppingCartUpdated() {
        Reporter.log("Shopping Cart Updated : " +successModifiedMessage.toString());
        CustomListeners.test.log(Status.PASS, "Shopping Cart Updated : " + successModifiedMessage.getText());
        return getTextFromElement(successModifiedMessage);
    }

    public void clickOnCheckOutBtn() {
        Reporter.log("Click on checkout  Button " + checkOutLink.toString());
        clickOnElement(checkOutLink);
        CustomListeners.test.log(Status.PASS, "Click on checkout Button");
    }
}
