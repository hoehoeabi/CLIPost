package view;

import domain.Article;
import global.dto.Page;
import java.time.format.DateTimeFormatter;

public class ArticleView {
    private final DateTimeFormatter DATE_FORMATTER;

    public ArticleView(DateTimeFormatter DATE_FORMATTER) {
        this.DATE_FORMATTER = DATE_FORMATTER;
    }

    public void printPageResult(Page<Article> page, String title, String emptyMsg) {
        if (page.getContent().isEmpty()) {
            System.out.println(emptyMsg);
            return;
        }

        System.out.println("--- " + title + " ---");
        System.out.println("번호 | 제목 | 조회수 | 등록일");
        page.getContent().forEach(a ->
                System.out.printf("%d | %s | %d | %s\n",
                        a.getId(), a.getTitle(), a.getCount(), a.getRegDate().format(DATE_FORMATTER)));

        System.out.printf("--- 현재 페이지: %d / %d ---\n",
                page.getCurrentPage(), page.getTotalPages());
    }

    public void printArticleDetail(Article article) {
        String regDate = article.getRegDate().format(DATE_FORMATTER);
        String modDate = article.getModDate().format(DATE_FORMATTER);

        System.out.println("--- 게시글 상세 내용 ---");
        System.out.printf("번호: %d\n", article.getId());
        System.out.printf("제목: %s\n", article.getTitle());
        System.out.printf("내용: %s\n", article.getContent());
        System.out.printf("조회수: %d\n", article.getCount());
        System.out.printf("등록일: %s\n", regDate);
        System.out.printf("수정일: %s\n", modDate);
        System.out.println("-----------------------");
    }

    public void printHelp() {
        System.out.println("\n=== 명령어 도움말 ===");
        System.out.println("등록 : write");
        System.out.println("목록 : list?page=1&pagesize=5");
        System.out.println("상세 : detail?id=1");
        System.out.println("수정 : update?id=1");
        System.out.println("삭제 : delete?id=1");
        System.out.println("검색 : search?target=title&keyword=자바&page=1");
        System.out.println("  - target : title(제목), content(내용), all(전체)");
        System.out.println("도움 : help");
        System.out.println("종료 : exit");
        System.out.println("====================\n");
    }
}