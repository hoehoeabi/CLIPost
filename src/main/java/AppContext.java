import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppContext {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Article> articleList = new ArrayList<>();
    public static ArticleService articleService = new ArticleService();
    public static ArticleController articleController = new ArticleController();
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
}
