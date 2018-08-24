import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class WebTest {
    //Konstanti c nazvanii vsegda soderzhat boljshie bukvi
    //Konstanti oboznachajutsa v Jave kak final
    //Konstanti eto te peremennie, kotorie ne dolzhni menjatsa v processe vipolnenija testa, izmenitj ih ne dast ni IDEA, ni Java
    private final String HOME_PAGE = "http://javaguru.lv";

    //Lokatori vsegda javljautsa objektom By i vsegda konstanti
    private final By ELEMENT = By.id("12346");
    private final By NAME_ELEMENT = By.name("name");
    private final By CLASS_ELEMENT = By.className("logo");

    @Test
    public void someTest() {

        //sozdajom kopiju objekta WebDriver - prostim jazikom otkrivaem okno brauzera s kotorim budem rabotatj cherez peremennuju driver
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(HOME_PAGE);

        //Vozvrashaet odin element
        WebElement classElement = driver.findElement(CLASS_ELEMENT);

        //Vozvrashaet vse elementi spiskom
        List<WebElement> classElements = driver.findElements(CLASS_ELEMENT);
        WebElement el = classElements.get(1);
//        classElements.get(5);
//        classElements.get(7);



        WebElement webElement = driver.findElement(ELEMENT);
        webElement.click();
        webElement.sendKeys("Test");

        Assert.assertEquals("", "");

    }
}
