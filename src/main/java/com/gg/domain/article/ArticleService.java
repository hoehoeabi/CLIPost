package com.gg.domain.article;

import com.gg.AppContext;
import com.gg.Article;
import com.gg.Rq;

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

    public Article getArticleDetail(int id) {
        return articleRepository.getArticleDetail(id);
    }

    public void update(Article article, String title, String content) {
        articleRepository.update(article,title,content);
    }
}
