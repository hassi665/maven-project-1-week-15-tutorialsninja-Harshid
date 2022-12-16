package com.demo.tutorialsninja.testsuite;

import com.demo.tutorialsninja.pages.DesktopPage;
import com.demo.tutorialsninja.pages.HomePage;
import com.demo.tutorialsninja.pages.ProductPage;
import com.demo.tutorialsninja.pages.ShoppingCartPage;
import com.demo.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DesktopsPageTest extends BaseTest {

    HomePage homePage;
    DesktopPage desktopsPage;
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod(alwaysRun = true)
    public void classObjects() {
        homePage = new HomePage();
        desktopsPage = new DesktopPage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductsAreArrangedInAlphabeticalOrder() {
        //2.1 Hover over Desktop Link
        homePage.mouseHooverOverDesktopMenu();
        //2.2 Click on Show all Desktops link
        homePage.clickOnShowAllDesktops();
        //2.3 Sort by Z to A and Verify
        desktopsPage.sortByZtoA();
        Assert.assertEquals(desktopsPage.beforeSortingTheProducts(), desktopsPage.afterSortingTheProducts());
    }

    @Test(groups = "regression")
    public void verifyProductAreAddedToShoppingCartSuccessFully() throws InterruptedException {
        // select Currency
        homePage.chooseYourCurrency();
        //2.1 Hover over Desktop Link
        homePage.mouseHooverOverDesktopMenu();
        //2.2 Click on Show all Desktops link
        homePage.clickOnShowAllDesktops();
        //2.3 Sort by A to Z and Verify
        desktopsPage.sortByAtoZ();
        Assert.assertEquals(desktopsPage.beforeSortingTheProducts(), desktopsPage.afterSortingTheProducts());
        //2.4CLick on Product
        desktopsPage.clickOnHpDesktop();
        //2.5 Verify the product name
        Assert.assertEquals(productPage.getSelectedProductName(), "HP LP3065", "Product is not displayed on Page");
        //2.6 select delivery date
        productPage.selectDateAndYearOnCalendar("November", "2022");
        productPage.selectDateOnCalendar("30");
        //2.7 select quantity
        productPage.enterQuantityRequired("1");
        //2.8 click on add to cart button
        Thread.sleep(1000);
        productPage.clickAddToCartButton();
        Thread.sleep(1000);
        //2.9 Verify
        Assert.assertTrue(productPage.getSuccessMessageAfterAddingInCart().contains("Success: You have added HP LP3065 to your shopping cart!"), "Success: You have added HP LP3065 to your shopping cart!");
        //2.10 Click on shopping cart button
        productPage.clickOnShoppingCartLinkInSuccess();
        //2.11 Verify
        Assert.assertEquals(shoppingCartPage.getShoppingCartText(), "Shopping Cart  (1.00kg)", "Shopping cart message didn't displayed");
        //2.12 Verify Product name
        Assert.assertEquals(shoppingCartPage.getProductName(), "HP LP3065", "Product name is wrong");
        //2.13 Verify the Delivery Date "2022-11-30"
        Assert.assertEquals(shoppingCartPage.getDeliveryDate(), "Delivery Date: 2022-11-30", "Delivery date is wrong");
        //2.14 Verify model
        Assert.assertEquals(shoppingCartPage.getModelName(), "Product 21", "Product model is wrong");
        //2.15 verify total price
        Assert.assertEquals(shoppingCartPage.getTotalPrice(), "£74.73", "Total price is wrong");

    }

}
