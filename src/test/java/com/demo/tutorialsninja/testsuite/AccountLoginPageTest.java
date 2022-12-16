package com.demo.tutorialsninja.testsuite;

import com.demo.tutorialsninja.pages.AccountLoginPage;
import com.demo.tutorialsninja.pages.HomePage;
import com.demo.tutorialsninja.pages.MyAccountPage;
import com.demo.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountLoginPageTest extends BaseTest {

    HomePage homePage;
    MyAccountPage myAccountPage;
    AccountLoginPage accountLoginPage;

    @BeforeMethod(alwaysRun = true)
    public void classObjects() {
        myAccountPage = new MyAccountPage();
        accountLoginPage = new AccountLoginPage();
        homePage = new HomePage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on My Account Link.
        myAccountPage.clickOnMyAccount();
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        myAccountPage.selectMyAccountOptions("Login");
        //2.3 Verify the text “Returning Customer”.
        Assert.assertEquals(accountLoginPage.getTextOfReturningCustomer(), "Returning Customer");

    }

    @Test(groups = "regression")
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        //4.1 Click on My Account Link.
        homePage.clickOnMyAccountTab();
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        homePage.selectMenu("Login");
        //4.3 Enter Email address
        accountLoginPage.sendTextToEmailAddressLine("Hritik_Roshan_123@gmail.com");
        //4.5 Enter Password
        accountLoginPage.sendTextToPasswordLine("RRR@123");
        //4.6 Click on Login button
        accountLoginPage.clickOnLoginButton();
        //4.7 Verify text “My Account”
        Assert.assertEquals(myAccountPage.getMyAccountText(), "My Account");
        //4.8 Click on My Account Link.
        myAccountPage.clickOnMyAccount();
        Thread.sleep(1000);
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        myAccountPage.selectMyAccountOptions("Logout");
        //4.10 Verify the text “Account Logout”
        Assert.assertEquals(myAccountPage.getAccountLogoutText(), "Account Logout");
        //4.11 Click on Continue button
        myAccountPage.clickContinueButtonForLogout();
    }

}
