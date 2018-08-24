package DelfiTests;

import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class DelfiRecipeTwo {
    WebDriver driver;


    private final String DELFI_PAGE = "http://www.delfi.lv/";
    private final By DELFI_MAIN_MENU = By.xpath(".//*[@id='header']/header/nav[1]/a");
    private final By Tasty_Menu = By.xpath(".//html[1]/body[1]/nav[1]/div[1]/div[1]/ul[1]/li");
    private final By RECIPE_ITEM = By.xpath(".//h1[@class='headline-title text-md']");
    private final String RECIPE_NAME = "Hanzas pavāru meistarstiķis – rudzu maizes deserts";
    private final By Hanzas_Menu = By.xpath(".//a[@class='ing-title']");
    private final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(DelfiRecipeTwo.class);



    @Test
    public void DelfiRecipeTest() {

        LOGGER.info("We are opening and maximixing Firefox browser");


        System.setProperty("webdriver.gecko.driver", "c:/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(DELFI_PAGE);  //@test


        selectMenuItem("Tasty"); //home page

        LOGGER.info("Selecting Tasty from the menu"); //hp

        selectMenuItemTwo("RECEPTES");  //Tasty Page

        LOGGER.info("Selecting RECEPTES from the menu"); //tp

        selectMenuItemThree(RECIPE_NAME); //tp

        LOGGER.info("Selecting a needed recipe(Hanzas pavāru meistarstiķis – rudzu maizes deserts)");



        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());  //tp
        driver.switchTo().window(tabs.get(1));//switches to new tab

        LOGGER.info("We are switching the tab to the selected recipe tab");



        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(Hanzas_Menu));

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

        driver.quit();



    }

    private void selectMenuItem(String menuItem) {
        List<WebElement> menuItems = driver.findElements(DELFI_MAIN_MENU);
        boolean flag = false;
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).getText().equals(menuItem)) {
                menuItems.get(i).click();
                flag = true;
                break;
            }
        }
        Assert.assertTrue("Menu item1 not found", flag);
    }

    private void selectMenuItemTwo(String menuItem) {
        List<WebElement> menuItems = driver.findElements(Tasty_Menu);
        boolean flag = false;
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).getText().equals(menuItem)) {
                menuItems.get(i).click();
                flag = true;
                break;
            }
        }
        Assert.assertTrue("Menu item2 not found", flag);
    }

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




