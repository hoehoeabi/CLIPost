package com.gg.domain.article;

import com.gg.Article;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private int id = 0;
    private final List<Article> articles = new ArrayList<>();


    public void write(String title, String content) {
        Article article = new Article(++id, title, content, LocalDateTime.now());  //게시글 작성시 Article 객체 생성
        articles.add(article);
//        for(Article ar :articles){
//            System.out.printf("%d %s %s %s\n", ar.getId(), ar.getTitle(), ar.getContent(), ar.getRegDateFormatted());
//        }

    }

    public List<Article> getArticleList() {
        return articles;
    }
}
