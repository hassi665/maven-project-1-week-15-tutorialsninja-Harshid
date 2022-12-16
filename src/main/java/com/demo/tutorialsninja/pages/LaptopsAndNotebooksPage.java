package com.demo.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.demo.tutorialsninja.customlisteners.CustomListeners;
import com.demo.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaptopsAndNotebooksPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Laptops & Notebooks')]")
    WebElement laptopsAndNotebooksText;

    @CacheLookup
    @FindBy(xpath = "//p[@class ='price']")
    List<WebElement> productsPrices;

    @CacheLookup
    @FindBy(id = "input-sort")
    WebElement sortBy;


    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/div[4]//div/child::h4/a")
    List<WebElement> productsList;


    public String getLaptopsAndNotebookText() {
        Reporter.log("Laptops And Desktops Text : " + laptopsAndNotebooksText.toString());
        CustomListeners.test.log(Status.PASS, "Laptops And Desktops Text : " + laptopsAndNotebooksText.getText());
        return getTextFromElement(laptopsAndNotebooksText);
    }


    public List<Double> beforeSortTheProductsByPrice() {
        List<WebElement> products = productsPrices;
        List<Double> originalProductPrice = new ArrayList<>();
        for (WebElement list : products) {
            String arr[] = list.getText().split("Ex Tax:");
            originalProductPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        return originalProductPrice;
    }

    public void sortByPriceHigToLow() {
        Reporter.log("Products are shorted in Price From High to Low" + sortBy.toString());
        selectByVisibleTextFromDropDown(sortBy, "Price (High > Low)");
        CustomListeners.test.log(Status.PASS, "Products are shorted  in Price From High to Low");
    }

    public ArrayList<Double> afterSortingTheProductsByPrice() {
        Collections.sort(beforeSortTheProductsByPrice(), Collections.reverseOrder());
        List<WebElement> products = productsPrices;
        ArrayList<Double> afterSortByPrice = new ArrayList<>();
        for (WebElement newPriceList : products) {
            String[] arr = newPriceList.getText().split("Ex Tax:");
            afterSortByPrice.add(Double.valueOf(arr[0].substring(1).replaceAll(",", "")));
        }
        return afterSortByPrice;
    }

    public void selectAnyProductFromList(String mainMenu) {

        Reporter.log("Products : " + productsList.toString());

        List<WebElement> allProducts = productsList;
        try {
            for (WebElement products : allProducts) {
                if (products.getText().equalsIgnoreCase(mainMenu)) {
                    products.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            allProducts = productsList;
        }
        CustomListeners.test.log(Status.PASS, "Choosen Product" + mainMenu);
    }

}
