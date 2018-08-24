package pages;

import org.openqa.selenium.By;

//сам пеидж, содержит локаторы и функции только для текущей страницы
public class CommentPage {
    private final By COMMENT_PAGE_TITLE = By.xpath(".//a[@class = 'comment-main-title-link']");

    BaseFunc baseFunc;

    public CommentPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;

    }

    public String getTitle() {
        return baseFunc.getElement(COMMENT_PAGE_TITLE).getText();
    }
}
