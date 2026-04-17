package com;

public class Article {
    int id;
    String title;
    String content;
    String regDate;
    int count = 0;

    Article(int id, String title, String content, String regDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
        this.count = count;
    }
}
