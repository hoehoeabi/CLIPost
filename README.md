# 📝 CLI Java 게시판

Java 콘솔 환경에서 동작하는 **텍스트 기반 게시판 서비스**입니다.  
사용자의 명령어 입력을 기반으로 게시글을 생성, 조회, 수정, 삭제할 수 있습니다.

---

## 🎯 주요 기능

- 게시글 작성 (`write`)
- 게시글 목록 조회 (`list`)
- 게시글 상세 조회 (`detail [id]`)
- 게시글 수정 (`update [id]`)
- 게시글 삭제 (`delete [id]`)
- 프로그램 종료 (`exit`)

---

## 🧩 프로젝트 구조


```
src/main/java/com/gg
├── App.java // 실행 로직 및 명령어 처리
├── AppContext.java// 공통 객체 관리 (Controller, Service 등)
├── Article.java // 게시글 도메인 객체
├── Main.java // 프로그램 시작점
├── Rq.java // 사용자 입력 명령어 파싱
└── domain
    ├── article
    │   ├── ArticleController.java
    │   ├── ArticleRepository.java
    │   └── ArticleService.java
    └── system
        └── SystemController.java

```


---

## 🧠 설계 구조

- **Controller**
  - 사용자 입력 처리 및 출력 담당

- **Service**
  - 비즈니스 로직 수행

- **Repository**
  - `ArrayList`를 활용한 데이터 저장 및 관리

---

## 📦 데이터 구조

```java
class Article {
    int id;
    String title;
    String content;
    LocalDateTime regDate;
    LocalDateTime modifiedDate;
}
````
- `regDate` : 게시글 생성 시점
- `modifiedDate` : 수정 시 갱신 (없으면 null)
## ⚙️ 주요 구현 포인트

### ✔️ 1. 명령어 파싱 (Rq 클래스)
- `"detail 1"` 형태의 입력을 분리
- `action + id` 구조로 처리
- id 없거나 잘못된 경우 `-1`로 처리

### ✔️ 2. 날짜 처리
- `LocalDateTime`으로 데이터 저장
- 출력 시 `DateTimeFormatter`를 활용해 포맷 적용
- 수정 시 `modifiedDate` 갱신

### ✔️ 3. 예외 처리
- id 미입력 (`-1`)
- 존재하지 않는 게시글
- 잘못된 입력 값 처리

### ✔️ 4. 리스트 출력
- 최신 게시글이 위로 오도록 역순 출력

---

## 💬 실행 예시

```text
명령어: write
제목: 자바 공부
내용: 자바 텍스트 게시판 만들기
=> 게시글이 등록되었습니다.

명령어: list
번호 | 제목       | 등록일
-----------------------------
1    | 자바 공부  | 2025-08-03

명령어: detail 1
번호: 1
제목: 자바 공부
내용: 자바 텍스트 게시판 만들기
등록일: 2025-08-03

명령어: update 1
제목 (현재: 자바 공부): Java 게시판
내용 (현재: 자바 텍스트 게시판 만들기): 콘솔 기반으로 구현
=> 게시글이 수정되었습니다.

명령어: delete 1
=> 게시글이 삭제되었습니다.

명령어: exit
프로그램을 종료합니다.
```

## 🚀 실행 방법

```bash
./gradlew run
```

## 🎯 배운 점

- CLI 기반 서비스에서 사용자 입력 흐름 처리 경험
- Controller / Service / Repository 구조를 통한 계층 분리 설계
- LocalDateTime과 포맷팅을 통한 데이터 표현과 저장 분리
- 예외 처리를 통한 안정적인 프로그램 흐름 제어

---

## 🔥 개선 방향

- 파일 또는 DB 기반 데이터 영속성 추가
- 검색 기능 (키워드 기반 필터링)
- 페이징 처리
- 테스트 코드 추가 (JUnit)