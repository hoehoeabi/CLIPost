package controller;

import domain.Article;
import global.dto.Page;
import global.dto.Pageable;
import global.dto.Rq;
import global.standard.Msg;
import service.ArticleService;
import view.ArticleView;

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
        System.out.printf(Msg.ARTICLE_WRITE_SUCCESS, id);
    }

    public void showList(Rq rq) {
        Pageable pageable = rq.getPageable(5);
        Page<Article> articlePage = articleService.getArticles(pageable);
        articleView.printPageResult(articlePage, Msg.ARTICLE_LIST_TITLE, Msg.ARTICLE_LIST_EMPTY);
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
            System.out.printf(Msg.ARTICLE_MODIFY_SUCCESS, id);
        });
    }

    public void doDelete(Rq rq) {
        executeWithId(rq, id -> {
            articleService.remove(id);
            System.out.printf(Msg.ARTICLE_DELETE_SUCCESS, id);
        });
    }

    public void doSearch(Rq rq) {
        String target = rq.getParam("target", "all");
        String keyword = rq.getParam("keyword", "");

        if (keyword.isEmpty()) {
            System.out.println(Msg.INPUT_KEYWORD);
            return;
        }

        Pageable pageable = rq.getPageable(5);
        Page<Article> searchPage = articleService.getSearchArticles(pageable, target, keyword);

        String searchTarget = switch (target) {
            case "title" -> "제목";
            case "content" -> "내용";
            default -> "제목+내용";
        };

        String searchResultHeader = String.format(Msg.ARTICLE_SEARCH_TITLE_FORMAT, target, keyword);
        String emptyMsg = String.format(Msg.ARTICLE_SEARCH_NOT_FOUND, searchTarget, keyword);

        articleView.printPageResult(searchPage, searchResultHeader, emptyMsg);
    }

    public void showHelp(Rq rq) {
        articleView.printHelp();
    }

    private void executeWithId(Rq rq, Consumer<Integer> action) {
        try {
            int id = rq.getIntParam("id", 0);
            if (id == 0) {
                System.out.println(Msg.INVALID_ID);
                return;
            }
            action.accept(id);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}