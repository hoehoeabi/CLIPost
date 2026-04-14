import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArticleController {
    Scanner scanner = AppContext.scanner;
    List<Article> articleList = new ArrayList<>();
    int lastId = 0;

    public void writeArticle(){

        System.out.print("제목: ");
        String title = scanner.nextLine();
        System.out.print("내용: ");
        String content = scanner.nextLine();
        Article newArticle = new Article();
        newArticle.setId(++lastId);
        newArticle.setTitle(title);
        newArticle.setContent(content);
        newArticle.setRegDate(LocalDateTime.now());
        articleList.add(newArticle);
        System.out.println("게시글이 등록되었습니다.");
    }

    public void listArticles(){
        System.out.println("번호 | 제목         | 등록일        ");
        System.out.println("-----------------------------------------");
        for(Article article : articleList){
            System.out.printf("%-5d| %-13s| %s\n", article.getId(), article.getTitle(), article.getRegDate());
        }
    }

    public void  showDetail(int id){

    }

    public void updateArticle(int id){

    }

    public void deleteArticle(int id){

    }
}
