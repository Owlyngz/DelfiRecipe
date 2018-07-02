import org.junit.Test;

public class SecondClass {

    @Test
    public void secondMethod() {
        Article article = new Article();

        article.setTitle("Article Title");
        article.setCommentCount(15);

        System.out.println(article.getTitle());
        System.out.println(article.getLink());
    }
}
