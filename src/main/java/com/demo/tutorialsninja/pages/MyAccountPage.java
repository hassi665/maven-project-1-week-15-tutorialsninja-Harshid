package com.demo.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.demo.tutorialsninja.customlisteners.CustomListeners;
import com.demo.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class MyAccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "(//span[@class='hidden-xs hidden-sm hidden-md'])[3]")
    WebElement myAccountBtn;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Account Logout')]")
    WebElement accountLogoutText;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement accountCreatedText;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueBtn;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Register')]")
    WebElement userRegisterLink;

    @CacheLookup
    @FindBy(xpath = "/li[@class='dropdown open']/ul/li[2]")
    WebElement userLoginLink;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//li")
    List<WebElement> listOfAccountOptions;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountTxt;


    public void clickOnMyAccount() {
        Reporter.log("Click on My Account Link " + myAccountBtn.toString());
        clickOnElement(myAccountBtn);
        CustomListeners.test.log(Status.PASS, "Click on My Account Link");
    }

    public String getAccountLogoutText() {
        Reporter.log("Logout Text : " + accountLogoutText.toString());
        CustomListeners.test.log(Status.PASS, "Logout Text is " + accountLogoutText.getText());
        return getTextFromElement(accountLogoutText);
    }

    public String getAccountCreatedText() {
        Reporter.log("Created Text : " + accountCreatedText.toString());
        CustomListeners.test.log(Status.PASS, "Created Text :" + accountCreatedText.getText());
        return getTextFromElement(accountCreatedText);
    }

    public void clickContinueButtonForLogout() {
        Reporter.log("Click on Logout Button" + continueBtn.toString());
        clickOnElement(continueBtn);
        CustomListeners.test.log(Status.PASS, "Click on Logout Button");
    }

    public void clickOnRegestration() {
        Reporter.log("Click on User Registration" + userRegisterLink.toString());
        clickOnElement(userRegisterLink);
        CustomListeners.test.log(Status.PASS, "Click on User Registration");
    }

    public void clickOnLoginLink() {
        Reporter.log("Click on Login Link " + userLoginLink.toString());
        clickOnElement(userLoginLink);
        CustomListeners.test.log(Status.PASS, "Click on Login Link");
    }

    public void selectMyAccountOptions(String options) {
        Reporter.log("Select My Account Options " + listOfAccountOptions.toString());

        List<WebElement> accountOptionList = listOfAccountOptions;
        for (WebElement accountOptions : accountOptionList) {
            if (accountOptions.getText().equalsIgnoreCase(options)) {
                accountOptions.click();
                break;
            }
        }
        CustomListeners.test.log(Status.PASS, "My Account Option selected is " + options);
    }

    public String getMyAccountText() {
        Reporter.log("My Account Text " + myAccountTxt.toString());
        CustomListeners.test.log(Status.PASS, "My Account text is " + myAccountTxt.getText());
        return getTextFromElement(myAccountTxt);
    }

}
