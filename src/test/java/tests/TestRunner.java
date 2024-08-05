package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.ui_tests.AutomationPage;
import selenium.ui_tests.HomePage;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TestRunner extends TestBase{

    @Test
    public void A_hoverOverServicesAndClickAutomationLink() {

    HomePage homePage = new HomePage(driver);
    AutomationPage automationPage = new AutomationPage(driver);

        homePage.hoverOverServices();
        homePage.clickAutomationLink();

        Assert.assertTrue(automationPage.isAutomationPageDisplayed(), "Automation page is not displayed.");
        Assert.assertTrue(automationPage.isAutomationTextPresent(), "Automation text is not present.");
        homePage.hoverOverServices();
        Assert.assertTrue(automationPage.isServicesMenuSelected(), "Services menu is not selected.");
        Assert.assertTrue(automationPage.isAutomationButtonSelected(), "Automation button is not selected.");
    }

    @Test
    public void B_clickWorldWideDropdownMenu(){

    HomePage homePage = new HomePage(driver);
    homePage.clickWorldWideMenu();

    List<String> actualOptions = homePage.countryListLinks();
    List<String> expectedOptions = Arrays.asList("https://www.sogeti.be/", "https://www.sogeti.fi/", "https://www.fr.sogeti.com/",
            "https://www.sogeti.de/","https://www.sogeti.ie/","https://www.sogeti.lu/","https://www.sogeti.nl/","https://www.sogeti.no/","https://www.sogeti.es/","https://www.sogeti.se/","https://www.uk.sogeti.com/","https://www.us.sogeti.com/");
    System.out.println(actualOptions);
    System.out.println(expectedOptions);

    Assert.assertEquals(actualOptions, expectedOptions, "Dropdown options do not match" );

    }

    @Test
    public void C_fillOutContactUsForm() throws IOException {

    HomePage homePage = new HomePage(driver);
    AutomationPage automationPage = new AutomationPage(driver);


    homePage.hoverOverServices();
    homePage.clickAutomationLink();
    automationPage.scrollToElement();
        setExcelHandler();
    automationPage.fillContactUSForm(firstName, lastName,email, phone,company, country, message);

    automationPage.clickIAgreeCheckBox();
    //automationPage.clickSubmitButton();



    }

    }
