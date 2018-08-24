package DelfiTests;

import org.junit.Assert;
import org.junit.Test;
import pages.ArticlePage;
import pages.CommentPage;
import pages.HomePage;

import static java.awt.SystemColor.menu;

public class DelfiPOTest {

    DelfiBasefunc delfiBasefunc = new DelfiBasefunc();
    private final String DELFI_PAGE = "http://www.delfi.lv/";

    @Test
    public void checkTastyMenu() {
        delfiBasefunc.openDelfiPage(DELFI_PAGE);


        DelfiHomePage delfiHomePage = new DelfiHomePage(delfiBasefunc);

        DelfiHomePage delfiHomePage = new HomePage(delfiBasefunc);
        String title = delfiHomePage.getTitleById(1);    //
        TastyPage tastyPage = delfiHomePage.openTastyPage(1);

        String pageMenu = tastyPage.getMenu();
        //Все проверки именно характерные логике теста находятся в тесте
        Assert.assertEquals("firstTest.Article title does not match", menu, pageMenu);

        RecipePage recipePage = tastyPage.openRecipePage();

        String recipePage = recipePaget.getTitle();
        Assert.assertTrue("firstTest.Article title does not match", recipePagePageMenu.contains(menu));
    }
}