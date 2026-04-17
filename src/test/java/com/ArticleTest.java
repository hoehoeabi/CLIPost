package com;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ArticleTest {

    @Test
    void Article객체생성() {
        Article article = new Article(1, "제목", "내용", "2025-08-03");

        assertThat(article.id).isEqualTo(1);
        assertThat(article.title).isEqualTo("제목");
        assertThat(article.content).isEqualTo("내용");
        assertThat(article.regDate).isEqualTo("2025-08-03");
    }
}