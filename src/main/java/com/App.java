package com;

import java.util.Scanner;

public class App {
    ArticleService articleService = new ArticleService();

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("명령어) ");
            Rq rq = new Rq(scanner.nextLine().trim());

            switch (rq.cmd) {
                case "exit": doExit(); return;
                case "write": doWrite(scanner); break;
                case "list": doList(); break;
                case "detail": doDetail(rq.id); break;
                case "update": doUpdate(scanner, rq.id); break;
                case "delete": doDelete(rq.id); break;
                case "view": doView(); break;
                default: System.out.println("알 수 없는 명령어입니다."); break;
            }
        }
    }

    private void doExit() {
        System.out.println("프로그램을 종료합니다.");
    }

    private void doWrite(Scanner scanner) {
        System.out.print("제목 : ");
        String title = scanner.nextLine().trim();
        System.out.print("내용 : ");
        String content = scanner.nextLine().trim();
        articleService.writeArticle(title, content);
        System.out.println("게시글이 작성되었습니다.");
    }

    private void doList() {
        System.out.println("번호 / 제목 / 작성일 / 조회수");
        System.out.println("---------------------");
        for (Article article : articleService.listArticles()) {
            System.out.printf("%d / %s / %s / %d\n", article.id, article.title, article.regDate, article.count);
        }
    }

    private void doDetail(int id) {
        articleService.increaseCount(id);
        Article article = articleService.showDetail(id);
        if (article != null) {
            System.out.printf("번호 : %d\n", article.id);
            System.out.printf("제목 : %s\n", article.title);
            System.out.printf("내용 : %s\n", article.content);
            System.out.printf("작성일 : %s\n", article.regDate);
            System.out.printf("조회수 : %d\n", article.count);
        } else {
            System.out.println("해당 번호의 게시글이 없습니다.");
        }
    }

    private void doUpdate(Scanner scanner, int id) {
        Article article = articleService.showDetail(id);
        System.out.printf("제목 (현재: %s): ", article.title);
        String title = scanner.nextLine().trim();
        System.out.printf("내용 (현재: %s): ", article.content);
        String content = scanner.nextLine().trim();
        articleService.updateArticle(id, title, content);
        System.out.println("게시글이 수정되었습니다.");
    }

    private void doDelete(int id) {
        if (articleService.deleteArticle(id)) {
            System.out.println("게시글이 삭제되었습니다.");
        } else {
            System.out.println("해당 번호의 게시글이 없습니다.");
        }
    }

    private void doView() {
        System.out.println("번호 / 제목 / 작성일 / 조회수");
        System.out.println("---------------------");
        for (Article article : articleService.sortByCount()) {
            System.out.printf("%d / %s / %s / %d\n", article.id, article.title, article.regDate, article.count);
        }
    }
}
