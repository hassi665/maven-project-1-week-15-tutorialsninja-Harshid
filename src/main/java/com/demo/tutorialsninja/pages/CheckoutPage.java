package com.demo.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.demo.tutorialsninja.customlisteners.CustomListeners;
import com.demo.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CheckoutPage extends Utility{

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Checkout')]")
    WebElement checkoutTxt;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'New Customer')]")
    WebElement newCustomerTxt;

    @CacheLookup
    @FindBy(xpath = "//div[@class='panel-group']/div[1]/div[2]/div/div/div[1]/div[2]/label/input")
    WebElement guestCheck;

    @CacheLookup
    @FindBy(xpath = "//input[@id='button-account']")
    WebElement continueBttn;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-firstname']")
    WebElement fName;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-lastname']")
    WebElement lName;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-email']")
    WebElement email;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-telephone']")
    WebElement phone;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-address-1']")
    WebElement address;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-city']")
    WebElement city;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-payment-postcode']")
    WebElement postcode;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-country']")
    WebElement country;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-payment-zone']")
    WebElement region;

    @CacheLookup
    @FindBy(css = "#button-guest")
    WebElement guestButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='panel-group']/div[3]/div[2]/div[1]/p[2]/textarea[1]")
    WebElement comment;

    @CacheLookup
    @FindBy(name = "agree")
    WebElement terms;
    @CacheLookup
    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement continueToComment;

    @CacheLookup
    @FindBy(xpath = "//div[@class='panel-group']/div[3]/div[2]/div/div[1]")
    WebElement paymentError;

    public String getToCheckOutPage() {
        Reporter.log("The Checkout Text is " + checkoutTxt.toString());
        CustomListeners.test.log(Status.PASS, "The checkout Text is " + checkoutTxt.getText());
        return getTextFromElement(checkoutTxt);
    }

    public String getNewCustomer() {
        Reporter.log("The New Customer Text is " + newCustomerTxt.toString());
        CustomListeners.test.log(Status.PASS, "The New Customer Text is " + newCustomerTxt.getText());
        return getTextFromElement(newCustomerTxt);
    }

    public void clickOnGuestChckout() {
        Reporter.log("Click on guest checkout  Button " + guestCheck.toString());
        clickOnElement(guestCheck);
        CustomListeners.test.log(Status.PASS, "Click on guest checkout Button");

    }

    public void clickOnContinue() {
        Reporter.log("Clicking on continue Button " + continueBttn.toString());
        clickOnElement(continueBttn);
        CustomListeners.test.log(Status.PASS, "Click on continue Button");

    }

    public void sendTextToFirstNameLine(String frstName) {
        Reporter.log("Enter user first name " + frstName + " to firstname field " + fName.toString());
        sendTextToElement(fName, frstName + getAlphaNumericString(2));
        CustomListeners.test.log(Status.PASS, "Entered  first name " + frstName);

    }

    public void sendTextToLastNameLine(String lstname) {
        Reporter.log("Enter user last name " + lstname + " to lastname field " + lName.toString());
        sendTextToElement(lName, lstname + getAlphaNumericString(2));
        CustomListeners.test.log(Status.PASS, "Entered last name " + lstname);

    }

    public void sendTextToEmailLine(String uEmail) {
        Reporter.log("Enter user email " + uEmail + " to email field " + email.toString());
        sendTextToElement(email, uEmail + getAlphaNumericString(2) + "@gmail.com");
        CustomListeners.test.log(Status.PASS, "Entered user email " + uEmail);

    }

    public void sendTextToTelephoneLine(String num) {
        Reporter.log("Enter telephone number " + num + " to Telephone Number field " + phone.toString());
        sendTextToElement(phone, num);
        CustomListeners.test.log(Status.PASS, "Entered telephone number " + num);

    }

    public void sendTextToAddressLine(String adrs) {
        Reporter.log("Enter Address " + adrs + " to Address field " + address.toString());
        sendTextToElement(address, adrs);
        CustomListeners.test.log(Status.PASS, "Entered Address " + adrs);

    }

    public void sendTextToCityLine(String cty) {
        Reporter.log("Enter city name " + cty + " to City name field " + city.toString());
        sendTextToElement(city, cty);
        CustomListeners.test.log(Status.PASS, "Entered city name " + cty);

    }

    public void sendTextToPostCOdeField(String pCode) {
        Reporter.log("Enter postcode " + pCode + " to username field " + postcode.toString());
        sendTextToElement(postcode, pCode + getAlphaNumericString(1));
        CustomListeners.test.log(Status.PASS, "Entered postcode " + pCode);

    }

    public void selectCountry(String Ctry) {
        Reporter.log("Select country " + Ctry + " to Country field " + country.toString());
        selectByVisibleTextFromDropDown(country, Ctry);
        CustomListeners.test.log(Status.PASS, "Selected country " + Ctry);

    }

    public void selectRegion(String Regn) {
        Reporter.log("Select region " + Regn + " to Region field " + region.toString());
        selectByVisibleTextFromDropDown(region, Regn);
        CustomListeners.test.log(Status.PASS, "Selected region " + Regn);

    }

    public void clickOnContinueGuestBttn() {
        Reporter.log("Clicking on continue Button in guest section " + guestButton.toString());
        clickOnElement(guestButton);
        CustomListeners.test.log(Status.PASS, "Clicking on continue Button in guest section ");

    }

    public void sendTextToCommentField(String cmnt) {
        Reporter.log("Input comments " + cmnt + " to Comment Line " +comment.toString());
        sendTextToElement(comment, cmnt);
        CustomListeners.test.log(Status.PASS, "Entered comments " + cmnt);

    }

    public void clickOnTerms() {
        Reporter.log("Click on term and conditions " + terms.toString());
        clickOnElement(terms);
        CustomListeners.test.log(Status.PASS, "Click on term and conditions");

    }

    public void clickOnContinueToCommentSection() {

        Reporter.log("Clicking on continue Button in comment section " + continueToComment.toString());
        clickOnElement(continueToComment);
        CustomListeners.test.log(Status.PASS, "Clicking on continue Button in comment section ");

    }

    public String getPaymentError() {
        Reporter.log("The payment error message is " + paymentError.toString());
        CustomListeners.test.log(Status.PASS, "The payment error message is " + paymentError.getText());
        return getTextFromElement(paymentError);
    }

}
