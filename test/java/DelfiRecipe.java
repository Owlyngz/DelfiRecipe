import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class DelfiRecipe {

    private final String DELFI_PAGE = "http://www.delfi.lv/";
    //private final By Tasty = By.xpath("."); //.//span[contains(text(),'Tasty')])  //a[@class='headerSeparatedNavLink'][9]/span
    private final By DELFI_MAIN_MENU = By.xpath(".//nav[@class='headerMainNavigation headerSeparatedNav']");
    private final By Tasty_Menu = By.xpath(".//div[@class='container channel-nav']");
    private final By RECIPE_ITEM = By.xpath(".//h1[@class='headline-title text-md']");
    private final String RECIPE_NAME = "Veselīgie auzu pārslu groziņi ar aveņu krēmu";

    @Test
    public void DelfiRecipeTest() {

        System.setProperty("webdriver.gecko.driver", "c:/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(DELFI_PAGE);



        selectMenuItem("Tasty");
        selectMenuItem("RECEPTES");



        //driver.findElement(Tasty).click();

        List<WebElement> recipeItems = new ArrayList<WebElement>();  // "List" vibiralsja .java v etih sluchajah??
        recipeItems = driver.findElements(RECIPE_ITEM);

        boolean isRecipefound = false;
        for(int i = 0; i < recipeItems.size(); i++) {   // i = ljubaja bukva i objazateljno = 0? i < razmera statji, ishjem daljshe?
            if (recipeItems.get(i).getText().equals(RECIPE_NAME)) {
                isRecipefound = true;
                break;
            }

        }
        Assert.assertTrue("No Recipe Item is found", isRecipefound);

        driver.findElement(By.id(RECIPE_NAME)).click();

        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); //switches to new tab
        driver.get("http://www.delfi.lv/tasty/receptes/veseligie-auzu-parslu-grozini-ar-avenu-kremu.d?id=50276653");


    }
    private void selectMenuItem(String menuItem) {
        List<WebElement> menuItems = driver.findElements(DELFI_MAIN_MENU, Tasty_Menu);
        for (int i = 0; i < menuItems.size(); i++) {
            if (menuItems.get(i).getText().equals(menuItem)) {
                menuItems.get(i).click();
                break;
            }
        }

    }


}





