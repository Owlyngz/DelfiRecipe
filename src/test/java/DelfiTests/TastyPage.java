package DelfiTests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class TastyPage {

    WebDriver driver;


    private final By Tasty_Menu = By.xpath(".//html[1]/body[1]/nav[1]/div[1]/div[1]/ul[1]/li");
    private final By RECIPE_ITEM = By.xpath(".//h1[@class='headline-title text-md']");
    private final String RECIPE_NAME = "Hanzas pavāru meistarstiķis – rudzu maizes deserts";

    DelfiBasefunc delfiBasefunc;

    selectMenuItemTwo("RECEPTES");  //Tasty Page

        LOGGER.info("Selecting RECEPTES from the menu"); //tp

    selectMenuItemThree(RECIPE_NAME); //tp

        LOGGER.info("Selecting a needed recipe(Hanzas pavāru meistarstiķis – rudzu maizes deserts)");
      //  return Selecting a needed recipe Hanzas pavāru meistarstiķis – rudzu maizes deserts.replace(" ", "");




    ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());  //tp
    driver.switchTo().window(tabs.get(1));//switches to new tab

        LOGGER.info("We are switching the tab to the selected recipe tab");

    public TastyPage(DelfiBasefunc delfiBasefunc) {
        this.delfiBasefunc = delfiBasefunc;
    }


    public String getMainyMenu() {
        return delfiBasefunc.getElement(Tasty_Menu).getText();  // vrjad li getText........pochemu tut return a vnizu return new...vozvrashjaem obnovljennuju str v Basefunc?

        public RecipePage openRecipePage() {
            delfiBasefunc.getElement(selectMenuItemTwo("Tasty")).click();
            return new RecipePage(delfiBasefunc);

        }

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
}

