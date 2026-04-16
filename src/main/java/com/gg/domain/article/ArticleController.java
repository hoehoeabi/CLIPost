package com.gg.domain.article;

import com.gg.AppContext;
import com.gg.Article;
import com.gg.Rq;

import java.util.ArrayList;
import java.util.List;

public class ArticleController {

    private final ArticleService articleService = AppContext.articleService;

    public void writeArticle() {
        System.out.print("제목: ");
        String title = AppContext.sc.nextLine().trim();
        System.out.print("내용: ");
        String content = AppContext.sc.nextLine().trim();

        articleService.write(title, content);

        System.out.println("=> 게시글이 등록되었습니다.");
    }
    public void listArticles() {
        List<Article> articles = articleService.getArticleList();
        System.out.println("번호 | 제목       | 등록일");
        System.out.println("-----------------------------");
        articles.reversed()
                .forEach(e -> System.out.printf("%d    | %s  | %s\n", e.getId(), e.getTitle(), e.getRegDateFormatted()));

    }

//    public void showDetail(Rq rq) {
//    }
//
//    public void updateArticle(Rq rq) {
//    }
//
//    public void deleteArticle(Rq rq) {
//    }

}
