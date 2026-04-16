package com.gg.domain.article;

import com.gg.AppContext;
import com.gg.Article;

import java.util.List;

public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService() {
        this.articleRepository = AppContext.articleRepository;
    }
    public void write(String title, String content) {

        articleRepository.write(title,content);
    }

    public List<Article> getArticleList() {
        return articleRepository.getArticleList();
    }

    public Article findById(int id) {
        return articleRepository.findById(id);
    }

    public void update(Article article, String title, String content) {
        articleRepository.update(article,title,content);
    }

    public void delete(Article article) {
        articleRepository.delete(article);
    }
}
