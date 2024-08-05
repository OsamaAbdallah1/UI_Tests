package selenium.ui_tests;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.stream.Collectors;

public class HomePage {
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    private By servicesMenu = By.xpath("//nav[@id='main-menu']//ul[@class='level0 clearfix']//li[@data-levelname='level2']//div[@class='wrapper']/span[text()='Services']");
    private By automationLink = By.xpath("//a[@class=\"subMenuLink\"][text()='Automation']");
    private By worldWideLink = By.xpath("//span[@aria-label='Worldwide']");



    public void hoverOverServices() {
        WebElement servicesElement = driver.findElement(servicesMenu);
        Actions actions = new Actions(driver);
        actions.moveToElement(servicesElement).perform();
    }

    public void clickAutomationLink() {
        driver.findElement(automationLink).click();
    }

    public void clickWorldWideMenu()
    {
        driver.findElement(worldWideLink).click();
    }

    public List<String> countryListLinks() {
        List<WebElement> options = driver.findElements(By.xpath("//div[@id='country-list-id']/ul/li/a"));

        return options.stream()
                .map(a -> a.getAttribute("href"))
                .collect(Collectors.toList());
    }

}
