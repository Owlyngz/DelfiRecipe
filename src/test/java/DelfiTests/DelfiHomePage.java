package DelfiTests;

import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DelfiHomePage {

    WebDriver driver;

    private final By DELFI_MAIN_MENU = By.xpath(".//*[@id='header']/header/nav[1]/a");
    private final By DELFI_LOGO = By.xpath(".//img[@alt = 'DELFI']");
    private final By COMMERCIAL = By.xpath(".//div[@class = 'top-banner']");
    private final By MENU = By.xpath(".//nav[@class = 'headerMainNavigation headerSeparatedNav']");
    private final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(DelfiRecipeTwo.class);

    DelfiBasefunc delfiBasefunc;


    public DelfiHomePage(DelfiBasefunc delfiBasefunc) {
        this.delfiBasefunc = delfiBasefunc;

        Assert.assertTrue("There is no Logo", delfiBasefunc.isElementPresent(DELFI_LOGO));
        Assert.assertTrue("There is no commercial banner", delfiBasefunc.isElementPresent(COMMERCIAL));
        Assert.assertTrue("There is no Menu", delfiBasefunc.isElementPresent(MENU));

        selectMenuItem("Tasty"); //home page

        LOGGER.info("Selecting Tasty from the menu");
    }

//    public String getTitleById(Integer id) {
//        return getTitleById(id).click();
//    }

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


}
