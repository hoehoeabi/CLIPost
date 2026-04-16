package global.standard;

public class Msg {
    // 에러 및 경고 메시지
    public static final String INPUT_KEYWORD = "검색어를 입력해주세요.";
    public static final String INVALID_ID = "올바른 ID를 입력해주세요.";

    // ARTICLE 관련 성공 메시지
    public static final String ARTICLE_WRITE_SUCCESS = "%d번 게시글이 등록되었습니다.\n";
    public static final String ARTICLE_MODIFY_SUCCESS = "%d번 게시글이 수정되었습니다.\n";
    public static final String ARTICLE_DELETE_SUCCESS = "%d번 게시글이 삭제되었습니다.\n";

    // 데이터 없음 안내
    public static final String ARTICLE_LIST_EMPTY = "현재 등록된 게시글이 없습니다.";
    public static final String ARTICLE_SEARCH_NOT_FOUND = "'%s' : '%s'(으)로 검색된 결과가 없습니다.";

    // 뷰 타이틀 및 헤더
    public static final String ARTICLE_LIST_TITLE = "전체 목록";
    public static final String ARTICLE_SEARCH_TITLE_FORMAT = "[%s] 검색 결과 (키워드: %s)";
}