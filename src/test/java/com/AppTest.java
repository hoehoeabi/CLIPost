package com;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AppTest {
    ArticleService articleService;

    @BeforeEach
    void setUP() {
        articleService = new ArticleService();
    }

    @Test
    void 게시글작성() {
        articleService.writeArticle("첫번째", "내용1");
        assertThat(articleService.articles.size()).isEqualTo(1);
        assertThat(articleService.articles.get(0).title).isEqualTo("첫번째");
    }

    @Test
    void 게시글작성_id증가() {
        articleService.writeArticle("첫번째", "내용1");
        articleService.writeArticle("두번째", "내용2");

        assertThat(articleService.articles.get(0).id).isEqualTo(1);
        assertThat(articleService.articles.get(1).id).isEqualTo(2);
    }

    @Test
    void 게시글목록() {
        articleService.writeArticle("첫번째", "내용1");
        articleService.writeArticle("두번째", "내용2");
    }

    @Test
    void 게시글상세보기() {
        articleService.writeArticle("첫번째", "내용1");

        Article article = articleService.showDetail(1);

        assertThat(article.title).isEqualTo("첫번째");
        assertThat(article.content).isEqualTo("내용1");
    }

    @Test
    void 게시글수정() {
        articleService.writeArticle("첫번째", "내용1");

        articleService.updateArticle(1, "수정제목", "수정내용");

        Article article = articleService.showDetail(1);
        assertThat(article.title).isEqualTo("수정제목");
        assertThat(article.content).isEqualTo("수정내용");
    }

    @Test
    void 게시글삭제() {
        articleService.writeArticle("첫번째", "내용1");

        articleService.deleteArticle(1);

        assertThat(articleService.articles.size()).isEqualTo(0);
    }

    @Test
    void 조회수증가() {
        articleService.writeArticle("자바 공부", "내용입니다");

        articleService.increaseCount(1);

        Article article = articleService.showDetail(1);
        assertThat(article.count).isEqualTo(1);
    }

    @Test
    void 조회수순정렬() {
        articleService.writeArticle("첫번째", "내용1");
        articleService.writeArticle("두번째", "내용2");
        articleService.writeArticle("세번째", "내용3");

        articleService.showDetail(1);
        articleService.showDetail(2);
        articleService.showDetail(2);
        articleService.showDetail(3);
        articleService.showDetail(3);
        articleService.showDetail(3);

        ArrayList<Article> sorted = articleService.sortByCount();

        assertThat(sorted.get(0).id).isEqualTo(3);
        assertThat(sorted.get(1).id).isEqualTo(2);
        assertThat(sorted.get(2).id).isEqualTo(1);
    }
}