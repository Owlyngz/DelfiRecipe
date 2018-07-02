import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class JavaGuruTest {
    private final String COURSE_NAME = "Курс PHP";
    private final String HOME_PAGE = "http://javaguru.lv/";
    private final By COURSE_ITEM = By.xpath(".//*[@class= 'menuAcourse']/span");

    @Test
    public void checkElementInMenu() {
        System.setProperty("webdriver.gecko.driver","c:/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE);

        List<WebElement> menuItems = new ArrayList<WebElement>();
        menuItems = driver.findElements(COURSE_ITEM);

        boolean isCourseFound = false;
        for(int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).getText().equals(COURSE_NAME)) {
                isCourseFound = true;
                break;

            }
        }

        Assert.assertTrue("No menu Item is found", isCourseFound);
    }
}
