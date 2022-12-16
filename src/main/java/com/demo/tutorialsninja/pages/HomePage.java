package com.demo.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.demo.tutorialsninja.customlisteners.CustomListeners;
import com.demo.tutorialsninja.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class HomePage extends Utility {


    @CacheLookup
    @FindBy(xpath = "//nav[@id='menu']//ul//li//a")
    List<WebElement> topMenu;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li[1]")
    WebElement desktopLink;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Show All Desktops')]")
    WebElement showAllDesktop;

    @CacheLookup
    @FindBy(linkText = "Laptops & Notebooks")
    WebElement laptopsAndNotebooksLink;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Show All Laptops & Notebooks')]")
    WebElement showAllLaptopsAndNotebooks;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Currency')]")
    WebElement currencyTab;

    @CacheLookup
    @FindBy(xpath = "//ul[@class = 'dropdown-menu']/li")
    List<WebElement> currencyList1;

    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement myAccountTab;

    @CacheLookup
    @FindBy(xpath = "//div[@id='top-links']//li[contains(@class,'open')]/ul/li")
    List<WebElement> myAccountOptions;

    public void selectMenu(String menu) {
        Reporter.log("The Top Menu Options are  " + topMenu.toString());
        List<WebElement> menuList = topMenu;
        try {
            for (WebElement list : menuList) {
                if (list.getText().equalsIgnoreCase(menu)) {
                    list.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            menuList = topMenu;
        }
        CustomListeners.test.log(Status.PASS, "The selected option is " + menu.toString());

    }

    public void clickOnShowAllDesktops() {
        Reporter.log("Click on Show All Desktops " + showAllDesktop.toString());
        clickOnElement(showAllDesktop);
        CustomListeners.test.log(Status.PASS, "Click on Show All Desktops ");
    }

    public void mouseHooverOverDesktopMenu() {

        Reporter.log("MouseHoover over Desktops Menu " + desktopLink.toString());
        mouseHoverToElement(desktopLink);
        CustomListeners.test.log(Status.PASS, "MouseHoover over Desktops Menu");
    }

    public void mousehooverOverLaptopsAndNotebooksMenu() {
        Reporter.log("Mousehoover Over Laptops & Notebooks Menu " + laptopsAndNotebooksLink.toString());
        clickOnElement(laptopsAndNotebooksLink);
        CustomListeners.test.log(Status.PASS, "Mousehoover Over Laptops & Notebooks Menu");
    }

    public void clickOnShowAllLaptopAndNotebooks() {
        Reporter.log("Click on Show All Laptops And NoteBooks" + showAllLaptopsAndNotebooks.toString());
        clickOnElement(showAllLaptopsAndNotebooks);
        CustomListeners.test.log(Status.PASS, "Click on Show All Laptops And NoteBooks");

    }
    public void chooseYourCurrency() {
        clickOnElement(currencyTab);
        List<WebElement> currencyList = currencyList1;
        for (WebElement currency : currencyList) {
            if (currency.getText().equalsIgnoreCase("£ Pound Sterling")) {
                currency.click();
                break;
            }
        }
        CustomListeners.test.log(Status.PASS, "List of currencies ");
    }

    public void clickOnMyAccountTab() {
        Reporter.log("Click on My Account Tab" + myAccountTab.toString());
        clickOnElement(myAccountTab);
        CustomListeners.test.log(Status.PASS, "Click on My Account Tab ");

    }

    public void selectAnyOptionFromMyAccountOptions(String options) {
        Reporter.log("Select Any Option From My Account Options" + myAccountOptions.toString());

        List<WebElement> accountOptionList = myAccountOptions;
        for (WebElement accountOptions : accountOptionList) {
            if (accountOptions.getText().equalsIgnoreCase(options)) {
                accountOptions.click();
                break;
            }
        }
        CustomListeners.test.log(Status.PASS, "Select Any Option From My Account Options" + options);
    }

    public void mouseHooverOverMainMenuBar(String mainMenu) {
        Reporter.log("The Top Menu Options are " + topMenu.toString());
        Actions actions = new Actions(driver);
        List<WebElement> menuList = topMenu;
        try {
            for (WebElement list : menuList) {
                if (list.getText().equalsIgnoreCase(mainMenu)) {
                    actions.moveToElement(list).build().perform();
                }
            }
        } catch (StaleElementReferenceException e) {
            menuList = topMenu;
        }
        CustomListeners.test.log(Status.PASS, "The selected option is " + mainMenu.toString());
    }
}
