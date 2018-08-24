package pages;

import org.openqa.selenium.By;

public class ArticlePage {
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENT_LINK= By.xpath(".//div[@class = 'article-title']/a");

    BaseFunc baseFunc;

    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getTitle() {
        return baseFunc.getElement(ARTICLE_PAGE_TITLE).getText();
    }

    public CommentPage openCommentPage() {
        baseFunc.getElement(COMMENT_LINK).click();
        return new CommentPage(baseFunc);
    }
}