package com.demo.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.demo.tutorialsninja.customlisteners.CustomListeners;
import com.demo.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesktopPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Desktops')]")
    WebElement desktopsText;

    @CacheLookup
    @FindBy(xpath = "//h4/a")
    List<WebElement> productsList;

    @CacheLookup
    @FindBy(xpath = "//select[@id='input-sort']")
    WebElement sortBy;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'HP LP3065')]")
    WebElement hpLp2065;

    public String getDesktopPageText() {
        Reporter.log("The Desktop page Text  " + desktopsText.toString());
        CustomListeners.test.log(Status.PASS, "The Desktop page Text is " + desktopsText.getText());
        return getTextFromElement(desktopsText);
    }


    public ArrayList beforeSortingTheProducts() {
        List<WebElement> products = productsList;
        ArrayList<String> originalProductList = new ArrayList<>();
        for (WebElement list : products) {
            originalProductList.add(list.getText());
        }
        return originalProductList;
    }

    public ArrayList afterSortingTheProducts() {
        Collections.reverse(beforeSortingTheProducts());
        System.out.println(beforeSortingTheProducts());
        List<WebElement> products = productsList;
        ArrayList<String> afterSortList = new ArrayList<>();
        for (WebElement newList : products) {
            afterSortList.add(newList.getText());
        }
        return afterSortList;
    }

    public void sortByZtoA() {
        Reporter.log("Sort By Z to A " + sortBy.toString());
        selectByVisibleTextFromDropDown(sortBy, "Name (Z - A)");
        CustomListeners.test.log(Status.PASS, "Sorted By Z to A ");
    }

    public void sortByAtoZ() {
        Reporter.log("Sort By A to Z " + sortBy.toString());
        selectByVisibleTextFromDropDown(sortBy, "Name (A - Z)");
        CustomListeners.test.log(Status.PASS, "Sorted By A to Z ");
    }

    public void clickOnHpDesktop() {
        Reporter.log("Click on Product " + hpLp2065.toString());
        clickOnElement(hpLp2065);
        CustomListeners.test.log(Status.PASS, "Click on product ");
    }

}
