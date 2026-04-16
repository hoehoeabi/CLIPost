package com.gg.domain.article;

import com.gg.AppContext;
import com.gg.Article;

public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService() {
        this.articleRepository = AppContext.articleRepository;
    }
    public void write(String title, String content) {

        articleRepository.write(title,content);
    }
}
