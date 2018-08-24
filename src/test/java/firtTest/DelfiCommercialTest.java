package firtTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class DelfiCommercialTest {
    private final String SITE_ADDRESS = "http://rus.delfi.lv/";
    private final By TEST_COMBLOCK = By.name("adoContainer_iwkoblknumwnpisrhmhhucln");

    @Test
    public void delficommercialtest(){

        System.setProperty("webdriver.gecko.driver","c:/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(SITE_ADDRESS);



        List<WebElement> listOfElements = new ArrayList<WebElement>();

        listOfElements = driver.findElements(TEST_COMBLOCK);
        Assert.assertTrue("No Commercial Found", !listOfElements.isEmpty());


    }
}
