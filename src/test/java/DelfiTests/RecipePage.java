package DelfiTests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class RecipePage {
    WebDriver driver;

    private final By Hanzas_Menu = By.xpath(".//a[@class='ing-title']");

    DelfiBasefunc delfiBasefunc;

    public RecipePage(DelfiBasefunc delfiBasefunc) {    // eto dlja chego? raspoznanie klassa?  -//-
        this.delfiBasefunc = delfiBasefunc;            // eto dlja chego? raspoznanie klassa? potomu chto obrashjaemsja k konstruktoru?
    }

    WebDriverWait wait = new WebDriverWait(driver, 15);
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Hanzas_Menu)); // ili eto v basefunc?

        LOGGER.info("Waiting for our new tab to load");


    List<WebElement> AllIngredients = driver.findElements(Hanzas_Menu);  //recipe page

        LOGGER.info("We found a list of all ingredients");

    List<String> IngredientHref = new ArrayList<String>();  //recipe page
        for (int i=0 ; i < AllIngredients.size() ; i++) {
        IngredientHref.add(AllIngredients.get(i).getAttribute("href"));
    }

        LOGGER.info("We made a list of all ingredient links");

        for (int i=0 ; i < IngredientHref.size() ; i++) {  //recipe page
        driver.get(IngredientHref.get(i));
        checkMenuItemThree(RECIPE_NAME);
    }

        LOGGER.info("And checking an existence of our recipe, on each ingredient page");




    public String getTastyMenu() { return delfiBasefunc.getElement(Hanzas_Menu).getText(); }




    private void selectMenuItemThree(String menuItem) {
        List<WebElement> menuItems = driver.findElements(RECIPE_ITEM);
        boolean flag = false;
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).getText().equals(menuItem)) {
                menuItems.get(i).click();
                flag = true;
                break;
            }
        }
        Assert.assertTrue("Menu item3 not found", flag);
    }

    private void checkMenuItemThree(String menuItem) {
        List<WebElement> menuItems = driver.findElements(RECIPE_ITEM);
        boolean flag = false;
        for (int i=0; i<menuItems.size(); i++) {
            if (menuItems.get(i).getText().equals(menuItem)) {
                flag = true;
                break;
            }
        }
        Assert.assertTrue("Recipe is not found", flag);
    }

}
