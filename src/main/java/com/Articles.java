package com;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Articles {
    private final List<Article> articles = new ArrayList<>();
    private final Scanner scanner;
    int lastId = 0;

    public Articles(Scanner scanner) {
        this.scanner = scanner;
    }

    public void writeArticle() {
        System.out.println("제목 : ");
        String title = scanner.nextLine().trim();

        System.out.println("내용 : ");
        String content = scanner.nextLine().trim();

        int id = ++lastId;

        articles.add(new Article(id, title, content));

        System.out.printf("%d번 게시물이 등록되었습니다.\n", id);
    }

    public void listArticle() {
        System.out.println("번호 | 제목 | 최초 등록일 | 최근 수정일");
        System.out.println("--------------------------------------------------------------------------------------------------------------");

        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            System.out.printf("%d | %s | %s | %s\n", article.getId(), article.getTitle(), article.getRegDate(), article.getModDate());
        }
    }

    public void showDetail(int id) {
        Article article = findById(id);

        if (article == null) {
            System.out.printf("%d번 게시글이 존재하지 않습니다.\n", id);
            return;
        }
        System.out.printf("번호 : %d\n", article.getId());
        System.out.printf("제목 : %s\n", article.getTitle());
        System.out.printf("내용 : %s\n", article.getContent());
        System.out.printf("등록일 : %s\n", article.getRegDate());
        System.out.printf("수정일 : %s\n", article.getModDate());
    }

    public void updateArticle(int id) {
        Article article = findById(id);

        if (article == null) {
            System.out.printf("%d번 게시글이 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("제목(기존: %s): ", article.getTitle());
        String title = scanner.nextLine().trim();

        System.out.printf("내용(기존: %s): ", article.getContent());
        String content = scanner.nextLine().trim();

        if (!title.isEmpty()) article.setTitle(title);
        if (!content.isEmpty()) article.setContent(content);
        article.setModDate(LocalDateTime.now());

        System.out.printf("%d번 게시글이 수정되었습니다.\n", id);

    }

    public void deleteArticle(int id) {
        Article article = findById(id);

        if (article == null) {
            System.out.printf("%d번 게시글이 존재하지 않습니다.\n", id);
            return;
        }

        articles.remove(article);
        System.out.printf("%d번 게시글이 삭제되었습니다.\n", id);
    }

    public void helpArticle() {
        System.out.println("명령어 모음");
        System.out.println("등록 : write");
        System.out.println("목록 : list");
        System.out.println("상세 : detail {id}");
        System.out.println("수정 : update {id}");
        System.out.println("삭제 : delete {id}");
        System.out.println("종료 : exit");
    }

    private Article findById(int id) {
        for (Article article : articles) {
            if (article.getId() == id) return article;
        }
        return null;
    }


    public void exitArticle() {
        System.out.println("프로그램을 종료합니다.");
    }
}
