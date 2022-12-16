package com.demo.tutorialsninja.pages;

import com.aventstack.extentreports.Status;
import com.demo.tutorialsninja.customlisteners.CustomListeners;
import com.demo.tutorialsninja.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ComponentsPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Components')]")
    WebElement components_Text;

    public String getTextOfComponentsPage() {
        Reporter.log("Components page text : " + components_Text.toString());
        CustomListeners.test.log(Status.PASS, "The Components page text is " + components_Text.getText());
        return getTextFromElement(components_Text);
    }

}
