package com;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ArticleService {
    ArrayList<Article> articles = new ArrayList<>();
    int lastId = 0;


    public void writeArticle(String title, String content) {
        articles.add(new Article(++lastId, title, content, getCurrentDate()));
    }

    public String getCurrentDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.now().format(formatter);
    }

    public Article showDetail(int id) {
        for (Article article : articles) {
            if (article.id == id) {
                return article;
            }
        }
        return null;
    }

    public void updateArticle(int id, String title, String content) {
        for (Article article : articles) {
            if (article.id == id) {
                article.title = title;
                article.content = content;
            }
        }
    }

    public boolean deleteArticle(int id) {
        return articles.removeIf(article -> article.id == id);
    }

    ArrayList<Article> listArticles() {
        return articles;
    }

    public ArrayList<Article> sortByCount() {
        ArrayList<Article> sorted = new ArrayList<>(articles);
        sorted.sort((a, b) -> b.count - a.count);
        return sorted;
    }

    public void increaseCount(int id) {
        for (Article article : articles) {
            if (article.id == id) {
                article.count++;
            }
        }
    }
}
