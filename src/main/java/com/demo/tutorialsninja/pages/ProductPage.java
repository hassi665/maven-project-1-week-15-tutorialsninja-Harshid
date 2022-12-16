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

public class ProductPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "(//div[@id = 'content']//h1")
    WebElement productText;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'input-group date']//button")
    WebElement calendarButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")
    WebElement monthAndYearText;


    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//th[@class='next']")
    WebElement nextButton;


    @CacheLookup
    @FindBy(xpath = "//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']")
    List<WebElement> dateList;

    @CacheLookup
    @FindBy(xpath = "//input[@id='input-quantity']")
    WebElement qtyField;

    @CacheLookup
    @FindBy(id = "button-cart")
    WebElement addToCartButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement successMessage;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'shopping cart')]")
    WebElement shoppingCartLinkInSuccessMessage;

    public String getSelectedProductName() {
        Reporter.log("The Product Name is " + productText.toString());
        CustomListeners.test.log(Status.PASS, "The Product Name is " + productText.getText());
        return getTextFromElement(productText);
    }


    //This method will select date and yea
    public void selectDateAndYearOnCalendar(String month, String year) {
        Reporter.log("Clicking on Calender Button " + calendarButton.toString());
        clickOnElement(calendarButton);
        while (true) {
            String monthYear = getTextFromElement(monthAndYearText);
            String arr[] = monthYear.split(" ");
            String mon = arr[0];
            String yr = arr[1];

            if (mon.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(nextButton);
            }

        }
        CustomListeners.test.log(Status.PASS, "Click on Calender Button");

    }

    public void selectDateOnCalendar(String date) {

        List<WebElement> allDates = dateList;
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;

            }
        }
        CustomListeners.test.log(Status.PASS, "Selected Date is " + date);
    }

    public void enterQuantityRequired(String quantity) {
        Reporter.log("Clear text " + qtyField.toString());
        clearTextFromField(qtyField);
        Reporter.log("Send quantity " + quantity + " to firstname field " + qtyField.toString());
        sendTextToElement(qtyField, quantity);
        CustomListeners.test.log(Status.PASS, "Quantity is " + quantity);
    }

    public void clickAddToCartButton() {
        Reporter.log("Click on Add To Cart Button " + addToCartButton.toString());
        clickOnElement(addToCartButton);
        CustomListeners.test.log(Status.PASS, "Click on Add To Cart Button");

    }

    public String getSuccessMessageAfterAddingInCart() {
        Reporter.log("Success Message : " + successMessage.toString());
        CustomListeners.test.log(Status.PASS, "Success Message : " + successMessage.getText());
        return getTextFromElement(successMessage);
    }

    public void clickOnShoppingCartLinkInSuccess() {
        Reporter.log("Clicking on Shopping Cart Button " + shoppingCartLinkInSuccessMessage.toString());
        clickOnElement(shoppingCartLinkInSuccessMessage);
        CustomListeners.test.log(Status.PASS, "Clicking on Shopping Cart Button");
    }
}
