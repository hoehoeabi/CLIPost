import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AppContext {
    public static Scanner scanner = new Scanner(System.in);
    public static ArticleController articleController = new ArticleController();
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
}
