package com.demo.tutorialsninja.testsuite;

import com.demo.tutorialsninja.pages.AccountLoginPage;
import com.demo.tutorialsninja.pages.HomePage;
import com.demo.tutorialsninja.pages.MyAccountPage;
import com.demo.tutorialsninja.pages.RegistrationPage;
import com.demo.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AccountRegisterPageTest extends BaseTest {

    HomePage homePage;
    MyAccountPage myAccountPage;
    AccountLoginPage accountLoginPage;
    RegistrationPage registrationPage;

    @BeforeMethod(alwaysRun = true)
    public void classObjects() {
        myAccountPage = new MyAccountPage();
        accountLoginPage = new AccountLoginPage();
        homePage = new HomePage();
        registrationPage = new RegistrationPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        //1.1 Click on My Account Link.
        Thread.sleep(800);
        myAccountPage.clickOnMyAccount();
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        myAccountPage.selectMyAccountOptions("Register");
        //1.3 Verify the text “Register Account”.
        Assert.assertEquals(registrationPage.getRegisterAccountText(), "Register Account");
    }
    @Test(groups = "regression")
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        //3.1 Click on My Account Link.
        Thread.sleep(800);
        homePage.clickOnMyAccountTab();
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        homePage.selectMenu("Register");
        //3.3 Enter First Name
        registrationPage.sendTextFirstIntoNameField("Rahul");
        //3.4 Enter Last Name
        registrationPage.sendTextIntoLastNameField("Gandhi");
        //3.5 Enter Email
        registrationPage.sendTextIntoEmailField("RahulGandhi123@gmail.com");
        //3.6 Enter Telephone
        registrationPage.sendTexIntoTelephoneNumberField("07894563210");
        //3.7 Enter Password
        registrationPage.enteredConfirmPasswordIntoPasswordField("Rahul@123456");
        //3.8 Enter Password Confirm
        registrationPage.enteredConfirmPasswordIntoPasswordField("Rahul@123456");
        //3.9 Select Subscribe Yes radio button
        registrationPage.selectSubscribtionButtons("Yes");
        //3.10 Click on Privacy Policy check box
        registrationPage.clickOnPrivacyButton();
        //3.11 Click on Continue button
        registrationPage.clickOnContinueButton();
        //3.12 Verify the message “Your Account Has Been Created!”
        Assert.assertEquals(registrationPage.toGetAccountCreatedText(), "Your Account Has Been Created!");
        //3.13 Click on Continue button
        registrationPage.clickOnContinueButtonAfterAccountCreated();
        //3.14 Click on My Account Link.
        myAccountPage.clickOnMyAccount();
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        myAccountPage.selectMyAccountOptions("Logout");
        //3.16 Verify the text “Account Logout”
        Assert.assertEquals(myAccountPage.getAccountLogoutText(), "Account Logout");
        //3.17 Click on Continue button
        myAccountPage.clickContinueButtonForLogout();
    }
}
