package com.gg;

import com.gg.domain.article.ArticleController;
import com.gg.domain.system.SystemController;

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
                case "detail" -> articleController.showDetail(rq.getId());
                case "update" -> articleController.updateArticle(rq.getId());
                case "delete" -> articleController.deleteArticle(rq.getId());
                case "exit" -> {
                    systemController.actionExit();
                    return;
                }

            }
        }


    }
}
