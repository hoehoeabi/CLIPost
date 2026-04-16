import domain.article.ArticleController;
import domain.system.SystemController;

import java.util.Scanner;

public class App {
    private final Scanner sc = AppContext.sc;

    public void run() {
        SystemController systemController = AppContext.systemController;
        ArticleController articleController = AppContext.articleController;
        while (true) {
            System.out.print("명령어: ");
            String cmd = sc.nextLine().trim();

            Rq rq = new Rq(cmd);

            switch (rq.getActionName()) {
                case "write" -> articleController.writeArticle();
                case "list" -> articleController.listArticles();
                case "detail" -> articleController.showDetail(rq);
                case "update" -> articleController.updateArticle(rq);
                case "delete" -> articleController.deleteArticle(rq);
                case "exit" -> {
                    systemController.actionExit();
                    return;
                }

            }
        }


    }
}
