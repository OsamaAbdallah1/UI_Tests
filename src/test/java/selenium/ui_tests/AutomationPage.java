package selenium.ui_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AutomationPage {

    public AutomationPage(WebDriver driver)
    {
        this.driver = driver;
    }

    private WebDriver driver;

    public WebDriverWait wait;


    private By pageTitle = By.xpath("//span[text()='Automation']");
    private By selectedServices = By.xpath("//nav[@id=\'main-menu\']//li[@class=\'selected has-children expanded level2 focus-style hover\']");


    private By firstNameField = By.xpath("//form[@method='post']//div[@class='row row-0 textboxelementblock']//input[@class='FormTextbox__Input']");
    private By lastNameField = By.xpath("//form[@method='post']//div[@class='row row-1 textboxelementblock']//input[@class='FormTextbox__Input']");
    private By emailField = By.xpath("//form[@method='post']//div[@class='row row-2 textboxelementblock']//input[@class='FormTextbox__Input']");
    private By phoneField = By.xpath("//form[@method='post']//div[@class='row row-3 textboxelementblock']//input[@class='FormTextbox__Input']");
    private By companyField = By.xpath("//form[@method='post']//div[@class='row row-4 textboxelementblock']//input[@class='FormTextbox__Input']");
    private By countryField = By.xpath("//select[@aria-describedby='__field_132596_desc']");
    private By messageField = By.xpath("//div[@data-f-type='textbox']//textarea[@class='FormTextbox__Input']");
    private By iAgreeCheckBox = By.xpath("//label[@for='__field_1239350']");
    private By submitButton = By.xpath("//button[@name='submit']");
    private By selectedAutomation = By.xpath("//div[@class = 'wrapper']//li[@class = 'selected  current expanded']");



    public boolean isAutomationPageDisplayed() {
        return driver.findElement(pageTitle).isDisplayed();
    }

    public boolean isAutomationTextPresent() {
        return driver.findElement(pageTitle).getText().contains("Automation");
    }

    public boolean isServicesMenuSelected() {return driver.findElement(selectedServices).getAttribute("class").contains("selected");}

    public boolean isAutomationButtonSelected() {return     driver.findElement(selectedAutomation).getAttribute("class").contains("selected");}

    public void fillContactUSForm(String firstName, String lastName, String email, String phone,  String company, String country,String message)
    {
        driver.findElement(firstNameField).sendKeys(firstName);

        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(phoneField).sendKeys(phone);
        driver.findElement(companyField).sendKeys(company);
        WebElement selectElement = driver.findElement(countryField);
        Select select = new Select(selectElement);
        select.selectByVisibleText(country);
        driver.findElement(messageField).sendKeys(message);
    }

    public void scrollToElement()
    {

        WebElement element = driver.findElement(By.xpath("//h2[@class='Form__Title']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

    }

    public void clickIAgreeCheckBox()
    {
        driver.findElement(iAgreeCheckBox).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='recaptcha-checkbox-border']"))).click();


    }

    public void clickSubmitButton()
    {
        driver.findElement(submitButton).click();
    }


}
