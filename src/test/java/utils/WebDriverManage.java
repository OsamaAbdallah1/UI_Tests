package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.time.Duration;

public class WebDriverManage {

    private static WebDriver driver;

    public static WebDriver getDriver() {

            driver = new EdgeDriver();
            driver.get("https://www.sogeti.com/");
            driver.manage().window().maximize();
            driver.findElement(By.xpath("//button[@role='button']")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        return driver;
    }

    public static void quitDriver() {
            driver.quit();
    }
}
