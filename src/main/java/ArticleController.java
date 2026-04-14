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

    public void showDetail(int id){
        Article article = checkId(id);
        if(article == null)
            return;
        System.out.println("제목: " + article.getTitle());
        System.out.println("내용: " + article.getContent());
    }

    public void updateArticle(int id){
        Article article = checkId(id);
        if(article == null)
            return;
        System.out.println("제목(기존): " + article.getTitle());
        System.out.print("제목: ");
        String newTitle = scanner.nextLine();
        System.out.println("내용(기존): " + article.getContent());
        System.out.print("내용: ");
        String newContent = scanner.nextLine();
        article.setTitle(newTitle);
        article.setContent(newContent);
        article.setModDate(LocalDateTime.now());
        System.out.println(id + "번 게시글이 수정되었습니다.");
    }

    public void deleteArticle(int id){
        Article article = checkId(id);
        if(article == null)
            return;
        articleList.remove(article);
        System.out.println(id + "번 게시글이 삭제되었습니다.");
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

    public void showCommands(){
        System.out.println("등록: write");
        System.out.println("목록: list");
        System.out.println("상세보기: detail [id]");
        System.out.println("수정: update [id]");
        System.out.println("삭제: delete [id]");
        System.out.println("도움말: help");
    }
}
