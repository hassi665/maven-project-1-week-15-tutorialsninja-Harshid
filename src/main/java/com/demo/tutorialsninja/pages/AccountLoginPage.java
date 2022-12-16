package com.demo.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.demo.tutorialsninja.customlisteners.CustomListeners;
import com.demo.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AccountLoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div/div[2]//h2")
    WebElement returningCustomerText;

    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div/div[1]//h2")
    WebElement newCustomerText;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailAddressField;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//form[contains(@action,'login')]//input[@type='submit']")
    WebElement loginBtn;

    public String getTextOfReturningCustomer() {
        Reporter.log("Returning Customer Text : " + returningCustomerText.toString());
        CustomListeners.test.log(Status.PASS, "eturning Customer Text :" + returningCustomerText.getText());
        return getTextFromElement(returningCustomerText);
    }

    public String getTextOfNewCustomer() {
        Reporter.log("New Customer Text : " + newCustomerText.toString());
        CustomListeners.test.log(Status.PASS, "New Customer Text : " + newCustomerText.getText());
        return getTextFromElement(newCustomerText);
    }

    public void sendTextToEmailAddressLine(String emailAdd) {
        sendTextToElement(emailAddressField, emailAdd);
    }

    public void sendTextToPasswordLine(String Password1) {
        sendTextToElement(passwordField, Password1);
    }

    public void clickOnLoginButton() {
        Reporter.log("Click on Login Button" + loginBtn.toString());
        clickOnElement(loginBtn);
        CustomListeners.test.log(Status.PASS, "Click on Login Button");

    }

}
