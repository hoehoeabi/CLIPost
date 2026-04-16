# CLIPost

---

## 🎯 개요

이 과제는 **Java 콘솔 프로그램**으로 간단한 텍스트 게시판을 구현하는 프로젝트입니다.
Java 기본 문법, 클래스 및 객체지향 설계, 사용자 입력 처리, 그리고 데이터 저장 구조(ArrayList 등)를 연습합니다.

---

## 🧩 전체 기능  및 명령어
- 게시글 작성 :write
  - 명령어 입력 시 제목/내용을 받아 새 게시글 생성
- 게시글 목록 :list
  - 명령어 입력 시 모든 게시글을 번호 역순으로 출력
- 게시글 상세보기	: detail [id]
  - 명령어로 특정 게시글 내용을 전체 확인
- 게시글 수정	: update [id]
  - 명령어로 제목/내용을 수정
- 게시글 삭제	: delete [id]
  - 명령어로 해당 글 삭제
- 명령어 목록 : help
  - 명령어들을 확인
- 종료	: exit
  - 명령어로 프로그램 종료

---

## 게시글 객체 구조
```java
class Article {
    int id;
    String title;
    String content;
    LocalDateTime regDate;
    LocalDateTime modDate;
}
```

---

## ⚙️ 주요 클래스 및 파일 구조 예시
```
src
 └─main
     └─java
         └─com
             │  App.java
             │  AppContext.java
             │  Main.java
             │  
             ├─Article
             │      Article.java
             │      ArticleController.java
             │      ArticleService.java
             │      
             └─util
                     Rq.java
```

---

## 🧠 메서드 설계 예시

| 메서드명                                | 설명                       |
|:------------------------------------|:-------------------------|
| run()                               | 앱 실행 루프 (입력 대기 및 명령어 처리) |
| writeArticle()                      | 게시글 작성 처리                |
| listArticles()                      | 게시글 목록 출력                |
| showDetail(int id)                  | 특정 글 상세 내용 출력            |
| updateArticle(int id)               | 게시글 수정 처리                |
| deleteArticle(int id)               | 게시글 삭제 처리                |
| checkId(int id)                     | 게시글 존재 여부 확인 및 반환        |
| showCommands()                      | 명령어들 출력                  |
| write(String title, String content) | 실제 게시글 작성 처리             |
| update(Article article, String newTitle, String newContent)                       | 실제 게시글 수정 처리             |
| delete(Article article) | 실제 게시글 삭제 처리             |
--- 

## 💬 실행 예시
```
== 자바 텍스트 게시판 시작 ==
명령어 모음
등록: write
목록: list
상세: detail [id]
수정: update [id]
삭제: delete [id]
도움: help
종료: exit

명령어) write
제목: first
내용: class
1번 게시글이 등록되었습니다.

명령어) write
제목: second
내용: class2
2번 게시글이 등록되었습니다.

명령어) update 1
제목(기존) : first
제목: first upadte
내용(기존) : class
내용: class update
1번 게시글이 수정되었습니다.

명령어) list
 번호 | 제목 | 등록일 | 수정일
--------------------------------
 2 | second | 2026-04-13 16:38 | 
 1 | first upadte | 2026-04-13 16:38 | 2026-04-13 16:39
 
명령어: delete 2
2번 게시글이 삭제되었습니다.

명령어) list
 번호 | 제목 | 등록일 | 수정일
--------------------------------
 1 | first upadte | 2026-04-13 16:38 | 2026-04-13 16:39
 
명령어) exit
프로그램을 종료합니다.
```

---


