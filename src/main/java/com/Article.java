package com;

public class Article {
    int id;
    String title;
    String content;
    String regDate;
    int count = 0;

    // 이게 생성자!
    Article(int id, String title, String content, String regDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
        this.count = count;
    }
}