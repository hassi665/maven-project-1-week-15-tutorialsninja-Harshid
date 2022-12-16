package com.demo.tutorialsninja.testsuite;

import com.demo.tutorialsninja.pages.ComponentsPage;
import com.demo.tutorialsninja.pages.DesktopPage;
import com.demo.tutorialsninja.pages.HomePage;
import com.demo.tutorialsninja.pages.LaptopsAndNotebooksPage;
import com.demo.tutorialsninja.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TopMenuTest extends BaseTest {

    HomePage homePage;

    DesktopPage desktopsPage;

    LaptopsAndNotebooksPage laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();

    ComponentsPage componentsPage;

    @BeforeMethod(alwaysRun = true)
    public void classObjects() {
        homePage = new HomePage();
        laptopsAndNotebooksPage = new LaptopsAndNotebooksPage();
        desktopsPage = new DesktopPage();
        componentsPage = new ComponentsPage();
    }


    //Test 1
    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        homePage.mouseHooverOverDesktopMenu();
        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
       homePage.selectMenu("Show All Desktops");
        //1.3 Verify the text ‘Desktops’
        Assert.assertEquals(desktopsPage.getDesktopPageText(), "Desktops", "Desktops page got error");

    }

    //Test2
    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        homePage.mousehooverOverLaptopsAndNotebooksMenu();
        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        homePage.selectMenu("Show All Laptops & Notebooks");
        //2.3 Verify the text ‘Laptops & Notebooks’
        Assert.assertEquals(laptopsAndNotebooksPage.getLaptopsAndNotebookText(), "Laptops & Notebooks", "Different Product display");
    }

    //Test 3
    @Test(groups = "regression")
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //3.1 Mouse hover on “Components” Tab and click
        homePage.mouseHooverOverMainMenuBar("Components");
        //3.2 call selectMenu method and pass the menu = “Show All Components”
        homePage.selectMenu("Show All Components");
        //3.3 Verify the text ‘Components’
        Assert.assertEquals(componentsPage.getTextOfComponentsPage(), "Components", "Text no displayed");

    }

}
