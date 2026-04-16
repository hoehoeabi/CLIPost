import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class AppTest {

    @Test
    @DisplayName("전체 시나리오: 등록 -> 목록 -> 상세 -> 수정 -> 삭제")
    void t1() {
        // given
        String input = """
        write
        제목1
        내용1
        write
        제목2
        내용2
        list?page=1&pagesize=5
        detail?id=1
        update?id=2
        수정제목
        수정내용
        delete?id=1
        list?page=1
        exit
        """;

        // when
        String rs = AppTestRunner.run(input);
        System.out.println(rs); // 디버깅용 출력

        // then
        assertThat(rs).contains("1번 게시글이 삭제되었습니다.");
        assertThat(rs).contains("2번 게시글이 수정되었습니다.");

        // 마지막 list 출력 부분 검증을 위한 인덱스 찾기
        int lastListIndex = rs.lastIndexOf("번호 | 제목"); // 좀 더 짧은 키워드로 검색 시도

        if (lastListIndex != -1) {
            String lastResult = rs.substring(lastListIndex);
            assertThat(lastResult).doesNotContain("1 | 제목1");
            assertThat(lastResult).contains("2 | 수정제목");
        } else {
            // 만약 못 찾았다면 전체 결과에서라도 확인 (fail 방지용)
            assertThat(rs).contains("2 | 수정제목");
            // 왜 못 찾았는지 에러 메시지에 힌트 제공정
            Assertions.fail("목록 출력 헤더('번호 | 제목')를 찾지 못해 substring 검증에 실패했습니다.");
        }

        assertThat(rs).contains("1 / 1");
    }

    @Test
    @DisplayName("명령어 도ㅁ움말 확인")
    void t2() {
        String rs = AppTestRunner.run("help");

        assertThat(rs)
                .contains("=== 명령어 도움말 ===")
                .contains("등록 : write")
                .contains("종료 : exit");
    }
}