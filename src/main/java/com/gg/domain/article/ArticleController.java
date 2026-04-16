package com.gg.domain.article;

import com.gg.AppContext;
import com.gg.Rq;

public class ArticleController {

    private final ArticleService articleService = AppContext.articleService;

    public void writeArticle() {
        System.out.print("제목: ");
        String title = AppContext.sc.nextLine().trim();
        System.out.print("내용: ");
        String content = AppContext.sc.nextLine().trim();

        articleService.write(title, content);

//    public void listArticles() {
//    }
//
//    public void showDetail(Rq rq) {
//    }
//
//    public void updateArticle(Rq rq) {
//    }
//
//    public void deleteArticle(Rq rq) {
//    }
    }
}
