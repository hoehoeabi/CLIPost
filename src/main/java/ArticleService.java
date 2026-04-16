import java.time.LocalDateTime;
import java.util.List;

public class ArticleService {

    List<Article> articleList = AppContext.articleList;
    int lastId = 0;

    public void write(String title, String content){
        Article newArticle = new Article();
        newArticle.setId(++lastId);
        newArticle.setTitle(title);
        newArticle.setContent(content);
        newArticle.setRegDate(LocalDateTime.now());
        articleList.add(newArticle);
    }

    public void update(Article article, String newTitle, String newContent){
        article.setTitle(newTitle);
        article.setContent(newContent);
        article.setModDate(LocalDateTime.now());
    }

    public void delete(Article article){
        articleList.remove(article);
    }

    public Article checkId(int id){
        for(Article article : articleList){
            if(article.getId() == id){
                return article;
            }
        }
        System.out.println(id + "번 게시글은 존재하지 않습니다.");
        return null;
    }
}
