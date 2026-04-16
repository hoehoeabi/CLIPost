import domain.article.ArticleController;
import domain.system.SystemController;

import java.util.Scanner;

public class AppContext {
    public static final Scanner sc;
    public static final ArticleController articleController;
    public static final SystemController systemController;

    static {
        sc = new Scanner(System.in);
        articleController = new ArticleController();
        systemController = new SystemController();
    }

}

