package firtTest;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

    public class DelfiArticlePresentsTest {
        private final String ARTICLE_NAME = "Uz Jūrmalas šosejas avarējušas vismaz sešas automašīnas";
        private final String HOME_PAGE = "http://www.delfi.lv/";
        private final By ARTICLE_ITEM = By.xpath(".//*[@class='top2012-title']");

        @Test
        public void findingAnArticle () {
            System.setProperty("webdriver.gecko.driver","c:/geckodriver.exe");
            WebDriver driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.get(HOME_PAGE);

            List<WebElement> articleItems = new ArrayList<WebElement>();
            articleItems = driver.findElements(ARTICLE_ITEM);

            boolean isArticlefound = false;
            for (int i = 0; i < articleItems.size(); i++) {
                if (articleItems.get(i).getText().equals(ARTICLE_NAME)) {
                    isArticlefound = true;
                    break;
                }


                //for (int k = 5; k > 0; k--) {
                //System.out.println(k);

//}
            }
            Assert.assertTrue("No firtTest.Article Item is found", isArticlefound);

        }



        //propisatjj imja statji
        //ispoljzuja opredeljennij driver
        //kotorij nahoditsja na diske :/C
        //podgruzhaet browser Firefox
        //otkrivaet stranichku Delfi

        //propisatj Lokator
        //najti  elementy
        // sozdanie spiska
        //zapisatj v spisok

        //perebiratj statji
        //zajti v kod, po WebElements,ispoljzuja lokator, najti nazvanie statji
        //proveritj, ta li eta statja? (sravnitj s dannoj)

//        private String HOME_PAGE
//        System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.get(HOME_PAGE_DELFI);
//        driver.findElement(BRIVDIENU_MARSHRUTS_JELGAVA).click();
//        Assert.assertEquals("HOME_PAGE_DELFI");
//        driver.quit();


        //
        //gjgyjghjghj
        //hbjbhjbhjhb
    }

