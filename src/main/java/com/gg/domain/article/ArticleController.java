package com.gg.domain.article;

import com.gg.AppContext;
import com.gg.Article;
import java.util.List;

import static com.gg.AppContext.sc;

public class ArticleController {

    private final ArticleService articleService = AppContext.articleService;

    public void writeArticle() {
        System.out.print("제목: ");
        String title = sc.nextLine().trim();
        System.out.print("내용: ");
        String content = sc.nextLine().trim();

        articleService.write(title, content);

        System.out.println("=> 게시글이 등록되었습니다.");
    }

    public void listArticles() {
        List<Article> articles = articleService.getArticleList();
        System.out.println("번호 | 제목       | 최종 등록일");
        System.out.println("-----------------------------");
        //게시글 역순으로 출력
        articles.reversed()
                .forEach(e -> System.out.printf("%d    | %s  | %s\n", e.getId(), e.getTitle(), e.getRegDateFormatted()));

    }

    public void showDetail(int id) {
        Article article = getArticleByIdOrPrintError(id);
        if (article == null) return;

        System.out.printf("번호: %d\n", article.getId());
        System.out.printf("제목: %s\n", article.getTitle());
        System.out.printf("내용: %s\n", article.getContent());
        System.out.printf("등록일: %s\n", article.getRegDateFormatted());

        if (article.getModifiedDate() != null) {
            System.out.printf("수정일: %s\n", article.getModifiedDateFormatted());
        }
    }

    public void updateArticle(int id) {
        Article article = getArticleByIdOrPrintError(id);
        if (article == null) return;

        System.out.printf("제목 (현재: %s): ", article.getTitle());
        String title = sc.nextLine().trim();

        System.out.printf("내용 (현재: %s): ", article.getContent());
        String content = sc.nextLine().trim();

        articleService.update(article, title, content);
        System.out.println("=> 게시글이 수정되었습니다.");
    }

    public void deleteArticle(int id) {
        Article article = getArticleByIdOrPrintError(id);
        if (article == null) return;

        articleService.delete(article);
        System.out.println("=> 게시글이 삭제되었습니다.");
    }

    //id 입력받는 경우 예외처리 함수
    private Article getArticleByIdOrPrintError(int id) {
        //예외처리) id를 입력하지 않은 경우
        if (id == -1) {
            System.out.println("id를 입력해주세요.");
            return null;
        }

        Article article = articleService.findById(id);

        //예외처리) id가 존재하지 않는 경우
        if (article == null) {
            System.out.println("해당 아이디는 존재하지 않습니다.");
            return null;
        }

        return article;
    }
}
