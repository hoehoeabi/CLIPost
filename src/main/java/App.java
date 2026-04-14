import java.util.Scanner;

public class App{

    void run(){
        Scanner scanner = AppContext.scanner;
        ArticleController articleController = AppContext.articleController;

        while(true) {
            System.out.print("명령어) ");
            String[] cmd = scanner.nextLine().trim().split(" ");
            String action = cmd[0];
            String str_id = cmd.length > 1 ? cmd[1] : "";
            int id = str_id.isEmpty() ? 0 : Integer.parseInt(str_id);

            switch(action){
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
                    articleController.showDetail(id);
                    break;
                }
                case("update"): {
                    articleController.updateArticle(id);
                    break;
                }
                case("delete"): {
                    articleController.deleteArticle(id);
                    break;
                }
                case("help"): {

                }
            }
        }
    }
}
