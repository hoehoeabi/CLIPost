import util.Rq;

import java.util.Scanner;

public class App{

    void run(){
        Scanner scanner = AppContext.scanner;
        ArticleController articleController = AppContext.articleController;

        while(true) {
            System.out.print("명령어) ");
            String cmd = scanner.nextLine().trim();
            Rq rq = new Rq(cmd);

            switch(rq.getAction()){
                case("exit"): {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                case("write"): {
                    articleController.writeArticle();
                    break;
                }
                case("list"): {
                    articleController.listArticles();
                    break;
                }
                case("detail"): {
                    articleController.showDetail(rq.getId());
                    break;
                }
                case("update"): {
                    articleController.updateArticle(rq.getId());
                    break;
                }
                case("delete"): {
                    articleController.deleteArticle(rq.getId());
                    break;
                }
                case("help"): {
                    articleController.showCommands();
                }
            }
        }
    }
}
