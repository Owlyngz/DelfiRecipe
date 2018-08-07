package firtTest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class AutomationPractice {
    private final String HOME_PAGE = "http://automationpractice.com/index.php";
    private final By DRESSES = By.xpath(".//*[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]");
    private final By ORANGE = By.name("layered_id_attribute_group_13");

    private final By TEST = By.xpath(".//*[@class= 'product_list grid row']/li[1]");
    //putj k objektu li =(list), gde nahoditsja pervoe platje

    private final By Add1stItem = By.xpath(".//*[@class= 'button ajax_add_to_cart_button btn btn-default'][1]");
    //putj k knopke


    //private final By Add1stItem = By.xpath(".//*[@class= 'right-block']/div[2]/a/span");
     //*[@class= 'button ajax_add_to_cart_button btn btn-default']
    @Test
    public void compareprices() {
        System.setProperty("webdriver.gecko.driver","c:/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE);

        WebElement webElement = driver.findElement(DRESSES);
        webElement.click();
        webElement  = driver.findElement(ORANGE);
        webElement.click();
        webElement = driver.findElement(TEST);
        ((FirefoxDriver) driver).executeScript("arguments[0].setAttribute('class', 'ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line last-line first-item-of-tablet-line first-item-of-mobile-line last-mobile-line hovered')", webElement);
        //executeScript = proizvesti skript
        webElement = driver.findElement(Add1stItem);
        webElement.click();




        //List<WebElement>sectionItems = new ArrayList<WebElement>();
        //sectionItems  = driver.findElements(WOMEN_SECTION);



    }
}