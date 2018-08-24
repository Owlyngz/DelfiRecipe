package DelfiTests;

import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DelfiBasefunc {
    WebDriver driver;

    public final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(DelfiRecipeTwo.class);

     LOGGER.info("We are opening and maximixing Firefox browser");

    public DelfiBasefunc() {

        System.setProperty("webdriver.gecko.driver", "c:/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();

    }
    public void openDelfiPage(String url) {
        if (!url.contains("http://") && !url.contains("https://")); {
            url = "http://" + url;
        }
        driver.get(url);
    }
    public List<WebElement> getElements(By locator) {
        Assert.assertFalse("No elements found", driver.findElements(locator).isEmpty());
        return driver.findElements(locator);
    }

    public WebElement getElement(By locator) {
        waitForElement(locator);
        return driver.findElement(locator);
    }

    driver.quit();


    public boolean isElementPresent(By locator) {                  // chto eto?
        return getElements(locator).isEmpty();
    }


    private void waitForElement(By locator) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
