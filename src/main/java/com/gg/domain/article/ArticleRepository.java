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
    }

    public List<Article> getArticleList() {
        return articles;
    }

    public Article findById(int id) {
        return articles.stream()
                .filter(a -> a.getId() == id )
                .findFirst()
                .orElse(null);

    }

    public void update(Article article, String title, String content) {
        article.setTitle(title);
        article.setContent(content);
        article.setModifiedDate(LocalDateTime.now());
    }


    public void delete(Article article) {
        articles.remove(article);
    }
}
