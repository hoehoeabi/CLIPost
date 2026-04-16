package controller;

import domain.Article;
import view.ArticleView;
import service.ArticleService;
import global.dto.Page;
import global.dto.Pageable;
import global.dto.Rq;

import java.util.Scanner;
import java.util.function.Consumer;

public class ArticleController {
    private final ArticleService articleService;
    private final ArticleView articleView;
    private final Scanner sc;

    public ArticleController(ArticleService articleService, ArticleView articleView, Scanner sc) {
        this.articleService = articleService;
        this.articleView = articleView;
        this.sc = sc;
    }

    public void doWrite(Rq rq) {
        System.out.print("제목: ");
        String title = sc.nextLine();
        System.out.print("내용: ");
        String content = sc.nextLine();
        int id = articleService.write(title, content);
        System.out.printf("%d번 게시글이 등록되었습니다.\n", id);
    }

    public void showList(Rq rq) {
        Pageable pageable = rq.getPageable(5);
        Page<Article> articlePage = articleService.getArticles(pageable);
        articleView.printPageResult(articlePage, "전체 목록","현재 등록된 게시글이 없습니다.");
    }

    public void showDetail(Rq rq) {
        executeWithId(rq, id -> {
            Article article = articleService.getArticleWithIncreaseCount(id);
            articleView.printArticleDetail(article);
        });
    }

    public void doModify(Rq rq) {
        executeWithId(rq, id -> {
            Article article = articleService.getArticle(id);
            System.out.printf("제목(기존: %s): ", article.getTitle());
            String title = sc.nextLine();
            System.out.printf("내용(기존: %s): ", article.getContent());
            String content = sc.nextLine();

            articleService.modify(id, title, content);
            System.out.printf("%d번 게시글이 수정되었습니다.\n", id);
        });
    }

    public void doDelete(Rq rq) {
        executeWithId(rq, id -> {
            articleService.remove(id);
            System.out.printf("%d번 게시글이 삭제되었습니다.\n", id);
        });
    }

    public void doSearch(Rq rq) {
        String target = rq.getParam("target", "all");
        String keyword = rq.getParam("keyword", "");
        if (keyword.isEmpty()) {
            System.out.println("검색어를 입력해주세요.");
            return;
        }

        Pageable pageable = rq.getPageable(5);
        Page<Article> searchPage = articleService.getSearchArticles(pageable, target, keyword);

        String searchTarget = switch (target) {
            case "title" -> "제목";
            case "content" -> "내용";
            default -> "제목+내용"; // "all" 포함 그 외 모든 경우 처리
        };

        String emptyMsg = String.format("'%s' : '%s'(으)로 검색된 결과가 없습니다.", searchTarget,keyword);

        articleView.printPageResult(searchPage, String.format("[%s] 검색 결과 (키워드: %s)", target, keyword),emptyMsg);
    }

    public void showHelp(Rq rq) {
        articleView.printHelp();
    }

    private void executeWithId(Rq rq, Consumer<Integer> action) {
        try {
            int id = rq.getIntParam("id", 0);
            if (id == 0) {
                System.out.println("올바른 ID를 입력해주세요.");
                return;
            }
            action.accept(id);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}