package com.demo.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.demo.tutorialsninja.customlisteners.CustomListeners;
import com.demo.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class RegistrationPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Register Account')]")
    WebElement registerText;
    @CacheLookup
    @FindBy(name = "firstname")
    WebElement firstName;
    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastName;
    @CacheLookup
    @FindBy(id = "input-email")
    WebElement email;
    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephoneNumber;
    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;
    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement confirm_Password;
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/form/fieldset[3]/div/div//label[1]/input")
    WebElement subscribe_Y;
    @CacheLookup
    @FindBy(xpath = "//div[@id='content']/form/fieldset[3]/div/div//label[2]/input")
    WebElement subscribe_N;
    @CacheLookup
    @FindBy(name = "agree")
    WebElement privacy;
    @CacheLookup
    @FindBy(xpath = "//input[@class='btn btn-primary']")
    WebElement continue1;

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement accountCreationText;
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Continue')]")
    WebElement continueFurtherAccountCreation;

    public String getRegisterAccountText() {
        Reporter.log("Register Account Text : " + registerText.toString());
        CustomListeners.test.log(Status.PASS, "Register Account Text :  " + registerText.getText());
        return getTextFromElement(registerText);
    }

    public void sendTextFirstIntoNameField(String frstName) {
        Reporter.log("Input User's first name " + frstName + " into the first Name field " + firstName.toString());
        sendTextToElement(firstName, frstName);
        CustomListeners.test.log(Status.PASS, "Input User's first name " + frstName);

    }

    public void sendTextIntoLastNameField(String lstName) {
        Reporter.log("Enter user last name " + lstName + " to Last Name field " + lastName.toString());
        sendTextToElement(lastName, lstName);
        CustomListeners.test.log(Status.PASS, "Entered  last name " + lstName);

    }

    public void sendTextIntoEmailField(String email1) {
        Reporter.log("Enter user email " + email1 + " to Email field " + email.toString());
        sendTextToElement(email, email1 + getAlphaNumericString(2) + "@gmail.com");
        CustomListeners.test.log(Status.PASS, "Entered email is " + email1);

    }

    public void sendTexIntoTelephoneNumberField(String number) {
        Reporter.log("Telephone number : " + number + " in Telephone Number Line " + telephoneNumber.toString());
        sendTextToElement(telephoneNumber, number);
        CustomListeners.test.log(Status.PASS, "Telephone Number : " + number);

    }

    public void enteredPasswordIntoPasswordField(String password1) {
        Reporter.log("Enter password " + password1 + " in Password Line " + password.toString());
        sendTextToElement(password, password1);
        CustomListeners.test.log(Status.PASS, "Entered  password is " + password1);

    }

    public void enteredConfirmPasswordIntoPasswordField(String confrmpassword1) {
        Reporter.log("Enter password again " + confrmpassword1 + " to Confirm Password field " + confirm_Password.toString());
        sendTextToElement(confirm_Password, confrmpassword1);
        CustomListeners.test.log(Status.PASS, "Entered  confirm Password is " + confrmpassword1);

    }

    public void selectSubscribtionButtons(String subcrb) {
        Reporter.log("Select Subscribe Option" + password.toString());
        if (subcrb.equalsIgnoreCase("Yes")) {
            clickOnElement(subscribe_Y);
        } else if (subcrb.equalsIgnoreCase("No")) {
            clickOnElement(subscribe_N);
        }
        CustomListeners.test.log(Status.PASS, "Selected Subscribe Option is " + subcrb);
    }

    public void clickOnPrivacyButton() {
        Reporter.log("Clicking on continue Button in guest section " + privacy.toString());
        clickOnElement(privacy);
        CustomListeners.test.log(Status.PASS, "Clicking on Privacy Button in Registration section ");
    }

    public void clickOnContinueButton() {
        Reporter.log("Clicking on continue Button in guest section " + continue1.toString());
        clickOnElement(continue1);
        CustomListeners.test.log(Status.PASS, "Clicking on Continue Button in Registration section  ");

    }

    public String toGetAccountCreatedText() {
        Reporter.log("Account Created Text : " + accountCreationText.toString());
        CustomListeners.test.log(Status.PASS, "Account Created Text :" + accountCreationText.getText());
        return getTextFromElement(accountCreationText);
    }

    public void clickOnContinueButtonAfterAccountCreated() {
        Reporter.log("Clicking on continue Button " + continueFurtherAccountCreation.toString());
        clickOnElement(continueFurtherAccountCreation);
        CustomListeners.test.log(Status.PASS, "Clicking on continue Button After Account created");

    }
}
