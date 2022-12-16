package com.demo.tutorialsninja.testsuite;

import com.demo.tutorialsninja.pages.*;
import com.demo.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LaptopsAndNotebooksPageTest extends BaseTest {

    HomePage homePage;
    LaptopsAndNotebooksPage laptopsAndNotebooksPage;
    ShoppingCartPage shoppingCartPage;
    ProductPage productPage;
    CheckoutPage checkoutPage;
    // This method contains objects of Pages
    @BeforeMethod(alwaysRun = true)
    public void classObjects() {
        homePage = new HomePage();
        productPage = new ProductPage();
        shoppingCartPage = new ShoppingCartPage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        checkoutPage = new CheckoutPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        homePage.mousehooverOverLaptopsAndNotebooksMenu();
        //1.2 Click on “Show All Laptops & Notebooks”
        homePage.clickOnShowAllLaptopAndNotebooks();
        //1.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.sortByPriceHigToLow();
        //Verify the Product price will arrange in High to Low order.
        Assert.assertEquals(laptopsAndNotebooksPage.beforeSortTheProductsByPrice(), laptopsAndNotebooksPage.afterSortingTheProductsByPrice());
        System.out.println(laptopsAndNotebooksPage.beforeSortTheProductsByPrice());
        System.out.println(laptopsAndNotebooksPage.afterSortingTheProductsByPrice());
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //Select Currency
        homePage.chooseYourCurrency();
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        homePage.selectMenu("Laptops & NoteBooks");
        //2.2 Click on “Show All Laptops & Notebooks”
        homePage.selectMenu("Show All Laptops & Notebooks");
        //2.3 Select Sort By "Price (High > Low)"
        laptopsAndNotebooksPage.sortByPriceHigToLow();
        //2.4 Select Product “MacBook”
        laptopsAndNotebooksPage.selectAnyProductFromList("MacBook");
        //2.5 Verify the text “MacBook”
        Assert.assertEquals(productPage.getSelectedProductName(), "MacBook");
        //2.6 Click on ‘Add To Cart’ button
        productPage.clickAddToCartButton();
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        Assert.assertTrue(productPage.getSuccessMessageAfterAddingInCart().contains("Success: You have added MacBook to your shopping cart!"), "Success: You have added MacBook to your shopping cart!");
        //2.8 Click on link “shopping cart” display into success message
        productPage.clickOnShoppingCartLinkInSuccess();
        //2.9 Verify the text "Shopping Cart"
        Thread.sleep(1000);
        Assert.assertEquals(shoppingCartPage.getShoppingCartText(), "Shopping Cart  (0.00kg)", "Shopping cart message didn't displayed");
        //2.10 Verify the Product name "MacBook"
        Assert.assertEquals(shoppingCartPage.getProductName(), "MacBook", "Product name is wrong");
        //2.11 Change Quantity "2" and 2.12 Click on “Update” Tab
        shoppingCartPage.quantityUpdate("2");
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        Assert.assertTrue(shoppingCartPage.getMessageForShoppingCartUpdated().contains("uccess: You have modified your shopping cart!"), "Success: You have modified your shopping cart!");
        //2.14 Verify the Total £737.45
        Assert.assertEquals(shoppingCartPage.getTotalPrice(), "£737.45", "Total price is wrong");
        //2.15 Click on “Checkout” button
        shoppingCartPage.clickOnCheckOutBtn();
        //2.16 Verify the text “Checkout”
        Assert.assertEquals(checkoutPage.getToCheckOutPage(), "Checkout");
        //2.17 Verify the Text “New Customer”
        Assert.assertEquals(checkoutPage.getNewCustomer(), "New Customer");
        //2.18 Click on “Guest Checkout” radio button
        checkoutPage.clickOnGuestChckout();
        //2.19 Click on “Continue” tab
        checkoutPage.clickOnContinue();
        //2.20 Fill the mandatory fields
        checkoutPage.sendTextToFirstNameLine("Harshid");
        checkoutPage.sendTextToLastNameLine("Tester");
        checkoutPage.sendTextToEmailLine("harshid.tester1@gmail.com");
        checkoutPage.sendTextToTelephoneLine("07854213265");
        checkoutPage.sendTextToAddressLine("London Street");
        checkoutPage.sendTextToCityLine("London");
        checkoutPage.sendTextToPostCOdeField("En67 1JB");
        checkoutPage.selectCountry("United Kingdom");
        checkoutPage.selectRegion("Greater London");
        //2.21 Click on “Continue” Button
        Thread.sleep(1000);
        checkoutPage.clickOnContinueGuestBttn();
        //2.22 Add Comments About your order into text area
        checkoutPage.sendTextToCommentField("Please wrap the product");
        //2.23 Check the Terms & Conditions check box
        checkoutPage.clickOnTerms();
        //2.24 Click on “Continue” button
        checkoutPage.clickOnContinue();
        //2.25 Verify the message “Warning: Payment method required!”
        Assert.assertEquals(checkoutPage.getPaymentError(), "Warning: No Payment options are available. Please contact us for assistance!");
    }

}
