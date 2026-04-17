package com.gg;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Article {
    int id;
    String title;
    String content;
    LocalDateTime regDate;  //객체에 원본을 넣고 출력할 때 format -> 정렬, 포맷 변경 시 용이하게 하기 위함.
    private LocalDateTime modifiedDate; // 수정일

    public Article(int id, String title, String content, LocalDateTime regDate){
        this.id = id;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
        this.modifiedDate = null;
    }

    public String getRegDateFormatted(){
        return regDate.format(AppContext.forPrintDateTimeFormatter);
    }

    public String getModifiedDateFormatted() {
        return modifiedDate.format(AppContext.forPrintDateTimeFormatter);
    }
}