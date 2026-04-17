import com.Article;
import com.Articles;
import util.Rq;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private final Scanner scanner;
    private final Articles articles;

    public App(Scanner scanner) {
        this.scanner = scanner;
        this.articles = new Articles(scanner);
    }

    public void run() {

        System.out.println("== 자바 텍스트 게시판 시작 ==");


        while (true) {
            System.out.println("명령) ");
            Rq rq = new Rq(scanner.nextLine().trim());

            switch (rq.getCmd()) {
                case "write" -> articles.writeArticle();
                case "list" -> articles.listArticle();
                case "help" -> articles.helpArticle();
                case "detail" -> articles.showDetail(rq.getId());
                case "update" -> articles.updateArticle(rq.getId());
                case "delete" -> articles.deleteArticle(rq.getId());
                case "exit" -> {
                    articles.exitArticle();
                    return;

                }
            }
        }
    }
}