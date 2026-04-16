import controller.ArticleController;
import global.dto.Rq;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class App {

    private final Scanner sc;
    private final Map<String, Consumer<Rq>> commandMap = new HashMap<>();

    public App(Scanner sc) { // 외부에서 주입받도록 변경
        this.sc = sc;
    }

    private void initCommandMap(ArticleController articleController) {
        commandMap.put("write", rq -> articleController.doWrite()); // doWrite()는 인자가 없으므로 람다 처리
        commandMap.put("list", articleController::showList);
        commandMap.put("detail", articleController::showDetail);
        commandMap.put("update", articleController::doModify);
        commandMap.put("delete", articleController::doDelete);
        commandMap.put("search", articleController::doSearch);
        commandMap.put("help", rq -> articleController.showHelp()); // doWrite()랑 동일
    }

    public void run() {
        Container.init(this.sc);
        ArticleController articleController = Container.getArticleController();
        initCommandMap(articleController);

        System.out.println("== 자바 텍스트 게시판 시작 ==");
        articleController.showHelp();

        while (true) {
            System.out.print("명령어: ");
            String command = sc.nextLine().trim();
            if (command.isEmpty()) continue;

            Rq rq = new Rq(command);
            String actionPath = rq.getActionPath();

            if (actionPath.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                Container.scClose();
                break;
            }

            Consumer<Rq> action = commandMap.get(actionPath);
            if (action != null) {
                action.accept(rq);
            } else {
                System.out.println("존재하지 않는 명령어입니다. 'help'를 입력해보세요.");
            }

        }
    }
}
